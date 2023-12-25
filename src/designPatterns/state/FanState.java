package designPatterns.state;

public abstract class FanState {
    protected Fan fan;

    public FanState(Fan fan) {
        this.fan = fan;
    }

    abstract void pullRed();

    abstract void pullGreen();
}
