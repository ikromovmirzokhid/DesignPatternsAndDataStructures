package designPatterns.command;

public class Multiplication extends CalculatorCommand {
    private int value;

    public Multiplication(Calculator calculator, int value) {
        super(calculator);
        this.value = value;
    }

    @Override
    void execute() {
        calculator.multiply(value);
    }

    @Override
    void unExecute() {
        calculator.divide(value);
    }
}
