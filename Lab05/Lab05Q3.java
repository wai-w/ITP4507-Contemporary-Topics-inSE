
import java.util.*;

/**
 * Lab4a Solution
 *
 * @author alanpo
 */
public class Lab05Q3 {

  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
        Vector<Shape> shapes = new Vector<>();
        Stack<Command> history = new Stack<>();
        CommandFactory factory = new CommandFactory(shapes, sc, history);

        while (true) {
            System.out.println("Enter command: 0 = exit, 1 = undo, 2 = draw all shapes, 3 = delete a shape, 4 = create circle, 5 = create rectangle");
            int choice = sc.nextInt();
            
            Command command = factory.createCommand(choice);
            if (command != null) {
                command.execute();
                
                if (!(command instanceof ExitCommand || 
                      command instanceof UndoCommand || 
                      command instanceof DrawAllShapesCommand)) {
                    history.push(command);
                }
            } else {
                System.out.println("Invalid command!");
            }
        }
    }
}
