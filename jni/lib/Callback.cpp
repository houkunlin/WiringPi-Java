//
// Created by Administrator on 2020/2/13 0013.
//
#include "com_wiringpi_jni_WiringPiSetup.h"
#include "Callback.h"

#define MAX_GPIO_PINS 40

JavaWiringPiCallback funcs[] = {
        callback_00,
        callback_01,
        callback_02,
        callback_03,
        callback_04,
        callback_05,
        callback_06,
        callback_07,
        callback_08,
        callback_09,
        callback_10,
        callback_11,
        callback_12,
        callback_13,
        callback_14,
        callback_15,
        callback_16,
        callback_17,
        callback_18,
        callback_19,
        callback_20,
        callback_21,
        callback_22,
        callback_23,
        callback_24,
        callback_25,
        callback_26,
        callback_27,
        callback_28,
        callback_29,
        callback_30,
        callback_31,
        callback_32,
        callback_33,
        callback_34,
        callback_35,
        callback_36,
        callback_37,
        callback_38,
        callback_39,
        callback_40
};

/**
 * @link <a href="https://github.com/Pi4J/pi4j/blob/master/pi4j-native/src/main/native/com_pi4j_wiringpi_Gpio.c"> com_pi4j_wiringpi_Gpio.c </a>
 * @param pin
 */
void callback(int pin) {
    printf("\n底层有一个回调方法被调用，位置在 PinID = %d\n\n", pin);

    // validate pin range
    if (pin > MAX_GPIO_PINS) {
        printf("pin 值超出范围.\n");
        return;
    }

    // ensure that the JVM exists
    if (java_jvm == NULL) {
        printf("java_jvm 参数初始化失败.\n");
        return;
    }

    // ensure the ISR callback class is available
    if (java_pin_callback_class == NULL) {
        printf("java_pin_callback_class 回调对象初始化失败.\n");
        return;
    }

    // ensure the ISR callback method is available
    if (java_pin_callback_method == NULL) {
        printf("java_pin_callback_method 回调方法初始化失败.\n");
        return;
    }

    // attached to JVM thread
    JNIEnv *env;
    (*java_jvm).AttachCurrentThread((void **) &env, NULL);

    // clear any exceptions on the stack
    (*env).ExceptionClear();

    // invoke callback to java state method to notify event listeners
    (*env).CallStaticVoidMethod(java_pin_callback_class, java_pin_callback_method, pin);

    // clear any user caused exceptions on the stack
    if ((*env).ExceptionCheck()) {
        (*env).ExceptionClear();
    }

    // detach from thread
    (*java_jvm).DetachCurrentThread();
}

void callback_00() { callback(0); }

void callback_01() { callback(1); }

void callback_02() { callback(2); }

void callback_03() { callback(3); }

void callback_04() { callback(4); }

void callback_05() { callback(5); }

void callback_06() { callback(6); }

void callback_07() { callback(7); }

void callback_08() { callback(8); }

void callback_09() { callback(9); }

void callback_10() { callback(10); }

void callback_11() { callback(11); }

void callback_12() { callback(12); }

void callback_13() { callback(13); }

void callback_14() { callback(14); }

void callback_15() { callback(15); }

void callback_16() { callback(16); }

void callback_17() { callback(17); }

void callback_18() { callback(18); }

void callback_19() { callback(19); }

void callback_20() { callback(20); }

void callback_21() { callback(21); }

void callback_22() { callback(22); }

void callback_23() { callback(23); }

void callback_24() { callback(24); }

void callback_25() { callback(25); }

void callback_26() { callback(26); }

void callback_27() { callback(27); }

void callback_28() { callback(28); }

void callback_29() { callback(29); }

void callback_30() { callback(30); }

void callback_31() { callback(31); }

void callback_32() { callback(32); }

void callback_33() { callback(33); }

void callback_34() { callback(34); }

void callback_35() { callback(35); }

void callback_36() { callback(36); }

void callback_37() { callback(37); }

void callback_38() { callback(38); }

void callback_39() { callback(39); }

void callback_40() { callback(40); }
