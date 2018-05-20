/*
 * Selection 7
 * Outputs higher mark
 * Jonathan Xu
 * February 14, 2018
*/

import java.util.Scanner;

public class Selection7{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter mark 1:");
    float mark1 = input.nextFloat();
    while (mark1 > 100 || mark1 < 0) {
      System.out.println("Invalid Response");
      System.out.print("Enter mark 1:");
      mark1 = input.nextFloat();
    }
    System.out.print("Enter mark 2:");
    float mark2 = input.nextFloat();
    while (mark2 > 100 || mark2 < 0) {
      System.out.println("Invalid Response");
      System.out.print("Enter mark 2:");
      mark2 = input.nextFloat();
    }
    if (mark1 >= mark2){
      System.out.println(mark1);
    }
    else{
      System.out.println(mark2);
    }
    input.close();
  }
}