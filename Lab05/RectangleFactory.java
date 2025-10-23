/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author alanpo
 */
public class RectangleFactory implements ShapeFactory {

  @Override
  public Shape createShape(Scanner sc) {
    PointFactory pf = new PointFactory();
    Point p = pf.createPoint(sc);
    System.out.println("Enter width:");
    int width = sc.nextInt();
    System.out.println("Enter height:");
    int height = sc.nextInt();
    return new Rectangle(width, height, p);
  }

}
