#include "com_wiringpi_jni_WiringPi.h"
#include "Callback.h"
#include <wiringPi.h>

// java callback variables

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pinModeAlt
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pinModeAlt(JNIEnv *env, jclass clazz, jint pin, jint mode) {
    return pinModeAlt(pin, mode);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pinMode
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pinMode(JNIEnv *env, jclass clazz, jint pin, jint mode) {
    return pinMode(pin, mode);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pullUpDnControl
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pullUpDnControl(JNIEnv *env, jclass clazz, jint pin, jint pud) {
    return pullUpDnControl(pin, pud);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalRead
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_digitalRead(JNIEnv *env, jclass clazz, jint pin) {
    return digitalRead(pin);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_digitalWrite(JNIEnv *env, jclass clazz, jint pin, jint value) {
    return digitalWrite(pin, value);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalRead8
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_digitalRead8(JNIEnv *env, jclass clazz, jint pin) {
    return digitalRead8(pin);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalWrite8
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_digitalWrite8(JNIEnv *env, jclass clazz, jint pin, jint value) {
    return digitalWrite8(pin, value);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmWrite(JNIEnv *env, jclass clazz, jint pin, jint value) {
    return pwmWrite(pin, value);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    analogRead
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_analogRead(JNIEnv *env, jclass clazz, jint pin) {
    return analogRead(pin);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    analogWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_analogWrite(JNIEnv *env, jclass clazz, jint pin, jint value) {
    return analogWrite(pin, value);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    piGpioLayout
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_piGpioLayout(JNIEnv *env, jclass) {
    return piGpioLayout();
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    piBoardRev
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_piBoardRev(JNIEnv *env, jclass) {
    return piBoardRev();
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    wpiPinToGpio
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_wpiPinToGpio(JNIEnv *env, jclass clazz, jint wpiPin) {
    return wpiPinToGpio(wpiPin);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    physPinToGpio
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_physPinToGpio(JNIEnv *env, jclass clazz, jint physPin) {
    return physPinToGpio(physPin);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    setPadDrive
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_setPadDrive(JNIEnv *env, jclass clazz, jint group, jint value) {
    return setPadDrive(group, value);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    getAlt
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_getAlt(JNIEnv *env, jclass clazz, jint pin) {
    return getAlt(pin);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmToneWrite
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmToneWrite(JNIEnv *env, jclass clazz, jint pin, jint freq) {
    return pwmToneWrite(pin, freq);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmSetMode
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmSetMode(JNIEnv *env, jclass clazz, jint mode) {
    return pwmSetMode(mode);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmSetRange
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmSetRange(JNIEnv *env, jclass clazz, jint range) {
    return pwmSetRange(range);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    pwmSetClock
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_pwmSetClock(JNIEnv *env, jclass clazz, jint divisor) {
    return pwmSetClock(divisor);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    gpioClockSet
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_gpioClockSet(JNIEnv *env, jclass clazz, jint pin, jint freq) {
    return gpioClockSet(pin, freq);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalReadByte
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_digitalReadByte(JNIEnv *env, jclass) {
    return digitalReadByte();
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalReadByte2
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_digitalReadByte2(JNIEnv *env, jclass) {
    return digitalReadByte2();
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalWriteByte
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_digitalWriteByte(JNIEnv *env, jclass clazz, jint value) {
    return digitalWriteByte(value);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    digitalWriteByte2
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_digitalWriteByte2(JNIEnv *env, jclass clazz, jint value) {
    return digitalWriteByte2(value);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    waitForInterrupt
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_waitForInterrupt(JNIEnv *env, jclass clazz, jint pin, jint mS) {
    return waitForInterrupt(pin, mS);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    wiringPiISR
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_wiringPiISR(JNIEnv *env, jclass clazz, jint pin, jint mode) {
    return wiringPiISR(pin, mode, funcs[pin]);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    piHiPri
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPi_piHiPri(JNIEnv *env, jclass clazz, jint pri) {
    return piHiPri(pri);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    delay
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_delay(JNIEnv *env, jclass clazz, jint howLong) {
    delay(howLong);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    delayMicroseconds
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_wiringpi_jni_WiringPi_delayMicroseconds(JNIEnv *env, jclass clazz, jint howLong) {
    delayMicroseconds(howLong);
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    millis
 * Signature: ()I
 */
JNIEXPORT jlong JNICALL Java_com_wiringpi_jni_WiringPi_millis(JNIEnv *env, jclass clazz) {
    return (jlong) millis();
}

/*
 * Class:     com_wiringpi_jni_WiringPi
 * Method:    micros
 * Signature: ()I
 */
JNIEXPORT jlong JNICALL Java_com_wiringpi_jni_WiringPi_micros(JNIEnv *env, jclass clazz) {
    return (jlong) micros();
}