package com.wiringpi.jni;

/**
 * 软件形式的 PWM
 *
 * @author HouKunLin
 * @date 2020/2/13 0013 0:19
 */
public class SoftPwm {
    /**
     * 该函数将会创建一个软件控制的PWM管脚。可以使用任何一个GPIO管脚，pwmRange参数可以为0（关）~100（全开）。
     * 迒回值为0，代表成功，其他值，代表失败。
     *
     * @param pin
     * @param value
     * @param range
     * @return
     */
    public static native int softPwmCreate(int pin, int value, int range);

    /**
     * 该函数将会更新指定管脚的PWM值。value参数的范围将会被检查，如果指定的管脚乊前没有通过softPwmCreate初始化，将会被忽略。
     *
     * @param pin
     * @param value
     */
    public static native void softPwmWrite(int pin, int value);

    public static native void softPwmStop(int pin);
}
