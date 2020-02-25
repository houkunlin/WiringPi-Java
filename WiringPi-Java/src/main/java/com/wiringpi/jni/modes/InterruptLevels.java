package com.wiringpi.jni.modes;

/**
 * 中断级别
 *
 * @author HouKunLin
 * @date 2020/2/13 0013 0:08
 */
public class InterruptLevels {
    /**
     * 未设置
     */
    public static final int INT_EDGE_SETUP = 0;
    /**
     * 下降沿
     */
    public static final int INT_EDGE_FALLING = 1;
    /**
     * 上升沿
     */
    public static final int INT_EDGE_RISING = 2;
    /**
     * 上升沿和下降沿
     */
    public static final int INT_EDGE_BOTH = 3;
}
