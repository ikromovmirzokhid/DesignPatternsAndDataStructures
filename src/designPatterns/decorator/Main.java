package designPatterns.decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Result = " + (new DecoratorA(new DecoratorB(new ConcreteComponent()))).operation());
    }
}