package com.wiringpi.jni;

import com.wiringpi.pin.BcmPin;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WiringPiSetupTest {
    private static final Logger logger = LoggerFactory.getLogger(WiringPiSetupTest.class);

    @Test
    public void callback() {
        Runnable runnable = () -> {
            logger.info("Runnable Run Method");
        };
        WiringPiSetup.addCallback(BcmPin.p20.pin(), (pin) -> {
            logger.info("在 p20 回调函数被触发：{}", pin);
        });
        TestNative.fun(BcmPin.p20.pin(), runnable);
        /*Gpio pin = BcmPin.p19.pin();
        pin.wiringPiISR(IntEdgeLevel.INT_EDGE_BOTH, (pinId) -> {
            logger.info("在 p19 回调函数被触发：{}", pin);
        });*/
    }

    @Test
    public void addCallback() {
    }
}