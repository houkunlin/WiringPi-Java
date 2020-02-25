/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_wiringpi_jni_WiringPiSetup */

#ifndef _Included_com_wiringpi_jni_WiringPiSetup
#define _Included_com_wiringpi_jni_WiringPiSetup
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_wiringpi_jni_WiringPiSetup
 * Method:    wiringPiSetup
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPiSetup_wiringPiSetup
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPiSetup
 * Method:    wiringPiSetupSys
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPiSetup_wiringPiSetupSys
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPiSetup
 * Method:    wiringPiSetupGpio
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPiSetup_wiringPiSetupGpio
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPiSetup
 * Method:    wiringPiSetupPhys
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPiSetup_wiringPiSetupPhys
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPiSetup
 * Method:    wiringPiSetupPiFace
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPiSetup_wiringPiSetupPiFace
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPiSetup
 * Method:    wiringPiSetupPiFaceForGpioProg
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPiSetup_wiringPiSetupPiFaceForGpioProg
  (JNIEnv *, jclass);

extern JavaVM *java_jvm;
extern jclass java_pin_callback_class;
extern jmethodID java_pin_callback_method;

#ifdef __cplusplus
}
#endif
#endif