/*
 * Selection 4
 * Guessing game
 * Jonathan Xu
 * February 14, 2018
*/

import java.util.Scanner;

public class Selection4{
  public static void main(String []args){
  Scanner input = new Scanner(System.in);
  System.out.print("Enter secret number(1-10):");
  int num = input.nextInt();
  System.out.print("Guess the number:");
  int guess = input.nextInt();
  
  if (num == guess) {
    System.out.println("You win!");
  }
  else {
    System.out.println("Game over.");
  }
  input.close();
  }
}