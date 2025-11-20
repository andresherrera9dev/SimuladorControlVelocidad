package com.ITCelaya.simuladorcontrolvelocidad.util;

import java.util.Random;

public class RandomSpeed {
    public static int getRandomSpeed() {
        Random random = new Random();
        int speed = random.nextInt(250);   // 0–249
        return speed;
    }
}
