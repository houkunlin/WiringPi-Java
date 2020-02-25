package com.wiringpi.gpio;

import com.wiringpi.jni.WiringPi;
import com.wiringpi.pin.modes.PinMode;
import com.wiringpi.pin.modes.PinValue;

public interface IGpio {
    int getPin();

    /**
     * @param mode
     * @see WiringPi#pinModeAlt
     */
    default void pinModeAlt(PinMode mode) {
        WiringPi.pinModeAlt(getPin(), mode.value());
    }

    /**
     * @param mode
     * @see WiringPi#pinMode
     */
    default void pinMode(PinMode mode) {
        WiringPi.pinMode(getPin(), mode.value());
    }


    /**
     * @return
     * @see WiringPi#digitalRead
     */
    default PinValue digitalRead() {
        return PinValue.valueOf(WiringPi.digitalRead(getPin()));
    }

    /**
     * @param value
     * @see WiringPi#digitalWrite
     */
    default void digitalWrite(PinValue value) {
        WiringPi.digitalWrite(getPin(), value.value());
    }


    /**
     * @return
     * @see WiringPi#digitalRead8
     */
    default int digitalRead8() {
        return WiringPi.digitalRead8(getPin());
    }

    /**
     * @param value
     * @see WiringPi#digitalWrite8
     */
    default void digitalWrite8(int value) {
        WiringPi.digitalWrite8(getPin(), value);
    }

    /**
     * @return
     * @see WiringPi#analogRead
     */
    default int analogRead() {
        return WiringPi.analogRead(getPin());
    }

    /**
     * @param value
     * @see WiringPi#analogWrite
     */
    default void analogWrite(int value) {
        WiringPi.analogWrite(getPin(), value);
    }
}
