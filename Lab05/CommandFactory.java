import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class CommandFactory {
    private Vector<Shape> shapes;
    private Scanner scanner;
    private Stack<Command> history;
    private ShapeFactory[] factories;

    public CommandFactory(Vector<Shape> shapes, Scanner scanner, Stack<Command> history) {
        this.shapes = shapes;
        this.scanner = scanner;
        this.history = history;
        this.factories = new ShapeFactory[]{new CircleFactory(), new RectangleFactory()};
    }

    public Command createCommand(int choice) {
        return switch (choice) {
            case 0 -> new ExitCommand();
            case 1 -> new UndoCommand(history);
            case 2 -> new DrawAllShapesCommand(shapes);
            case 3 -> new DeleteShapeCommand(shapes, scanner);
            case 4 -> new CreateShapeCommand(shapes, scanner, factories[0]); // Circle
            case 5 -> new CreateShapeCommand(shapes, scanner, factories[1]); // Rectangle
            default -> null;
        };
    }
}