package com.wiringpi.pin;

/**
 * 默认的 WiringPi 管脚
 *
 * @author HouKunLin
 * @date 2020/2/13 0013 4:34
 */
public enum WiringPiPin implements IPin {
    /**
     * GPIO0
     */
    NONE(-1, -1),
    p00(0, 11),
    p01(1, 12),
    p02(2, 13),
    p03(3, 15),
    p04(4, 16),
    p05(5, 18),
    p06(6, 22),
    p07(7, 7),
    p08(8, 3),
    p09(9, 5),
    p10(10, 24),
    p11(11, 26),
    p12(12, 19),
    p13(13, 21),
    p14(14, 23),
    p15(15, 8),
    p16(16, 10),
    p21(21, 29),
    p22(22, 31),
    p23(23, 33),
    p24(24, 35),
    p25(25, 37),
    p26(26, 32),
    p27(27, 36),
    p28(28, 38),
    p29(29, 40),
    p30(30, 27),
    p31(31, 28),
    ;
    public static final IPin SDA_1 = p08;
    public static final IPin SCL_1 = p09;
    public static final IPin MOSI = p12;
    public static final IPin MISO = p13;
    public static final IPin SCLK = p14;
    public static final IPin SDA_0 = p30;
    public static final IPin TXD = p15;
    public static final IPin RXD = p16;
    public static final IPin CE0 = p10;
    public static final IPin CE1 = p11;
    public static final IPin SCL_0 = p31;
    private int value;
    private int physPin;

    WiringPiPin(int value, int physPin) {
        this.value = value;
        this.physPin = physPin;
    }

    /**
     * 通过当前类型的管脚值转换
     *
     * @param value
     * @return
     */
    public static WiringPiPin valueOf(Integer value) {
        if (value == null) {
            return NONE;
        }
        for (WiringPiPin pin : values()) {
            if (value.equals(pin.value)) {
                return pin;
            }
        }
        return NONE;
    }

    @Override
    public int physPin() {
        return physPin;
    }

    @Override
    public int value() {
        return value;
    }
}
