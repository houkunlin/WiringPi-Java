package com.wiringpi.pin;

import org.junit.Test;

public class GpioTest {
    @Test
    public void testToString() {
        for (IPin pin : WiringPiPin.values()) {
            System.out.println(pin.gpio());
        }
    }
}