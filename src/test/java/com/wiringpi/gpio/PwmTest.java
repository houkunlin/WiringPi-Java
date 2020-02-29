package com.wiringpi.gpio;


import org.junit.Test;

public class PwmTest {

    /**
     * 180度转角的舵机。
     * <p>周期持续   角度     占空比</p>
     * <p>0.5ms     0度      2.5%</p>
     * <p>1.0ms     45度     5.0%</p>
     * <p>1.5ms     90度     7.5%</p>
     * <p>2.0ms     135度    10.0%</p>
     * <p>2.5ms     180度    12.5%</p>
     */
    @Test
    public void testDuoJi() {
        Pwm pwm = new Pwm();
        // 0 度
        pwm.setDutyRatio(calcDutyRatio(0));
        // 45 度
        pwm.setDutyRatio(calcDutyRatio(45));
        // 90 度
        pwm.setDutyRatio(calcDutyRatio(90));
        // 135 度
        pwm.setDutyRatio(calcDutyRatio(135));
        // 180 度
        pwm.setDutyRatio(calcDutyRatio(180));
    }

    private float calcDutyRatio(int deg) {
        return 10.0f * deg / 180.0f + 2.5f;
    }
}