package com.wiringpi.gpio;

import com.wiringpi.jni.SoftPwm;

public interface ISoftPwm extends IGpio {
    /**
     * @param value
     * @param range
     * @return
     * @see SoftPwm#softPwmCreate
     */
    default int softPwmCreate(int value, int range) {
        return SoftPwm.softPwmCreate(getPin(), value, range);
    }

    /**
     * @param value
     * @see SoftPwm#softPwmWrite
     */
    default void softPwmWrite(int value) {
        SoftPwm.softPwmWrite(getPin(), value);
    }

    /**
     * @see SoftPwm#softPwmStop
     */
    default void softPwmStop() {
        SoftPwm.softPwmStop(getPin());
    }
}
