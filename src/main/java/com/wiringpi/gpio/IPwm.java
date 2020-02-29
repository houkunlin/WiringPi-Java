package com.wiringpi.gpio;

import com.wiringpi.jni.WiringPi;
import com.wiringpi.pin.modes.PwmMode;

public interface IPwm extends IGpio {

    /**
     * @param value
     * @see WiringPi#pwmWrite
     */
    default void pwmWrite(int value) {
        WiringPi.pwmWrite(getPin(), value);
    }

    /**
     * @param mode
     * @see WiringPi#pwmSetMode
     */
    default void pwmSetMode(PwmMode mode) {
        WiringPi.pwmSetMode(mode.value());
    }

    /**
     * @param range
     * @see WiringPi#pwmSetRange
     */
    default void pwmSetRange(int range) {
        WiringPi.pwmSetRange(range);
    }


    /**
     * @param divisor
     * @see WiringPi#pwmSetClock
     */
    default void pwmSetClock(int divisor) {
        WiringPi.pwmSetClock(divisor);
    }
}
