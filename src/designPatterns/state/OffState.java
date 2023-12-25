package designPatterns.state;

public class OffState extends FanState {

    public OffState(Fan fan, boolean turnOff) {
        super(fan);
        if (turnOff)
            System.out.println("Fan turned off");
    }

    @Override
    void pullRed() {
        HighState highState = new HighState(fan);
        fan.setState(highState);
    }

    @Override
    void pullGreen() {
        LowState lowState = new LowState(fan);
        fan.setState(lowState);
    }
}
