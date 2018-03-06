/*
 * Selection 2
 * Lets user know if they passed
 * Jonathan Xu
 * February 14, 2018
*/

import java.util.Scanner;

public class Selection2{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your mark:");
    float mark = input.nextFloat();
    if (mark >= 50){
      System.out.println("You passed.");
    }
    else{
      System.out.println("Better luck next time.");
    }
    input.close();
  }
}