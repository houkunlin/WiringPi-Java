/* DO NOT EDIT THIS FILE - it is machine generated */
#include "com_wiringpi_jni_WiringPiI2C.h"
#include  <wiringPiI2C.h>
#include "utils.h"

/*
 * Class:     com_wiringpi_jni_WiringPiI2C
 * Method:    wiringPiI2CRead
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPiI2C_wiringPiI2CRead(JNIEnv *env, jclass clazz, jint fd) {
    return wiringPiI2CRead(fd);
}

/*
 * Class:     com_wiringpi_jni_WiringPiI2C
 * Method:    wiringPiI2CReadReg8
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL
Java_com_wiringpi_jni_WiringPiI2C_wiringPiI2CReadReg8(JNIEnv *env, jclass clazz, jint fd, jint reg) {
    return wiringPiI2CReadReg8(fd, reg);
}

/*
 * Class:     com_wiringpi_jni_WiringPiI2C
 * Method:    wiringPiI2CReadReg16
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL
Java_com_wiringpi_jni_WiringPiI2C_wiringPiI2CReadReg16(JNIEnv *env, jclass clazz, jint fd, jint reg) {
    return wiringPiI2CReadReg16(fd, reg);
}

/*
 * Class:     com_wiringpi_jni_WiringPiI2C
 * Method:    wiringPiI2CWrite
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL
Java_com_wiringpi_jni_WiringPiI2C_wiringPiI2CWrite(JNIEnv *env, jclass clazz, jint fd, jint data) {
    return wiringPiI2CWrite(fd, data);
}

/*
 * Class:     com_wiringpi_jni_WiringPiI2C
 * Method:    wiringPiI2CWriteReg8
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL
Java_com_wiringpi_jni_WiringPiI2C_wiringPiI2CWriteReg8(JNIEnv *env, jclass clazz, jint fd, jint reg, jint data) {
    return wiringPiI2CWriteReg8(fd, reg, data);
}

/*
 * Class:     com_wiringpi_jni_WiringPiI2C
 * Method:    wiringPiI2CWriteReg16
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL
Java_com_wiringpi_jni_WiringPiI2C_wiringPiI2CWriteReg16(JNIEnv *env, jclass clazz, jint fd, jint reg, jint data) {
    return wiringPiI2CWriteReg16(fd, reg, data);
}

/*
 * Class:     com_wiringpi_jni_WiringPiI2C
 * Method:    wiringPiI2CSetupInterface
 * Signature: (Ljava/lang/String;I)I
 */
JNIEXPORT jint JNICALL
Java_com_wiringpi_jni_WiringPiI2C_wiringPiI2CSetupInterface(JNIEnv *env, jclass clazz, jstring device, jint devId) {
    return wiringPiI2CSetupInterface(jstring2cstr(env, device), devId);
}

/*
 * Class:     com_wiringpi_jni_WiringPiI2C
 * Method:    wiringPiI2CSetup
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_wiringpi_jni_WiringPiI2C_wiringPiI2CSetup(JNIEnv *env, jclass clazz, jint devId) {
    return wiringPiI2CSetup(devId);
}
