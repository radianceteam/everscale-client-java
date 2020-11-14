#[macro_use]
extern crate lazy_static;
extern crate jni;
extern crate ton_client;

pub mod client {
    use ton_client::{ContextHandle, create_context, destroy_context, request};
    use jni::{JavaVM, JNIEnv};
    use jni::sys::{jint};
    use jni::objects::{JClass, JString, JValue};
    use std::sync::{Mutex};

    lazy_static! {
        static ref DATA: Mutex<Data> = Mutex::new(Data {jvm:None});
    }

    struct Data {
        jvm: Option<JavaVM>,
    }

    impl Data {
        pub fn set_jvm(&mut self, jvm: JavaVM) {
            self.jvm = Some(jvm);
        }
    }

    #[allow(non_snake_case)]
    #[no_mangle]
    pub unsafe extern fn Java_com_radiance_tonclient_TONContext_createContext<'a>(
        env: JNIEnv<'a>,
        _class: JClass,
        config: JString
    ) -> JString<'a> {

        {
            let mut data = DATA.lock().unwrap();
            if  data.jvm.is_none() {
                data.set_jvm(env.get_java_vm().unwrap());
            }
        }

        env.new_string(
            create_context(env.get_string(config).unwrap().into())
        ).unwrap()
    }

    #[allow(non_snake_case)]
    #[no_mangle]
    pub unsafe extern fn Java_com_radiance_tonclient_TONContext_destroyContext(
        _env: JNIEnv,
        _class: JClass,
        context: jint,
    ) {
        destroy_context(context as ContextHandle)
    }

    #[allow(non_snake_case)]
    #[no_mangle]
    pub unsafe extern fn Java_com_radiance_tonclient_TONContext_request(
        env: JNIEnv,
        _class: JClass,
        context: jint,
        method: JString,
        params: JString,
        request_id: jint,
    ) {
        request(
            context as ContextHandle,
            env.get_string(method).unwrap().into(),
            env.get_string(params).unwrap().into(),
            request_id as u32,
            handler_callback
        );
    }

    fn handler_callback(request_id: u32, params: String, response_type: u32, finished: bool) {
        let wr = &DATA.lock().unwrap();
        let jvm = &wr.jvm.as_ref().unwrap();
        drop(wr);

        let env = jvm.attach_current_thread().unwrap();
        let class = env.find_class("com/radiance/tonclient/TONContext").unwrap();
        env.call_static_method(
            class,
            "responseHandler",
            "(ILjava/lang/String;IZ)V",
            &[
                JValue::Int(request_id as i32),
                JValue::Object(env.new_string(params.as_str()).unwrap().into()),
                JValue::Int(response_type as i32),
                JValue::Bool(finished as u8),
             ],
        ).unwrap();
    }
}


