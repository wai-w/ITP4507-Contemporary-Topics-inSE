
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
            case 0 ->
                new ExitCommand();
            case 1 ->
                new UndoCommand(history);
            case 2 ->
                new DrawAllShapesCommand(shapes);
            case 3 ->
                new DeleteShapeCommand(shapes, scanner);
            case 4 ->
                new CreateShapeCommand(shapes, scanner, factories[0]); // Circle
            case 5 ->
                new CreateShapeCommand(shapes, scanner, factories[1]); // Rectangle
            default ->
                null;
        };
    }
}

class CreateShapeCommand implements Command {

    private Vector<Shape> shapes;
    private Scanner scanner;
    private ShapeFactory factory;
    private Shape createdShape;

    public CreateShapeCommand(Vector<Shape> shapes, Scanner scanner, ShapeFactory factory) {
        this.shapes = shapes;
        this.scanner = scanner;
        this.factory = factory;
    }

    @Override
    public void execute() {
        createdShape = factory.createShape(scanner);
        shapes.add(createdShape);
    }

    @Override
    public void undo() {
        if (createdShape != null) {
            shapes.remove(createdShape);
        }
    }
}

class DeleteShapeCommand implements Command {
    private Vector<Shape> shapes;
    private Scanner scanner;
    private Shape deletedShape;
    private int deletedIndex;

    public DeleteShapeCommand(Vector<Shape> shapes, Scanner scanner) {
        this.shapes = shapes;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter index of the shape: ");
        deletedIndex = scanner.nextInt();
        if (deletedIndex >= 0 && deletedIndex < shapes.size()) {
            deletedShape = (Shape) shapes.remove(deletedIndex);
        } else {
            System.out.println("Invalid index!");
        }
    }

    @Override
    public void undo() {
        if (deletedShape != null) {
            shapes.add(deletedIndex, deletedShape);
        }
    }
}
class DrawAllShapesCommand implements Command {
    private Vector<Shape> shapes;

    public DrawAllShapesCommand(Vector<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void execute() {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.print("index: " + i + " - ");
            Client.doAction(shapes.get(i));
        }
    }

    @Override
    public void undo() {
        // Drawing cannot be undone
    }
}
class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void undo() {
        // Exit command cannot be undone
    }
}

class UndoCommand implements Command {
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