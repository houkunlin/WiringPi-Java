package com.wiringpi.jni;

import java.util.function.Consumer;

/**
 * 回调
 *
 * @author HouKunLin
 * @date 2020/2/13 0013 18:06
 */
@FunctionalInterface
public interface Callback extends Consumer<Integer> {
}
