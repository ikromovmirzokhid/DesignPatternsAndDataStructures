package designPatterns.state;

public class LowState extends FanState{
    public LowState(Fan fan) {
        super(fan);
        System.out.println("Fan low designPatterns.state");
    }

    @Override
    void pullRed() {
        OffState offState = new OffState(fan, true);
        fan.setState(offState);
    }

    @Override
    void pullGreen() {
        MediumState mediumState = new MediumState(fan);
        fan.setState(mediumState);
    }
}
