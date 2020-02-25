/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_wiringpi_jni_WiringPi */

#ifndef _Included_com_wiringpi_jni_WiringPi
#define _Included_com_wiringpi_jni_WiringPi
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pinModeAlt
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pinModeAlt
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pinMode
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pinMode
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pullUpDnControl
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pullUpDnControl
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalRead
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_digitalRead
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_digitalWrite
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalRead8
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_digitalRead8
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalWrite8
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_digitalWrite8
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmWrite
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    analogRead
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_analogRead
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    analogWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_analogWrite
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    piGpioLayout
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_piGpioLayout
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    piBoardRev
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_piBoardRev
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    wpiPinToGpio
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_wpiPinToGpio
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    physPinToGpio
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_physPinToGpio
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    setPadDrive
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_setPadDrive
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    getAlt
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_getAlt
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmToneWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmToneWrite
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmSetMode
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmSetMode
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmSetRange
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmSetRange
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmSetClock
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmSetClock
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    gpioClockSet
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_gpioClockSet
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalReadByte
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_digitalReadByte
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalReadByte2
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_digitalReadByte2
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalWriteByte
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_digitalWriteByte
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalWriteByte2
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_digitalWriteByte2
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    waitForInterrupt
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_waitForInterrupt
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    wiringPiISR
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_wiringPiISR
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    piHiPri
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_piHiPri
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    delay
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_delay
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    delayMicroseconds
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_delayMicroseconds
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    millis
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_com_wiringpi_jni_WiringPi_millis
  (JNIEnv *, jclass);

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    micros
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_com_wiringpi_jni_WiringPi_micros
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif