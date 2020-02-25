package com.wiringpi.pin;

/**
 * 默认的 WiringPi 管脚
 *
 * @author HouKunLin
 * @date 2020/2/13 0013 4:34
 */
public enum PhysPin implements IPin {
    /**
     * GPIO0
     */
    NONE(-1),
    p01(1),
    p02(2),
    p03(3),
    p04(4),
    p05(5),
    p06(6),
    p07(7),
    p08(8),
    p09(9),
    p10(10),
    p11(11),
    p12(12),
    p13(13),
    p14(14),
    p15(15),
    p16(16),
    p17(17),
    p18(18),
    p19(19),
    p20(20),
    p21(21),
    p22(22),
    p23(23),
    p24(24),
    p25(25),
    p26(26),
    p27(27),
    p28(28),
    p29(29),
    p30(30),
    p31(31),
    p32(32),
    p33(33),
    p34(34),
    p35(35),
    p36(36),
    p37(37),
    p38(38),
    p39(39),
    p40(40),
    ;
    public static final IPin SDA_1 = p03;
    public static final IPin SCL_1 = p05;
    public static final IPin MOSI = p19;
    public static final IPin MISO = p21;
    public static final IPin SCLK = p23;
    public static final IPin SDA_0 = p27;
    public static final IPin TXD = p08;
    public static final IPin RXD = p10;
    public static final IPin CE0 = p24;
    public static final IPin CE1 = p26;
    public static final IPin SCL_0 = p28;
    private int value;

    PhysPin(int value) {
        this.value = value;
    }

    /**
     * 通过当前类型的管脚值转换
     *
     * @param value
     * @return
     */
    public static PhysPin valueOf(Integer value) {
        if (value == null) {
            return NONE;
        }
        for (PhysPin pin : values()) {
            if (value.equals(pin.value)) {
                return pin;
            }
        }
        return NONE;
    }

    @Override
    public int physPin() {
        return value;
    }

    @Override
    public int value() {
        return value;
    }
}
