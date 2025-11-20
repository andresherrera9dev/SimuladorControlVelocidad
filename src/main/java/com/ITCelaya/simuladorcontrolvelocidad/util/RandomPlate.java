package com.ITCelaya.simuladorcontrolvelocidad.util;

import java.util.Random;

public class RandomPlate {
    public static String generatePlate() {
        Random random = new Random();
        String letters = "";
        for (int i = 0; i < 3; i++) {
            letters += (char) ('A' + random.nextInt(26));
        }
        int numbers = random.nextInt(1000);
        return String.format("%s-%03d", letters, numbers);
    }
}
