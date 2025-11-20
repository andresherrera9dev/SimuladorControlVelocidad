package com.ITCelaya.simuladorcontrolvelocidad.util;

public class MiddleSquareGenerator {

    private int seed;
    private int lastValue = -1;

    public MiddleSquareGenerator(int seed) {
        setSeed(seed);
    }

    public void setSeed(int newSeed) {
        if (newSeed < 1000 || newSeed > 9999) {
            throw new IllegalArgumentException("Seed must be 4 digits");
        }
        this.seed = newSeed;
        this.lastValue = -1;
    }

    private int next() {
        long squared = (long) seed * seed;
        String sq = String.format("%08d", squared);
        int nextVal = Integer.parseInt(sq.substring(2, 6));

        if (nextVal == lastValue || nextVal == seed || nextVal == 0) {
            int newSeed = (int)(System.nanoTime() % 9000) + 1000;

            setSeed(newSeed);
            return next();
        }

        lastValue = seed;
        seed = nextVal;
        return seed;
    }

    public int nextInt(int max) {
        return next() % max;
    }
}
