package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.WpiModes;

/**
 * WiringPi 模式
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:49
 */
public enum WpiMode implements IMode {
    /**
     * WPI_MODE_PINS
     */
    WPI_MODE_PINS(WpiModes.WPI_MODE_PINS),
    WPI_MODE_GPIO(WpiModes.WPI_MODE_GPIO),
    WPI_MODE_GPIO_SYS(WpiModes.WPI_MODE_GPIO_SYS),
    WPI_MODE_PHYS(WpiModes.WPI_MODE_PHYS),
    WPI_MODE_PIFACE(WpiModes.WPI_MODE_PIFACE),
    WPI_MODE_UNINITIALISED(WpiModes.WPI_MODE_UNINITIALISED);

    private int value;

    WpiMode(int value) {
        this.value = value;
    }

    public static WpiMode valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (WpiMode enums : WpiMode.values()) {
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
