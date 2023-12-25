package designPatterns.command;

public class Subtraction extends CalculatorCommand {
    private int value;

    public Subtraction(Calculator calculator, int value) {
        super(calculator);
        this.value = value;
    }

    @Override
    void execute() {
        calculator.subtract(value);
    }

    @Override
    void unExecute() {
        calculator.add(value);
    }
}
