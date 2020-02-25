package com.wiringpi.pin;

/**
 * 管脚功能名对应pin
 *
 * @author HouKunLin
 * @date 2020/2/15 0015 4:26
 */
public enum NamePin implements IPin {
    /**
     * 无接口
     */
    NONE(-1),
    VDC_P1_3_3V(1),
    SDA_1(3),
    SCL_1(5),
    GPIO_7(7),
    VDC_P9_0V(9),
    GPIO_0(11),
    GPIO_2(13),
    GPIO_3(15),
    VDC_P17_3_3V(17),
    MOSI(19),
    MISO(21),
    SCLK(23),
    VDC_P25_0V(25),
    SDA_0(27),
    GPIO_21(29),
    GPIO_22(31),
    GPIO_23(33),
    GPIO_24(35),
    GPIO_25(37),
    VDC_P39_0V(39),

    VDC_P2_5V(2),
    VDC_P4_5V(4),
    VDC_P6_0V(6),
    TXD(8),
    RXD(10),
    GPIO_1(12),
    VDC_P14_0V(14),
    GPIO_4(16),
    GPIO_5(18),
    VDC_P20_0V(20),
    GPIO_6(22),
    CE0(24),
    CE1(26),
    SCL_0(28),
    VDC_P30_0V(30),
    GPIO_26(32),
    VDC_P34_0V(34),
    GPIO_27(36),
    GPIO_28(38),
    GPIO_29(40),
    ;

    private int physPin;

    NamePin(int physPin) {
        this.physPin = physPin;
    }

    /**
     * 通过当前类型的管脚值转换
     *
     * @param value
     * @return
     */
    public static NamePin valueOf(Integer value) {
        if (value == null) {
            return NONE;
        }
        for (NamePin pin : values()) {
            if (value.equals(pin.physPin)) {
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
        return physPin;
    }
}
