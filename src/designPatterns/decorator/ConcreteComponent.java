package designPatterns.decorator;

public class ConcreteComponent implements Component{
    @Override
    public String operation() {
        System.out.println("ConcreteComponent, operation");
        return "ConcreteComponent";
    }
}
