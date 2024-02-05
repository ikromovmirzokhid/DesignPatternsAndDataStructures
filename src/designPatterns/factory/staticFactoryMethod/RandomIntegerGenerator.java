package designPatterns.factory.staticFactoryMethod;

import java.util.Random;

public class RandomIntegerGenerator {
    private int min;
    private int max;

    private RandomIntegerGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static RandomIntegerGenerator between(int min, int max) {
        return new RandomIntegerGenerator(min, max);
    }

    public static RandomIntegerGenerator up(int min) {
        return new RandomIntegerGenerator(min, Integer.MAX_VALUE);
    }

    public static RandomIntegerGenerator down(int max) {
        return new RandomIntegerGenerator(Integer.MIN_VALUE, max);
    }

    public int nextInt() {
        return new Random().nextInt();
    }
}
