package designPatterns.cor;

public class FirstHandler extends Handler {

    public FirstHandler(Handler handler) {
        super(handler);
    }

    @Override
    void handle(String type) {
        if (type.equals("first"))
            System.out.println("Handled by FirstHandler");
        else
            nextHandler.handle(type);
    }
}
