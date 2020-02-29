package com.wiringpi.jni;

import com.wiringpi.pin.modes.WpiMode;
import com.wiringpi.utils.LibraryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WiringPiSetup
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 21:47
 */
public class WiringPiSetup {
    private static final Logger logger = LoggerFactory.getLogger(WiringPiSetup.class);
    private static final Map<Integer, List<Callback>> callback = new HashMap<>();
    private static WpiMode wpiMode = WpiMode.WPI_MODE_PINS;

    static {
        LibraryUtils.loadLibrary("WiringPi");
    }

    public static void callback(int pinId) {
        logger.debug("WiringPi 触发一个回调，回调 PinID = {}", pinId);
        for (Map.Entry<Integer, List<Callback>> entry : callback.entrySet()) {
            int key = entry.getKey();
            if (pinId == key) {
                List<Callback> value = entry.getValue();
                logger.debug("WiringPi 触发一个回调，回调 PinID = {}，该 PinID 共有 {} 个处理列表", pinId, value.size());
                value.forEach((callback1 -> callback1.accept(pinId)));
            }
        }
    }

    public static synchronized void addCallback(int pinId, Callback callback) {
        List<Callback> callbacks = WiringPiSetup.callback.computeIfAbsent(pinId, k -> new ArrayList<>());
        callbacks.add(callback);
        logger.debug("在 PinID {} 上添加一个回调处理，该 PinID 当前共有 {} 个回调处理器", pinId, callbacks.size());
    }

    public static synchronized void removeCallback(int pinId) {
        List<Callback> callbacks = WiringPiSetup.callback.computeIfAbsent(pinId, k -> new ArrayList<>());
        callbacks.clear();
        logger.debug("移除 PinID {} 上的所有回调，该 PinID 当前共有 {} 个回调处理器", pinId, callbacks.size());
    }

    public static synchronized void removeCallback(int pinId, Callback callback) {
        List<Callback> callbacks = WiringPiSetup.callback.computeIfAbsent(pinId, k -> new ArrayList<>());
        callbacks.remove(callback);
        logger.debug("移除 PinID {} 上的某个指定回调，该 PinID 当前共有 {} 个回调处理器", pinId, callbacks.size());
    }

    public static WpiMode getWpiMode() {
        return wpiMode;
    }

    public static void setup(WpiMode mode) {
        WiringPiSetup.wpiMode = mode;
        switch (WiringPiSetup.wpiMode) {
            case WPI_MODE_PINS:
                if (wiringPiSetup() == -1) {
                    throw new RuntimeException("WiringPi 启动失败(wiringPiSetup)");
                }
                break;
            case WPI_MODE_GPIO:
                if (wiringPiSetupGpio() == -1) {
                    throw new RuntimeException("WiringPi 启动失败(wiringPiSetupGpio)");
                }
                break;
            case WPI_MODE_PHYS:
                if (wiringPiSetupPhys() == -1) {
                    throw new RuntimeException("WiringPi 启动失败(wiringPiSetupPhys)");
                }
                break;
            case WPI_MODE_GPIO_SYS:
                if (wiringPiSetupSys() == -1) {
                    throw new RuntimeException("WiringPi 启动失败(wiringPiSetupSys)");
                }
                break;
            case WPI_MODE_PIFACE:
                if (wiringPiSetupPiFace() == -1) {
                    throw new RuntimeException("WiringPi 启动失败(wiringPiSetupSys)");
                }
                break;
            default:
                throw new RuntimeException("WiringPi 启动失败");
        }
    }

    /**
     * 该函数初始化wiringPi，幵假定程序将使用wiringPi的管脚定义图。具体管脚映射，可以通过gpio readall命令来查看。
     * 该函数需要root权限。
     *
     * @return
     */
    public static native int wiringPiSetup();

    /**
     * 该函数初始化wiringPi，使用/sys/class/gpio接口，而丌是直接通过操作硬件来实现。该函数可以使用非root权限用户，
     * 在此种模式下的管脚号是Broadcom的GPIO管脚号，不wiringPiSetupGpio函数类似，需要注意v1和v2板子的丌同。
     * 在此种模式下，在运行程序前，您需要通过/sys/class/gpio接口导出要使用的管脚。你可以在一个独立的shell脚本中来导出将要使用的管脚，
     * 或者使用系统的system()函数来调用gpio命令。
     *
     * @return
     */
    public static native int wiringPiSetupSys();

    /**
     * 该函数不wiringPiSetup函数类似，区别在亍假定程序使用的是Broadcom的GPIO管脚定义，而没有重新映射。
     * 该函数需要root权限，需要注意v1和v2版本的树莓派是丌同的。
     *
     * @return
     */
    public static native int wiringPiSetupGpio();

    /**
     * 该函数不wiringPiSetup函数类似，区别在亍允讲程序使用物理管脚定义，仅支持P1接口。
     * 该函数需要root权限。
     *
     * @return
     */
    public static native int wiringPiSetupPhys();

    public static native int wiringPiSetupPiFace();

    // Don't use this - for gpio program only
    public static native int wiringPiSetupPiFaceForGpioProg();
}
