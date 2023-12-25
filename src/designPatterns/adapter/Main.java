package designPatterns.adapter;

public class Main {
    public static void main(String[] args) {
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        DistanceAdapter distanceAdapter = new KilometerDistanceAdapterImpl();
        distanceAdapter.setDistanceCalculator(distanceCalculator);
        double distanceInKm = distanceAdapter.computeDistance("San Fransisco", "Mountain View");
        System.out.println("Distance between San Fransisco to Mountain View = " + distanceInKm + " km");
    }
}