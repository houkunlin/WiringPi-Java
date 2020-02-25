package com.wiringpi.gpio;

import com.wiringpi.jni.Callback;
import com.wiringpi.jni.WiringPi;
import com.wiringpi.jni.WiringPiSetup;
import com.wiringpi.pin.BcmPin;
import com.wiringpi.pin.IPin;
import com.wiringpi.pin.PhysPin;
import com.wiringpi.pin.WiringPiPin;
import com.wiringpi.pin.modes.IntEdgeLevel;
import com.wiringpi.pin.modes.PinValue;
import com.wiringpi.pin.modes.PudMode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 管脚对象
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 19:06
 */
@Getter
@ToString
public class Gpio implements IGpio, IPwm, ISoftPwm, ISoftTone {
    private static final Logger logger = LoggerFactory.getLogger(Gpio.class);
    private static final Map<Integer, Gpio> INSTANCE_MAP = new HashMap<>();

    private int pin;
    private PhysPin physPin;
    private WiringPiPin wiringPiPin;
    private BcmPin bcmPin;
    /**
     * 在程序中标记这个Pin的名称，或者作用
     */
    @Setter
    private String title;

    public static Gpio getInstance(IPin iPin) {
        return INSTANCE_MAP.computeIfAbsent(iPin.pin(), pin -> new Gpio(iPin));
    }

    private Gpio(IPin iPin) {
        this.pin = iPin.pin();
        this.physPin = iPin.castTo(PhysPin.class);
        this.wiringPiPin = iPin.castTo(WiringPiPin.class);
        this.bcmPin = iPin.castTo(BcmPin.class);
    }

    /**
     * @param pud
     * @see WiringPi#pullUpDnControl
     */
    public void pullUpDnControl(PudMode pud) {
        WiringPi.pullUpDnControl(pin, pud.value());
    }

    /**
     * @return
     * @see WiringPi#getAlt
     */
    public int getAlt() {
        return WiringPi.getAlt(pin);
    }

    /**
     * @param freq
     * @see WiringPi#pwmToneWrite
     */
    public void pwmToneWrite(int freq) {
        WiringPi.pwmToneWrite(pin, freq);
    }

    /**
     * @param freq
     * @see WiringPi#gpioClockSet
     */
    public void gpioClockSet(int freq) {
        WiringPi.gpioClockSet(pin, freq);
    }

    /**
     * @param timeout ms
     * @return
     * @see WiringPi#waitForInterrupt
     */
    public int waitForInterrupt(int timeout) {
        return WiringPi.waitForInterrupt(pin, timeout);
    }

    /**
     * @param mode
     * @return
     * @see WiringPi#wiringPiISR
     */
    public int wiringPiISR(IntEdgeLevel mode, Callback callback) {
        // 先在这个 pin 上添加回调函数
        WiringPiSetup.addCallback(pin, callback);
        // 然后再调用系统底层接口
        return WiringPi.wiringPiISR(pin, mode.value());
    }

    public void low() {
        digitalWrite(PinValue.LOW);
    }

    public void high() {
        digitalWrite(PinValue.HIGH);
    }
}
