
import java.util.*;

public interface Command {

    public void execute();

    public void undo();

}

class Command1 implements Command {

    private int id;
    Scanner sc;

    public Command1(Scanner sc) {
        this.sc = sc;
    }

    public void execute() {
        System.out.println("Input ID for Command 1:");
        id = sc.nextInt();
        System.out.println(id + "Command 1 : execute()");
    }

    public void undo() {
        System.out.println(id + "Command 1 : undo()");
    }
}

class Command2 implements Command {

    private int id;
    Scanner sc;

    public Command2(Scanner sc) {
        this.sc = sc;
    }

    public void execute() {
        System.out.println("Input ID for Command 2:");
        id = sc.nextInt();
        System.out.println(id + "Command 2 : execute()");
    }

    public void undo() {
        System.out.println(id + "Command 2 : undo()");
    }
}

class ExitCommand implements Command {

    public void execute() {
        System.exit(0);
    }

    public void undo() {
        // Do nothing
    }
}

class UndoCommand implements Command {
    private Stack<Command> commandStack;

    public UndoCommand(Stack<Command> commandStack) {
        this.commandStack = commandStack;
    }

    public void execute() {
        if (!commandStack.empty()) {
            // get the latest command object in the stack
            Command c = commandStack.pop();//pop the command from stack
            // undo the latest command
            c.undo();
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    public void undo() {
        // Do nothing
    }

    
}

