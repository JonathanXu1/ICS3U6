/*
 * Selection 1
 * Lets user know if they're a senior citizen
 * Jonathan Xu
 * February 14, 2018
*/

import java.util.Scanner;

public class Selection1{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number between 1 and 100:");
    int value = input.nextInt();
    if (value >= 65){
      System.out.println("You are a senior citizen.");
    }
    input.close();
  }
}