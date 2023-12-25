package designPatterns.command;

public abstract class CalculatorCommand {
    protected Calculator calculator;

    public CalculatorCommand(Calculator calculator) {
        this.calculator = calculator;
    }

    abstract void execute();

    abstract void unExecute();
}
