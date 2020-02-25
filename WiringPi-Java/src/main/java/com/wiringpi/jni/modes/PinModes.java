package com.wiringpi.jni.modes;

/**
 * 管脚模式
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:03
 */
public class PinModes {
    /**
     * 输入引脚
     */
    public static final int INPUT = 0;
    /**
     * 输出引脚
     */
    public static final int OUTPUT = 1;
    /**
     * PWM 输出引脚
     */
    public static final int PWM_OUTPUT = 2;
    public static final int GPIO_CLOCK = 3;
    /**
     * 软件 PWM 输出引脚
     */
    public static final int SOFT_PWM_OUTPUT = 4;
    public static final int SOFT_TONE_OUTPUT = 5;
    public static final int PWM_TONE_OUTPUT = 6;
    /**
     * 低电平
     */
    public static final int LOW = 0;
    /**
     * 高电平
     */
    public static final int HIGH = 1;
}
