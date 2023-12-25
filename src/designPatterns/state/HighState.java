package designPatterns.state;

public class HighState extends FanState{
    public HighState(Fan fan) {
        super(fan);
        System.out.println("Fan high designPatterns.state");
    }

    @Override
    void pullRed() {
        MediumState mediumState = new MediumState(fan);
        fan.setState(mediumState);
    }

    @Override
    void pullGreen() {
        OffState offState = new OffState(fan, true);
        fan.setState(offState);
    }
}
