package designPatterns.cor;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void handle(String type);
}
