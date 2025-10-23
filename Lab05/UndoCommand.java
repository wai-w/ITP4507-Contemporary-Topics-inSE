import java.util.Stack;

public class UndoCommand implements Command {
    private Stack<Command> history;

    public UndoCommand(Stack<Command> history) {
        this.history = history;
    }

    @Override
    public void execute() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        }
    }

    @Override
    public void undo() {
        // Cannot undo an undo
    }
}