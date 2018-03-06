/**
 * Methods3
 * Asks for A, B, and C of a quadratic and outputs the number of roots
 * Jonathan Xu
 * March 1, 2018
*/

import java.util.Scanner;

public class Methods3 {
  public static void main(String[] args){
    Scanner input = new Scanner (System.in);
    System.out.print("Enter A:");
    int coef1 = input.nextInt();
    System.out.print("Enter B:");
    int coef2 = input.nextInt();
    System.out.print("Enter C:");
    int coef3 = input.nextInt();
    input.close();
    System.out.println("The number of roots is " + Methods3.numRoots(coef1, coef2, coef3));
  }
  /**
   * numRoots
   * Takes a, b, and c and outputs the number of real roots
   * @param Three integers representing A, B, and C
   * @return An int representing the number of solutions
  */
    
  public static int numRoots(int a, int b, int c){
    float disc = b*b - 4*a*c;
    if (disc > 0){
      return 2;
    }
    else if (disc == 0){
      return 1;
    }
    else{
      return 0;
    }
  }
}