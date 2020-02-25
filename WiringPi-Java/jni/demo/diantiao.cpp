//
// Created by Administrator on 2020/2/23 0023.
//

//#include "diantiao.h"
#include <stdio.h>
#include <wiringPi.h>

#define pin 4

/**
 * 频率：50HZ
 * 一个周期：20ms
 * @param highNum 高电平时间（毫秒）
 */
void highTime(float highNum) {
    if (highNum == 0) {
        digitalWrite(pin, 0);
        delayMicroseconds(20 * 1000);
        return;
    }
    digitalWrite(pin, 1);
    // 1 毫秒 = 1000 微秒
    delayMicroseconds((int) (highNum * 1000));
    digitalWrite(pin, 0);
    delayMicroseconds((int) ((20 - highNum) * 1000));
}

int main() {
    if (wiringPiSetup() == -1) {
        //when initialize wiring failed,print messageto screen
        printf("setup wiringPi failed !");
        return 1;
    }
    pinMode(0, OUTPUT);
    digitalWrite(0, 1);
    delay(10000);
    pinMode(pin, OUTPUT);

    // 油门上限高电平时间：2.1毫秒
    float max = 2.1f;
    // 油门下限高电平时间：0.7毫秒
    float min = 0.7f;
    // 公式：油门百分比 * ( 2.1 - 0.7 ) + 0.7 = 油门百分比 * 1.4 + 0.7

    printf("测试电机运转\n");
    printf("设置油门上限\n");
    for (int i = 0; i < 100; ++i) {
        highTime(max);
    }
    printf("设置油门下限\n");
    for (int i = 0; i < 100; ++i) {
        highTime(min);
    }
    printf("等待几秒钟\n");
    for (int i = 0; i < 250; ++i) {
        highTime(min);
    }
    printf("电机开始运转\n");
    for (float time = min; time <= max; time += 0.1f) {
        //12-17
        //1.15-1.65
        printf("高电平时间：%0.2fms\n", time);
        for (int i = 0; i < 50; ++i) {
            highTime(time);
        }
    }

    printf("油门中间值\n");
    for (int i = 0; i < 250; ++i) {
        highTime(1.4);
    }
    printf("油门最小\n");
    for (int i = 0; i < 100; ++i) {
        highTime(min);
    }
    digitalWrite(0, 0);
    return 0;
}