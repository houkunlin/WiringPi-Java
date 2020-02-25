package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.PinModes;

/**
 * 引脚值
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 19:54
 */
public enum PinValue implements IMode {
    /**
     * 低电平
     */
    LOW(PinModes.LOW),
    /**
     * 高电平
     */
    HIGH(PinModes.HIGH),
    ;
    private int value;

    PinValue(int value) {
        this.value = value;
    }

    public boolean isLow() {
        return value == LOW.value;
    }

    public boolean isHigh() {
        return value == HIGH.value;
    }

    public static PinValue valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (PinValue enums : PinValue.values()) {
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
