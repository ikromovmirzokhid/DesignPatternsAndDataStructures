package designPatterns.decorator;

public class DecoratorA extends Decorator {

    public DecoratorA(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        System.out.println("Decorator A, operation");
        return "DecoratorA - " + component.operation();
    }
}
