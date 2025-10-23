
import java.util.*;

/**
 * Lab4a Solution
 *
 * @author alanpo
 */
public class Lab05Q3 {

  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Vector<Shape> shapes = new Vector<Shape>();
    
    ShapeFactory[] f = new ShapeFactory[2];
    f[0] = new CircleFactory();
    f[1] = new RectangleFactory();
    
    int command;
    while (true) {
      System.out.println("Enter command: 0 = exit, 1 = undo, 2 = draw all shapes, 3 = delete a shape, 4 = create circle, 5 = create rectangle");
      command = sc.nextInt();
      if (command == 0) {
        return;
      }else if (command == 1) {
        if (shapes.size() > 0) {
          shapes.remove(shapes.size() - 1);
        }
      } else if (command == 2) {
        for (Shape shape:shapes) {
          Client.doAction(shape);
        }
      }else if (command == 3) {
          System.out.println("Enter index of shape to delete (0 to " + (shapes.size()-1) + "):");
          int index = sc.nextInt();
          if (index >= 0 && index < shapes.size()) {
              Shape temp = (Shape)shapes.remove(index);
          } else {
              System.out.println("Invalid index!");
          }
      } else if (command < 4){
          Shape s = f[command-2].createShape(sc);
          shapes.add(s);          
      }
    }
  } 
}
