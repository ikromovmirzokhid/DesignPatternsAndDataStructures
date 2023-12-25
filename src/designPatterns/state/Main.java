package designPatterns.state;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        OffState offState = new OffState(fan, false);
        fan.setState(offState);
        fan.pullGreen();
        fan.pullGreen();
        fan.pullGreen();
        fan.pullGreen();

        fan.pullRed();
        fan.pullRed();
        fan.pullRed();
        fan.pullRed();
    }
}