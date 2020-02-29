package com.wiringpi.pin;

import com.wiringpi.gpio.Gpio;
import com.wiringpi.jni.SoftPwm;
import com.wiringpi.jni.SoftTone;
import com.wiringpi.jni.WiringPi;
import com.wiringpi.jni.WiringPiSetup;
import com.wiringpi.pin.modes.PinMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 树莓派管脚的映射关系。
 * <p>WiringPi &lt;-&gt; PhysPin &lt;-&gt; BcmPin</p>
 *
 * @author HouKunLin
 * @date 2020/2/13 0013 14:17
 */
public interface IPin {
    Logger logger = LoggerFactory.getLogger(IPin.class);

    /**
     * 把管脚转换成相应的管脚值
     *
     * @param iPin
     * @return
     */
    static int pin(IPin iPin) {
        switch (WiringPiSetup.getWpiMode()) {
            case WPI_MODE_PINS:
                return iPin.castTo(WiringPiPin.class).value();
            case WPI_MODE_PHYS:
                return iPin.castTo(PhysPin.class).value();
            default:
                return iPin.value();
        }
    }

    /**
     * 清理管脚状态信息
     */
    static void cleanPinStatus() {
        logger.info("正在清理 WiringPi 管脚信息");
        for (WiringPiPin wiringPiPin : WiringPiPin.values()) {
            int pin = wiringPiPin.pin();
            try {
                SoftPwm.softPwmStop(pin);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                SoftTone.softToneStop(pin);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                WiringPi.digitalWrite(pin, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                WiringPi.analogWrite(pin, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            // 非 ROOT 启动这里直接导致程序退出
            // WiringPi.pwmWrite(pin(PhysPin.p12), 0);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("清理 WiringPi 管脚完毕");
    }

    /**
     * 该管脚对应的物理管脚 ID
     *
     * @return
     */
    int physPin();

    /**
     * 管脚对应类型的默认 ID
     *
     * @return
     */
    int value();

    /**
     * 把当前的管脚类型强制转换到某个指定的管脚类型
     *
     * @param enumType
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    default <T extends IPin> T castTo(Class<T> enumType) {
        if (enumType.isAssignableFrom(getClass())) {
            return (T) this;
        }
        int physPin = physPin();
        T[] enumConstants = enumType.getEnumConstants();
        for (T enumConstant : enumConstants) {
            if (enumConstant.physPin() == physPin) {
                return enumConstant;
            }
        }
        return enumConstants[0];
    }

    /**
     * 通过对应关系，把管脚转换成当前 WiringPi 启动时（WiringPiSetup模式）的 PinId
     *
     * @return
     */
    default int pin() {
        return pin(this);
    }

    /**
     * 通过对应关系，把管脚转换成当前 WiringPi 启动时（WiringPiSetup模式）的 Gpio 对象
     *
     * @return
     */
    default Gpio gpio() {
        return Gpio.getInstance(this);
    }

    /**
     * 通过对应关系，把管脚转换成当前 WiringPi 启动时（WiringPiSetup模式）的 Gpio 对象
     *
     * @return
     */
    default Gpio gpio(PinMode pinMode) {
        Gpio instance = Gpio.getInstance(this);
        instance.pinMode(pinMode);
        return instance;
    }

    /**
     * 通过对应关系，把管脚转换成当前 WiringPi 启动时（WiringPiSetup模式）的 Gpio 对象
     *
     * @return
     */
    default Gpio gpio(PinMode pinMode, String title) {
        Gpio instance = Gpio.getInstance(this);
        instance.pinMode(pinMode);
        instance.setTitle(title);
        return instance;
    }
}
