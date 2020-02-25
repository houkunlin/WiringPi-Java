package com.wiringpi.pin.modes;

import com.wiringpi.jni.modes.PiModels;

/**
 * Pi 模式
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:46
 */
public enum PiModel implements IMode {
    /**
     * PI_GPIO_MASK
     */
    PI_GPIO_MASK(PiModels.PI_GPIO_MASK),
    PI_MODEL_A(PiModels.PI_MODEL_A),
    PI_MODEL_B(PiModels.PI_MODEL_B),
    PI_MODEL_AP(PiModels.PI_MODEL_AP),
    PI_MODEL_BP(PiModels.PI_MODEL_BP),
    PI_MODEL_2(PiModels.PI_MODEL_2),
    PI_ALPHA(PiModels.PI_ALPHA),
    PI_MODEL_CM(PiModels.PI_MODEL_CM),
    PI_MODEL_07(PiModels.PI_MODEL_07),
    PI_MODEL_3B(PiModels.PI_MODEL_3B),
    PI_MODEL_ZERO(PiModels.PI_MODEL_ZERO),
    PI_MODEL_CM3(PiModels.PI_MODEL_CM3),
    PI_MODEL_ZERO_W(PiModels.PI_MODEL_ZERO_W),
    PI_MODEL_3BP(PiModels.PI_MODEL_3BP),
    PI_MODEL_3AP(PiModels.PI_MODEL_3AP),
    PI_MODEL_CM3P(PiModels.PI_MODEL_CM3P),
    ;

    private int value;

    PiModel(int value) {
        this.value = value;
    }

    public static PiModel valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (PiModel enums : PiModel.values()) {
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
