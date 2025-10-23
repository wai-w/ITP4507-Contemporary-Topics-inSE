
import java.util.*;

/**
 * Lab4a Solution
 *
 * @author alanpo
 */
public class Lab04Q2 {

  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Vector<Shape> shapes = new Vector<Shape>();
    
    ShapeFactory[] f = new ShapeFactory[2];
    f[0] = new CircleFactory();
    f[1] = new RectangleFactory();
    
    int command;
    while (true) {
      System.out.println("Enter command: 0 = exit, 1 = draw all shapes, 2 = create circle, 3 = create rectangle");
      command = sc.nextInt();
      if (command == 0) {
        return;
      } else if (command == 1) {
        for (Shape shape:shapes) {
          Client.doAction(shape);
        }
      } else if (command < 4){
          Shape s = f[command-2].createShape(sc);
          shapes.add(s);          
      }
    }
  } 
}
