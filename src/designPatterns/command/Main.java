package designPatterns.command;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorOperationsHistoryList historyList = new CalculatorOperationsHistoryList();

        Addition addition = new Addition(calculator, 5);
        addition.execute();
        historyList.addCalculatorCommand(addition);

        Subtraction subtraction = new Subtraction(calculator, 1);
        subtraction.execute();
        historyList.addCalculatorCommand(subtraction);

        Multiplication multiplication = new Multiplication(calculator, 3);
        multiplication.execute();
        historyList.addCalculatorCommand(multiplication);

        Division division = new Division(calculator, 4);
        division.execute();
        historyList.addCalculatorCommand(division);

        historyList.undo();
        historyList.undo();
        historyList.undo();
        historyList.undo();

        historyList.redo();
        historyList.redo();
        historyList.redo();
        historyList.redo();
    }
}