/*
 * Loop2
 * Prompts for password and responds
 * Jonathan Xu
 * Feb 15, 2018
*/

import java.util.Scanner;
import java.util.Random;

public class While2{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    int guess = 0;
    int number = rand.nextInt(10)+1;
    while (guess != number) {
      System.out.print("Guess the number:");
      guess = input.nextInt();
    }
    System.out.print("Correct!");
  }
}
