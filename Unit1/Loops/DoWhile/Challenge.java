/*
 * Challenge
 * Coputes the factorial of a number
 * Jonathan Xu
 * Feb 16, 2018
*/

import java.util.Scanner;

public class Challenge{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number:");
    int number = input.nextInt();
    int factorial = 1;
    int count = 0;
    
    do{
      count ++;
      factorial *= count;
    }while (count < number);
    
    System.out.println("The factorial of  " + number + " is " + factorial);
  }
}
