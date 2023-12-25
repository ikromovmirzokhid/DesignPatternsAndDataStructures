package designPatterns.decorator;

public class DecoratorB extends Decorator{
    public DecoratorB(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        System.out.println("Decorator B, operation");
        return "DecoratorB - " + component.operation();
    }
}
