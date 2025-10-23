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
public class PointFactory {
  public Point createPoint(Scanner sc){
    System.out.println("Enter x:");
    int x = sc.nextInt();
    System.out.println("Enter y:");
    int y = sc.nextInt();
    return new Point(x, y);
  }
}
