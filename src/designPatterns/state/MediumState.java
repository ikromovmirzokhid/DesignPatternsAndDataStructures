package designPatterns.state;

public class MediumState extends FanState {

    public MediumState(Fan fan) {
        super(fan);
        System.out.println("Fan medium designPatterns.state");
    }

    @Override
    void pullRed() {
        LowState lowState = new LowState(fan);
        fan.setState(lowState);
    }

    @Override
    void pullGreen() {
        HighState highState = new HighState(fan);
        fan.setState(highState);
    }
}
