//
// Created by Administrator on 2020/2/24 0024.
//

#include <wiringPi.h>
#include <stdio.h>

int main(){
    wiringPiSetup();
    int pin = 0;
    pinMode(pin, OUTPUT);
    printf("设置高电平\n");
    digitalWrite(pin, 1);
    delay(10000);
    printf("设置低电平\n");
    digitalWrite(pin, 0);
    delay(10000);
    printf("设置高电平\n");
    digitalWrite(pin, 1);
    delay(10000);
    printf("设置低电平\n");
    digitalWrite(pin, 0);

    return 0;
}