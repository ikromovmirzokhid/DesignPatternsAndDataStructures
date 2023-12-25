package designPatterns.command;

import java.util.ArrayList;
import java.util.List;

public class CalculatorOperationsHistoryList {
    private List<CalculatorCommand> commands = new ArrayList<>();
    private List<CalculatorCommand> redoCommands = new ArrayList<>();

    public void addCalculatorCommand(CalculatorCommand command) {
        commands.add(command);
    }

    public void undo() {
        if (commands.size() != 0) {
            CalculatorCommand command = commands.get(commands.size() - 1);
            command.unExecute();
            commands.remove(command);
            redoCommands.add(command);
        }
    }

    public void redo() {
        if (redoCommands.size() != 0) {
            CalculatorCommand command = redoCommands.get(redoCommands.size() - 1);
            command.execute();
            redoCommands.remove(command);
            commands.add(command);
        }
    }
}
