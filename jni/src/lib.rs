#[macro_use]
extern crate lazy_static;
extern crate jni;
extern crate ton_client;

pub mod client {
    use ton_client::{ContextHandle, create_context, destroy_context, request};
    use jni::{JavaVM, JNIEnv};
    use jni::sys::{jint, JNI_VERSION_1_8};
    use jni::objects::{JClass, JString, JValue, JStaticMethodID};
    use std::sync::Mutex;
    use std::{os::raw::c_void, panic::catch_unwind};
    use parking_lot::Once;
    use jni::signature::{JavaType,Primitive};

    lazy_static! {
        static ref DATA: Mutex<Data> = Mutex::new(Data {jvm:None});
    }

    const INVALID_JNI_VERSION: jint = 0;
    const CONTEXT_CLASS_NAME: &str = "com/radiance/tonclient/TONContext";

    static INIT: Once = Once::new();
    static mut RESPONSE_HANDLER: Option<JStaticMethodID> = None;
    static mut CONTEXT_CLASS: Option<JClass> = None;

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
        _class: JClass<'static>,
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
            handler_callback,
        );
    }

    fn handler_callback(request_id: u32, params: String, response_type: u32, finished: bool) {
        if !INIT.state().done() {
            panic!("JNI cache is not initialized")
        }

        let wr = &DATA.lock().unwrap();
        let jvm = &wr.jvm.as_ref().unwrap();
        drop(wr);

        let env = jvm.attach_current_thread().unwrap();
        unsafe {
            env.call_static_method_unchecked(
                env.find_class(CONTEXT_CLASS_NAME)
                    .unwrap_or_else(|_| {
                        if env.exception_check().unwrap() {
                            env.exception_clear().unwrap();
                        }
                        CONTEXT_CLASS.unwrap()
                    }),
                RESPONSE_HANDLER.unwrap(),
                JavaType::Primitive(Primitive::Void),
                &[
                    JValue::Int(request_id as i32),
                    JValue::Object(env.new_string(params.as_str()).unwrap().into()),
                    JValue::Int(response_type as i32),
                    JValue::Bool(finished as u8),
                 ],
            ).unwrap();
        }
    }

    #[allow(non_snake_case)]
    #[no_mangle]
    pub extern "system" fn JNI_OnLoad(vm: JavaVM, _: *mut c_void) -> jint {

        let env = vm.get_env().expect("Cannot get reference to the JNIEnv");

        catch_unwind(|| {
            init_cache(&env);
            JNI_VERSION_1_8
        })
        .unwrap_or(INVALID_JNI_VERSION)
    }

    pub fn init_cache(env: &JNIEnv) {
        INIT.call_once(|| unsafe {
            CONTEXT_CLASS = Some(env
                .find_class(CONTEXT_CLASS_NAME)
                .map(|mid| mid.into_inner().into())
                .unwrap_or_else(|_| {
                    panic!("Class {} not found", CONTEXT_CLASS_NAME)
                })
            );

            RESPONSE_HANDLER = Some(env
                .get_static_method_id(
                    CONTEXT_CLASS_NAME,
                    "responseHandler",
                    "(ILjava/lang/String;IZ)V")
                .map(|mid| mid.into_inner().into())
                .unwrap_or_else(|_| {
                    panic!("Method responseHandler of class {} not found", CONTEXT_CLASS_NAME)
                })
            );
        });
    }
}
