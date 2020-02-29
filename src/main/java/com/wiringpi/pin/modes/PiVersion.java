package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.PiVersions;

/**
 * Pi 版本
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:57
 */
public enum PiVersion implements IMode {
    /**
     * PI_VERSION_1
     */
    PI_VERSION_1(PiVersions.PI_VERSION_1),
    PI_VERSION_1_1(PiVersions.PI_VERSION_1_1),
    PI_VERSION_1_2(PiVersions.PI_VERSION_1_2),
    PI_VERSION_2(PiVersions.PI_VERSION_2),
    ;

    private int value;

    PiVersion(int value) {
        this.value = value;
    }

    public static PiVersion valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (PiVersion enums : PiVersion.values()) {
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
