/**
 * Methods2
 * Caclulates the legnth of the line and slope created from 2 points
 * Jonathan Xu
 * March 1, 2018
*/

import java.util.Scanner;

public class Methods2 {
  public static void main (String[] args){
    Scanner input = new Scanner (System.in);
    System.out.print("Enter x for point1:");
    int x1 = input.nextInt();
    System.out.print("Enter y for point1:");
    int y1 = input.nextInt();
    System.out.print("Enter x for point2:");
    int x2 = input.nextInt();
    System.out.print("Enter y for point2:");
    int y2 = input.nextInt();
    input.close();
    
    System.out.println("The length of the line is:" + Methods2.findLine(x1, y1, x2, y2));
    System.out.println("The slope of the line is:" + Methods2.findSlope(x1, y1, x2, y2));
  }
  /**
   * findLine
   * Finds the length of a line created by two points
   * @param four integers representing the x and y values of the two points
   * @return A double representing the line length
  */ 
  public static double findLine (int x1, int y1, int x2, int y2){
    double deltaX = (x2-x1);
    double deltaY = (y2-y1);
    return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
  }
  /**
   * findSlope
   * Finds the slope of a line created by two points
   * @param four integers representing the x and y values of the two points
   * @return A double representing the line slope
   */ 
  public static double findSlope (int x1, int y1, int x2, int y2){
    double slope = (y2-y1)/(x2-x1);
    return slope;
  }
}