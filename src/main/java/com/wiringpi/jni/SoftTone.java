package com.wiringpi.jni;

/**
 * #include <softTone.h>
 *
 * @author HouKunLin
 * @date 2020/2/22 0022 14:12
 */
public class SoftTone {
    public static native int softToneCreate(int pin);

    public static native void softToneStop(int pin);

    public static native void softToneWrite(int pin, int freq);
}
