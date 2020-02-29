package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.PiMakers;

/**
 * Pi Maker
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:58
 */
public enum PiMaker implements IMode {
    /**
     * PI_MAKER_SONY
     */
    PI_MAKER_SONY(PiMakers.PI_MAKER_SONY),
    PI_MAKER_EGOMAN(PiMakers.PI_MAKER_EGOMAN),
    PI_MAKER_EMBEST(PiMakers.PI_MAKER_EMBEST),
    PI_MAKER_UNKNOWN(PiMakers.PI_MAKER_UNKNOWN),
    ;

    private int value;

    PiMaker(int value) {
        this.value = value;
    }

    public static PiMaker valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (PiMaker enums : PiMaker.values()) {
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
