package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.PwmModes;

/**
 * PWM 模式
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:45
 */
public enum PwmMode implements IMode {
    /**
     * MS
     */
    PWM_MODE_MS(PwmModes.PWM_MODE_MS),
    /**
     * BAL
     */
    PWM_MODE_BAL(PwmModes.PWM_MODE_BAL),
    ;

    private int value;

    PwmMode(int value) {
        this.value = value;
    }

    public static PwmMode valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (PwmMode enums : PwmMode.values()) {
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
