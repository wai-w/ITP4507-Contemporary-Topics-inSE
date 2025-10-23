

import java.util.Scanner;

public class CircleFactory implements ShapeFactory {

  @Override
  public Shape createShape(Scanner sc) {
    PointFactory pf = new PointFactory();
    Point p = pf.createPoint(sc);
    System.out.println("Enter radius:");
    int r = sc.nextInt();
    return new Circle(r, p);
  }

}
