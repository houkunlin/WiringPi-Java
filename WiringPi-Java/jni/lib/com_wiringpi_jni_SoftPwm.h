/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_wiringpi_jni_SoftPwm */

#ifndef _Included_com_wiringpi_jni_SoftPwm
#define _Included_com_wiringpi_jni_SoftPwm
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_wiringpi_jni_SoftPwm
 * Method:    softPwmCreate
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_SoftPwm_softPwmCreate
  (JNIEnv *, jclass, jint, jint, jint);

/*
 * Class:     com_wiringpi_jni_SoftPwm
 * Method:    softPwmWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_SoftPwm_softPwmWrite
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_SoftPwm
 * Method:    softPwmStop
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_SoftPwm_softPwmStop
  (JNIEnv *, jclass, jint);

#ifdef __cplusplus
}
#endif
#endif
