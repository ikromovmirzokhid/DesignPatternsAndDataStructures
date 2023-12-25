package designPatterns.adapter;

public interface DistanceAdapter {

    double computeDistance(String origin, String destination);

    void setDistanceCalculator(DistanceCalculator distanceCalculator);
}
