/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_radiance_tonclient_TONContext */

#ifndef _Included_com_radiance_tonclient_TONContext
#define _Included_com_radiance_tonclient_TONContext
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_radiance_tonclient_TONContext
 * Method:    createContext
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_radiance_tonclient_TONContext_createContext
  (JNIEnv *, jclass, jstring);

/*
 * Class:     com_radiance_tonclient_TONContext
 * Method:    destroyContext
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_radiance_tonclient_TONContext_destroyContext
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_radiance_tonclient_TONContext
 * Method:    request
 * Signature: (ILjava/lang/String;Ljava/lang/String;I)V
 */
JNIEXPORT void JNICALL Java_com_radiance_tonclient_TONContext_request
  (JNIEnv *, jclass, jint, jstring, jstring, jint);

/*
 * Class:     com_radiance_tonclient_TONContext
 * Method:    requestSync
 * Signature: (ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_radiance_tonclient_TONContext_requestSync
  (JNIEnv *, jclass, jint, jstring, jstring);

#ifdef __cplusplus
}
#endif
#endif
