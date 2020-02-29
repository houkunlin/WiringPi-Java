package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.PinModes;

/**
 * 管脚模式
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 19:52
 */
public enum PinMode implements IMode {
    /**
     * 输入引脚
     */
    INPUT(PinModes.INPUT),
    /**
     * 输出引脚
     */
    OUTPUT(PinModes.OUTPUT),
    /**
     * PWM 输出引脚
     */
    PWM_OUTPUT(PinModes.PWM_OUTPUT),
    GPIO_CLOCK(PinModes.GPIO_CLOCK),
    /**
     * 软件 PWM 输出引脚
     */
    SOFT_PWM_OUTPUT(PinModes.SOFT_PWM_OUTPUT),
    SOFT_TONE_OUTPUT(PinModes.SOFT_TONE_OUTPUT),
    PWM_TONE_OUTPUT(PinModes.PWM_TONE_OUTPUT),
    ;

    private int value;

    PinMode(int value) {
        this.value = value;
    }

    public static PinMode valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (PinMode enums : PinMode.values()) {
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
