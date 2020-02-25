package com.wiringpi.pin.modes;

/**
 * 模式值
 *
 * @author HouKunLin
 * @date 2020/2/14 0014 20:41
 */
public interface IMode {
    static <T extends IMode> T parseValue(Class<T> enumType, Integer value) {
        T[] enumConstants = enumType.getEnumConstants();
        for (T enumConstant : enumConstants) {
            if (enumConstant.value() == value) {
                return enumConstant;
            }
        }
        return null;
    }

    @SuppressWarnings(value = {"all", "unchecked"})
    static <T extends IMode> T parseValue(Class<T> enumType, String name) {
        try {
            Class<? extends Enum> enumTypeClass = (Class<? extends Enum>) enumType;
            return (T) Enum.valueOf(enumTypeClass, name);
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     * 值
     *
     * @return
     */
    int value();
}
