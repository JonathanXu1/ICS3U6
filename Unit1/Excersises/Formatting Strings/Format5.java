/*
 * Format5
 * Calculates the average
 * Jonathan Xu
 * February 13, 2018
*/

import java.util.Scanner;

class Format5 {
  public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter your name:");
    String name = input.nextLine();
    String[] subject = new String[4];
    double[] mark = new double[4];
    
    for(int x = 1; x < 5; x++){
      System.out.printf("Please enter your period %d subject name:", x);
      subject[x-1] = input.nextLine();
      System.out.printf("Please enter your period %d mark:", x);
      mark[x-1] = input.nextDouble();
      input.nextLine();
    }
    
    System.out.printf("Student Profile: %-s", name);
    
    for(int x = 1; x < 5; x++){
      System.out.println("");
      System.out.printf("%s %-.3d", subject[x-1], mark[x-1]);
    }
  }
}