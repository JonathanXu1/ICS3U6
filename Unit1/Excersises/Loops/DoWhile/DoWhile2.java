/*
 * Do while 2
 * Brute force maths
 * Jonathan Xu
 * Feb 15, 2018
*/

import java.util.Scanner;
import java.util.Random;

public class DoWhile2{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    int num1, num2;
    
    do{
      num1 = rand.nextInt(100)+1;
      num2 = rand.nextInt(100)+1;
    }while ((num1 + num2 != 20)||(num1 * num2 != 96));
    
    System.out.println("The numbers are " + num1 + " and " + num2);
  }
}
