package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.InterruptLevels;

/**
 * 中断级别
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:52
 */
public enum IntEdgeLevel implements IMode {
    /**
     * 未设置
     */
    INT_EDGE_SETUP(InterruptLevels.INT_EDGE_SETUP),
    /**
     * 下降沿
     */
    INT_EDGE_FALLING(InterruptLevels.INT_EDGE_FALLING),
    /**
     * 上升沿
     */
    INT_EDGE_RISING(InterruptLevels.INT_EDGE_RISING),
    /**
     * 上升沿和下降沿
     */
    INT_EDGE_BOTH(InterruptLevels.INT_EDGE_BOTH),
    ;

    private int value;

    IntEdgeLevel(int value) {
        this.value = value;
    }

    public static IntEdgeLevel valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (IntEdgeLevel enums : IntEdgeLevel.values()) {
            if (value.equals(enums.value)) {
                return enums;
            }
        }
        return null;
    }

    @Override
    public int value() {
        return value;
    }
}
