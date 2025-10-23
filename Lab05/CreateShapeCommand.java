import java.util.Scanner;
import java.util.Vector;

public class CreateShapeCommand implements Command {
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