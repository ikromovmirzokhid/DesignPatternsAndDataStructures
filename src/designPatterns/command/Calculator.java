package designPatterns.command;

public class Calculator {
    private int value = 0;
    public void add(int v) {
        value += v;
        System.out.println("Add: value - " + value);
    }

    public void subtract(int v) {
        value -= v;
        System.out.println("Subtract: value - " + value);
    }

    public void multiply(int v) {
        value *= v;
        System.out.println("Multiply: value - " + value);
    }

    public void divide(int v) {
        value /= v;
        System.out.println("Divide: value - " + value);
    }
}
