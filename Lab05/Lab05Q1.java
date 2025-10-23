
import java.util.Scanner;
import java.util.Stack;

public class Lab05Q1 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int amount = 0;
        Command com; //Object for a command
        Stack<Command> commandStack = new Stack<>();//<Command> it will make Stack only can store Command objects
        int command;
        while (true) {
            System.out.println("Enter command: 0 = exit, 1 = undo, 2 = Command1, 3 = Command2");
            command = sc.nextInt();
			
            switch (command) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    // undo the commands	
                    if (!commandStack.empty()) {
                        // get the latest command object in the stack
                        Command c = commandStack.pop();//pop the command from stack
                        // undo the latest command
                        c.undo();
                    } else {
                        System.out.println("Nothing to undo!");
                    }
                    break;

                case 2:
                    //must be a new object!
                    com = new Command1(sc);
                    com.execute();
                    commandStack.push(com);
                    break;

                case 3:
                    com = new Command2(sc);
                    com.execute();
                    commandStack.push(com);
                    break;
            }
        }
    }
}
