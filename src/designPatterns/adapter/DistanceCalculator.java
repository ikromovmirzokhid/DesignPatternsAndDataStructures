package designPatterns.adapter;

import java.util.Random;

public class DistanceCalculator {
    double computeDistance(String origin, String destination) {
        return new Random().nextDouble();
    }
}
