import java.util.Scanner;
import java.util.Vector;

public class DeleteShapeCommand implements Command {
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