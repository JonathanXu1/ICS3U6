/**
 * Methods1
 * Calculates the length of a hypotenuse
 * Jonathan Xu
 * March 1, 2018
*/

import java.util.Scanner;

public class Methods1 {
  public static void main (String[] args) {
    Scanner input = new Scanner (System.in);
    System.out.print("Enter side 1 (not hypotenuse):");
    float side1 = input.nextFloat();
    System.out.print("Enter side 2 (not hypotenuse):");
    float side2 = input.nextFloat();
    input.close();
    System.out.println("The hypotenuse is " + Methods1.getHyp(side1, side2));
  }
  
  /**
   * getHyp
   * This method accepts x and y as parameters and calculates the hypotenuse
   * @param two float values which holds the lengths of the triangle
   * @return hypotenuse
   */
  
  public static double getHyp (float x, float y) {
    return Math.sqrt(x*x + y*y);
  }
}
