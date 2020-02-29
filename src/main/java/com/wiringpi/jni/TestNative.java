package com.wiringpi.jni;

public class TestNative {
    public static native void fun(int num, Runnable runnable);

    public static native void wiringPiISR(int pin, int mode, Runnable runnable);
}
