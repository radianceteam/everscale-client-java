#include <stdio.h>
#include <dlfcn.h>
#include <stdbool.h>
#include <string.h>
#include "ton_client.h"
#include "TONContext.h"

jmethodID responseHandlerId;
jclass thisClass;
JavaVM* javaVM;

typedef tc_string_handle_t* (*tc_create_context_func)(tc_string_data_t config);
typedef void (*tc_destroy_context_func)(uint32_t context);
typedef void (*tc_request_func)(uint32_t context, tc_string_data_t function_name, tc_string_data_t function_params_json, uint32_t request_id, tc_response_handler_t response_handler);
typedef void (*tc_destroy_string_func)(const tc_string_handle_t* handle);
typedef tc_string_data_t (*tc_read_string_func)(const tc_string_handle_t* handle);

tc_create_context_func tc_create_context;
tc_destroy_context_func tc_destroy_context;
tc_request_func tc_request;
tc_destroy_string_func tc_destroy_string;
tc_read_string_func tc_read_string;

tc_string_data_t tc_string(const char* string) {
    return tc_string_data_t { string, (uint32_t)strlen(string) };
}

jstring jni_string(JNIEnv* env, tc_string_data_t string) {
    char* pChar = new char[string.len + 1];
    strncpy(pChar, string.content, string.len);
    pChar[string.len] = 0;
    jstring result = env->NewStringUTF(pChar);
    delete[] pChar;
    return result;
}

JNIEXPORT jstring JNICALL Java_com_radiance_tonclient_TONContext_loadLibrary(JNIEnv *env, jclass, jstring jPath) {
    void *library;
    const char* path = env->GetStringUTFChars(jPath, NULL);
    
    library = dlopen(path, RTLD_LAZY);
    env->ReleaseStringUTFChars(jPath, path);
    if (!library) {
        //printf("dlopen() error: %s\n", dlerror());
        return env->NewStringUTF(dlerror());
    }
    tc_create_context = (tc_create_context_func)dlsym(library, "tc_create_context");
    tc_destroy_context = (tc_destroy_context_func)dlsym(library, "tc_destroy_context");
    tc_request = (tc_request_func)dlsym(library, "tc_request");
    tc_read_string = (tc_read_string_func)dlsym(library, "tc_read_string");
    tc_destroy_string = (tc_destroy_string_func)dlsym(library, "tc_destroy_string");
    return NULL;
}

void response_handler(uint32_t request_id, tc_string_data_t params_json, uint32_t response_type, bool finished) {
    //printf("response %d %d\n", request_id, response_type);
    JNIEnv* env;
    bool needDetach = false;

    int envStat = javaVM->GetEnv((void**)&env, JNI_VERSION_1_8);
    //printf("stat %d\n", envStat);
    if (envStat == JNI_EDETACHED) {
        javaVM->AttachCurrentThread((void**)&env, NULL);
        needDetach = true;
    }
    env->CallStaticVoidMethod(thisClass, responseHandlerId, request_id, jni_string(env, params_json), response_type, finished);

    if (needDetach) {
        javaVM->DetachCurrentThread();
    }
}

JNIEXPORT jstring JNICALL Java_com_radiance_tonclient_TONContext_createContext(JNIEnv *env, jclass cls, jstring jConfig) {
    env->GetJavaVM(&javaVM);
    thisClass = cls;
    responseHandlerId = env->GetStaticMethodID(cls, "responseHandler", "(ILjava/lang/String;IZ)V");
    const char* config = env->GetStringUTFChars(jConfig, NULL);
    tc_string_handle_t* handle = tc_create_context(tc_string(config));
    tc_string_data_t context = tc_read_string(handle);
    env->ReleaseStringUTFChars(jConfig, config);
    jstring result;
    result = jni_string(env, context);
    tc_destroy_string(handle);
    return result;
}

JNIEXPORT void JNICALL Java_com_radiance_tonclient_TONContext_destroyContext(JNIEnv* env, jclass cls, jint context) {
    tc_destroy_context(context);
}

JNIEXPORT void JNICALL Java_com_radiance_tonclient_TONContext_request(JNIEnv *env, jclass, jint context, jstring jName, jstring jParams, jint id) {
    const char* name = env->GetStringUTFChars(jName, NULL);
    const char* params = env->GetStringUTFChars(jParams, NULL);
    //printf("Request\n");
    tc_string_data_t tcName = tc_string_data_t { name, (uint32_t)strlen(name) };
    tc_request(context, tc_string(name), tc_string(params), id, response_handler);
    env->ReleaseStringUTFChars(jName, name);
    env->ReleaseStringUTFChars(jParams, params);
}
