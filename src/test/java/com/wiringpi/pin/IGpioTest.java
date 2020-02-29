package com.wiringpi.pin;

import org.junit.Test;

public class IGpioTest {

    @Test
    public void testIPinCastTo() {
        PhysPin[] values = PhysPin.values();
        System.out.println("Wpi\tBCMGPIO\tPhys");
        for (int i = 1; i < values.length; i += 2) {
            PhysPin physPin = values[i];
            System.out.println(String.format("%s\t\t%s\t\t%s",
                    physPin.castTo(WiringPiPin.class).value(),
                    physPin.castTo(BcmPin.class).value(),
                    physPin.value()));

        }
        System.out.println();
        System.out.println();
        System.out.println("Phys\tBCMGPIO\tWpi");
        for (int i = 2; i < values.length; i += 2) {
            PhysPin physPin = values[i];
            System.out.println(String.format("%s\t\t%s\t\t%s",
                    physPin.value(),
                    physPin.castTo(BcmPin.class).value(),
                    physPin.castTo(WiringPiPin.class).value()));

        }
    }
}