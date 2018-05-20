/*
 * While3
 * Prompts for numbers utnil zero is entered
 * Jonathan Xu
 * Feb 15, 2018
*/

import java.util.Scanner;
import java.util.Random;

public class While3{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    float total = 0;
    int count = 0;
    System.out.print("Enter number:");
      int number = input.nextInt();
    while (number != 0) {
      System.out.print("Enter number:");
      number = input.nextInt();
      count ++;
      total += number;
    }
    System.out.print("You entered  " + count + " numbers and the average is " + total/count);
  }
}