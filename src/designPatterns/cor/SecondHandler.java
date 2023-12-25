package designPatterns.cor;

public class SecondHandler extends Handler {
    public SecondHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(String type) {
        if (type.equals("second"))
            System.out.println("handled by SecondsHandler");
        else
            nextHandler.handle(type);
    }
}
