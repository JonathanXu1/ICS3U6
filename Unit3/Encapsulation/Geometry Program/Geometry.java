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
    GeoLine[] = lines = new GeoLine[3];
    
    for(int i = 0; i < 3; i++){
      System.out.print("Enter x value of point " + i+1);
      int x = input.nextInt();
      System.out.print("Enter y value of point " + i+1);
      int y = input.nextInt();
      coordinates[i] = GeoCoordinate(x, y);
    }
  }
}