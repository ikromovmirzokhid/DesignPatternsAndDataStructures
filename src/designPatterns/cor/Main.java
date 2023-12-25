package designPatterns.cor;

public class Main {
    public static void main(String[] args) {
        HandlerTest handlerTest = new HandlerTest();
        ThirdHandler thirdHandler = new ThirdHandler(null);
        SecondHandler secondHandler = new SecondHandler(thirdHandler);
        FirstHandler firstHandler = new FirstHandler(secondHandler);
        handlerTest.setHandler(firstHandler);
        handlerTest.handle("third");
        handlerTest.handle("second");
        handlerTest.handle("first");
        handlerTest.handle("forth");
    }
}