package com.wiringpi.gpio;

import lombok.Data;

@Deprecated
@Data
public class Pwm implements Runnable {
    private Gpio gpio;

    private boolean run;

    /**
     * 频率，每秒多少赫兹
     */
    private int hz;
    /**
     * 周期，由频率算出 1 赫兹的周期是多少毫秒：cycle = 1000 / hz
     */
    private int cycle;
    /**
     * 占空比，高电平在一个后期内的时间比例（0.00 - 100.00）：dutyRatio = 高电平时间 / cycle
     */
    private float dutyRatio;

    public Pwm() {

    }

    public Pwm(Gpio gpio, int hz, float dutyRatio) {
        this.gpio = gpio;
        this.run = true;
        this.hz = hz;

        this.cycle = 1000 / hz;
        this.dutyRatio = dutyRatio;
    }

    @Override
    public void run() {
        while (run) {
            int heightMs = Math.round(cycle * dutyRatio / 100);
            height(heightMs);
            low(cycle - heightMs);
        }
    }

    private void height(int ms) {
        gpio.high();
        sleep(ms);
    }

    private void low(int ms) {
        gpio.low();
        sleep(ms);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignore) {
        }
    }

    public void stop() {
        run = false;
    }
}
