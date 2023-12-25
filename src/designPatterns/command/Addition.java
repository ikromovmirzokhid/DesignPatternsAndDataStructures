package designPatterns.command;

public class Addition extends CalculatorCommand {
    private int value;

    public Addition(Calculator calculator, int value) {
        super(calculator);
        this.value = value;
    }

    @Override
    void execute() {
        calculator.add(value);
    }

    @Override
    void unExecute() {
        calculator.subtract(value);
    }
}
