package designPatterns.adapter;

public class KilometerDistanceAdapterImpl implements DistanceAdapter {
    private DistanceCalculator distanceCalculator;

    @Override
    public double computeDistance(String origin, String destination) {
        double distanceInMiles = distanceCalculator.computeDistance(origin, destination);
        return distanceInMiles * 1.6;
    }

    @Override
    public void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }
}
