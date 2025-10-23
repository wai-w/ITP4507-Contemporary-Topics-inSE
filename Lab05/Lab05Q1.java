
import java.util.Scanner;
import java.util.Stack;

public class Lab05Q1 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Command com; //Object for a command
        Stack<Command> commandStack = new Stack<>();//<Command> it will make Stack only can store Command objects
        int command;
        while (true) {
            System.out.println("Enter command: 0 = exit, 1 = undo, 2 = Command1, 3 = Command2");
            command = sc.nextInt();

            switch (command) {
                case 0 -> {
                    com = createExitCommand();
                    com.execute();
                }

                case 1 -> {
                    // undo the commands	
                    com = createUndoCommand(commandStack);
                    com.execute();
                }

                case 2 -> {
                    //must be a new object!
                    com = createCommand1(sc);
                    com.execute();
                    commandStack.push(com);
                }

                case 3 -> {
                    com = createCommand2(sc);
                    com.execute();
                    commandStack.push(com);
                }
            }
        }
    }

    public static Command createExitCommand() {
        return new ExitCommand();
    }

    public static Command createUndoCommand(Stack<Command> commandStack) {
        return new UndoCommand(commandStack);
    }

    public static Command createCommand1(Scanner sc) {
        return new Command1(sc);
    }

    public static Command createCommand2(Scanner sc) {
        return new Command2(sc);
    }
}
