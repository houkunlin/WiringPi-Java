package com.wiringpi.jni;

/**
 * #include  <wiringPiI2C.h>
 *
 * @author HouKunLin
 * @date 2020/2/22 0022 18:09
 */
public class WiringPiI2C {
    private static native int wiringPiI2CRead(int fd);

    private static native int wiringPiI2CReadReg8(int fd, int reg);

    private static native int wiringPiI2CReadReg16(int fd, int reg);

    private static native int wiringPiI2CWrite(int fd, int data);

    private static native int wiringPiI2CWriteReg8(int fd, int reg, int data);

    private static native int wiringPiI2CWriteReg16(int fd, int reg, int data);

    private static native int wiringPiI2CSetupInterface(String device, int devId);

    private static native int wiringPiI2CSetup(int devId);

    private int fd;
    private int devId;

    public WiringPiI2C(int devId) {
        this.devId = devId;
        this.fd = wiringPiI2CSetup(devId);
    }

    public int wiringPiI2CRead() {
        return wiringPiI2CRead(fd);
    }

    public int wiringPiI2CReadReg8(int reg) {
        return wiringPiI2CReadReg8(fd, reg);
    }

    public int wiringPiI2CReadReg16(int reg) {
        return wiringPiI2CReadReg16(fd, reg);
    }

    public int wiringPiI2CWrite(int data) {
        return wiringPiI2CWrite(fd, data);
    }

    public int wiringPiI2CWriteReg8(int reg, int data) {
        return wiringPiI2CWriteReg8(fd, reg, data);
    }

    public int wiringPiI2CWriteReg16(int reg, int data) {
        return wiringPiI2CWriteReg16(fd, reg, data);
    }

    public int wiringPiI2CSetupInterface(String device) {
        return wiringPiI2CSetupInterface(device, devId);
    }

    public int readWord2c(int addr) {
        int value;
        int value1 = wiringPiI2CReadReg8(addr);
        int value2 = wiringPiI2CReadReg8(addr + 1);
        value = (value1 << 8) + value2;
        if (value >= 0x8000) {
            value = -(65536 - value);
        }

        return value;
    }
}
