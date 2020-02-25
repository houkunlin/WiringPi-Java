package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.PudModes;

/**
 * 拉电阻模式
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:42
 */
public enum PudMode implements IMode {
    /**
     * 关闭
     */
    PUD_OFF(PudModes.PUD_OFF),
    /**
     * 拉下
     */
    PUD_DOWN(PudModes.PUD_DOWN),
    /**
     * 拉上
     */
    PUD_UP(PudModes.PUD_UP),
    ;

    private int value;

    PudMode(int value) {
        this.value = value;
    }

    public static PudMode valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (PudMode enums : PudMode.values()) {
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
