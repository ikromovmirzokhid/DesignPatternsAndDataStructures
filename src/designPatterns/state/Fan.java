package designPatterns.state;

public class Fan {
    private FanState state;

    void pullGreen() {
        state.pullGreen();
    }

    void pullRed() {
        state.pullRed();
    }

    void setState(FanState state) {
        this.state = state;
    }
}
