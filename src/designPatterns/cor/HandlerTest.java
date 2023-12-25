package designPatterns.cor;

public class HandlerTest {
    private Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void handle(String type) {
        handler.handle(type);
    }
}
