package com.wiringpi.pin;

/**
 * 默认的 WiringPi 管脚
 *
 * @author HouKunLin
 * @date 2020/2/13 0013 4:34
 */
public enum BcmPin implements IPin {
    /**
     * GPIO0
     */
    NONE(-1, -1),
    p00(0, 27),
    p01(1, 28),
    p02(2, 3),
    p03(3, 5),
    p04(4, 7),
    p05(5, 29),
    p06(6, 31),
    p07(7, 26),
    p08(8, 24),
    p09(9, 21),
    p10(10, 19),
    p11(11, 23),
    p12(12, 32),
    p13(13, 33),
    p14(14, 8),
    p15(15, 10),
    p16(16, 36),
    p17(17, 11),
    p18(18, 12),
    p19(19, 35),
    p20(20, 38),
    p21(21, 40),
    p22(22, 15),
    p23(23, 16),
    p24(24, 18),
    p25(25, 22),
    p26(26, 37),
    p27(27, 13),
    ;
    public static final IPin SDA_1 = p02;
    public static final IPin SCL_1 = p03;
    public static final IPin MOSI = p10;
    public static final IPin MISO = p09;
    public static final IPin SCLK = p11;
    public static final IPin SDA_0 = p00;
    public static final IPin TXD = p14;
    public static final IPin RXD = p15;
    public static final IPin CE0 = p08;
    public static final IPin CE1 = p07;
    public static final IPin SCL_0 = p01;
    private int value;
    private int physPin;

    BcmPin(int value, int physPin) {
        this.value = value;
        this.physPin = physPin;
    }

    /**
     * 通过当前类型的管脚值转换
     *
     * @param value
     * @return
     */
    public static BcmPin valueOf(Integer value) {
        if (value == null) {
            return NONE;
        }
        for (BcmPin pin : values()) {
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
