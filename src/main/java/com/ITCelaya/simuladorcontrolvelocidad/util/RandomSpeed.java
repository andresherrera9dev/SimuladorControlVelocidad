package com.ITCelaya.simuladorcontrolvelocidad.util;

import java.util.Random;

public class RandomSpeed {
    private static MiddleSquareGenerator generator = new MiddleSquareGenerator((int)(System.currentTimeMillis() % 9000) + 1000);
    public static int getRandomSpeed() {
        int speed = 20 + generator.nextInt(140);
        return speed;
    }
}
