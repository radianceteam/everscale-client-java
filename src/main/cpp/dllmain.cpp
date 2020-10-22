// dllmain.cpp : Определяет точку входа для приложения DLL.
#include <stdio.h>
#include "pch.h"
#include "TONContext.h"
#include "ton_client.h"

jmethodID responseHandlerId;
jclass thisClass;
JavaVM* javaVM;

BOOL APIENTRY DllMain( HMODULE hModule,
                       DWORD  ul_reason_for_call,
                       LPVOID lpReserved
                     )
{
    switch (ul_reason_for_call)
    {
    case DLL_PROCESS_ATTACH:
    case DLL_THREAD_ATTACH:
    case DLL_THREAD_DETACH:
    case DLL_PROCESS_DETACH:
        break;
    }
    return TRUE;
}

tc_string_data_t tc_string(const char* string) {
    return tc_string_data_t{ string, (uint32_t)strlen(string) };
}

jstring jni_string(JNIEnv* env, tc_string_data_t string) {
    char* pChar = new char[string.len + 1];
    strncpy_s(pChar, (size_t)string.len+1, string.content, string.len);
    pChar[string.len] = 0;
    jstring result = env->NewStringUTF(pChar);
    delete[] pChar;
    return result;
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

JNIEXPORT jstring JNICALL Java_com_radiance_tonclient_TONContext_createContext(JNIEnv *env, jclass cls, jstring config) {
    env->GetJavaVM(&javaVM);
    thisClass = cls;
    responseHandlerId = env->GetStaticMethodID(cls, "responseHandler", "(ILjava/lang/String;IZ)V");
    tc_string_data_t cfg = {};
    cfg.content = "{12}";
    cfg.len = 0;
    const char* name = env->GetStringUTFChars(config, NULL);
    tc_string_handle_t* handle = tc_create_context(cfg);
    tc_string_data_t context = tc_read_string(handle);
    env->ReleaseStringUTFChars(config, name);
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


