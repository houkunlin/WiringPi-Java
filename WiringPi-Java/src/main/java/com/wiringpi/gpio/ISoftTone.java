package com.wiringpi.gpio;

import com.wiringpi.jni.SoftTone;

/**
 * #include <softTone.h>
 *
 * @author HouKunLin
 * @date 2020/2/22 0022 14:12
 */
public interface ISoftTone extends IGpio {
    default int softToneCreate() {
        return SoftTone.softToneCreate(getPin());
    }

    default void softToneStop() {
        SoftTone.softToneStop(getPin());
    }

    default void softToneWrite(int freq) {
        SoftTone.softToneWrite(getPin(), freq);
    }
}
