/**
 * Methods4
 * Determines the GCF of two numbers
 * Jonathan Xu
 * March 1, 2018
*/

import java.util.Scanner;

public class Methods4 {
  public static void main(String[] args){
    Scanner input = new Scanner (System.in);
    System.out.print("Enter first int:");
    int term1 = input.nextInt();
    System.out.print("Enter second int:");
    int term2 = input.nextInt();
    input.close();
    System.out.println("The GCF is " + Methods4.findGcf(term1, term2));
  }
  /**
   * findGcf
   * Takes two numbers and outputs the GCF
   * @param Two integers representing terms 1 and 2
   * @return An int representing the GCF
  */
    
  public static int findGcf(int a, int b){
    int greater, smaller;
    if (a > b){
      greater = a;
      smaller = b;
    }
    else {
      greater = b;
      smaller = a;
    }
    int gcf =  0;
    for (int i = 1; i <= smaller; i++){
      if (greater%i == 0 && smaller%i == 0){
        gcf = i;
      }
    }
    return gcf;
  }
}