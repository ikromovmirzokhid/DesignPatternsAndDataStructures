package designPatterns.command;

public class Division extends CalculatorCommand {

    private int value;

    public Division(Calculator calculator, int value) {
        super(calculator);
        this.value = value;
    }

    @Override
    void execute() {
        calculator.divide(value);
    }

    @Override
    void unExecute() {
        calculator.multiply(value);
    }
}
