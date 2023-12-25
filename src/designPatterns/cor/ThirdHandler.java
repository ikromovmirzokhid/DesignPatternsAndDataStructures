package designPatterns.cor;

public class ThirdHandler extends Handler {
    public ThirdHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    void handle(String type) {
        if (type.equals("third"))
            System.out.println("handled by ThirdHandler");
        else
            System.out.println("No handler found to handle this type");
    }
}
