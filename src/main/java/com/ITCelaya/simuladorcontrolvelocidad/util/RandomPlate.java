package com.ITCelaya.simuladorcontrolvelocidad.util;


public class RandomPlate {
    private static final char[] VALID_LETTERS = {
            'A','B','C','D','E','F','G','H',
            'J','K','L','M','N','P','R','S',
            'T','U','V','W','X','Y','Z'
    };

    private static final String[] GUANAJUATO_BLOCKS = {
            "GGA", "GGB", "GGC", "GGD", "GGE", "GGF",
            "GGX", "GGY", "GGZ",
            "GYX", "GYY", "GYZ"
    };

    private static MiddleSquareGenerator generator = new MiddleSquareGenerator((int)(System.currentTimeMillis() % 9000) + 1000);

    private static char getRandomLetter() {
        int index = generator.nextInt(VALID_LETTERS.length);
        return VALID_LETTERS[index];
    }

    private static String generateLettersBlock() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(getRandomLetter());
        }
        return sb.toString();
    }

    public static String generatePlate(boolean includeSuffix) {
        String prefix;
        if (includeSuffix) {
            // Usar solo los bloques válidos del estado
            prefix = GUANAJUATO_BLOCKS[
                    generator.nextInt(GUANAJUATO_BLOCKS.length)
                    ];
        } else {
            // Generar LLL libre usando letras válidas
            prefix = generateLettersBlock();
        }

        // Generar números entre 000 y 999
        int numbers = generator.nextInt(1000);
        if (includeSuffix) {
            char suffix = getRandomLetter();
            return String.format("%s-%03d-%c", prefix, numbers, suffix);
        } else {
            return String.format("%s-%03d", prefix, numbers);
        }
    }
    //...
    public static boolean isGuanajuatoPlate(String plate) {
        String prefix = plate.split("-")[0];  // Extrae las primeras LLL
        for (String block : GUANAJUATO_BLOCKS) {
            if (prefix.equals(block)) {
                return true;
            }
        }
        return false;
    }
}
