/**
 * Geometry Program
 * Can create triangles, set lines, and co-ordinates
 * Jonathan Xu
 * April 18, 2018
*/

import java.util.Scanner;

public class Geometry{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int x, y;
    
    System.out.println("Welcome to the triangle creator!");
    GeoCoordinate[] coordinates = new GeoCoordinate[3];
    GeoLine[] lines = new GeoLine[3];
    GeoTriangle area;
    
    for(int i = 1; i < 4; i++){
      System.out.print("Enter x value of point " + i);
      x = input.nextInt();
      System.out.print("Enter y value of point " + i);
      y = input.nextInt();
      coordinates[i-1] = new GeoCoordinate(x, y);
    }
    
    System.out.println("Calculating line lengths");
    lines[0] = new GeoLine(coordinates[0], coordinates[1]);
    lines[1] = new GeoLine(coordinates[1], coordinates[2]);
    lines[2] = new GeoLine(coordinates[2], coordinates[0]);
    
    System.out.println("Calculating area");
    area = new GeoTriangle(lines[0], lines[1], lines[2]);
    System.out.println(area.getArea());
  }
}