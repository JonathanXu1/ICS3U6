/*
 * Variables 3
 * Creates 2 integers and outputs sum, difference, product, quotient, remainder
 * Jonathan Xu
 * Feb 8, 3038
*/

import java.util.Scanner;

class Variables3{
  public static void main(String[]args){
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter the first number: ");
    int num1 = reader.nextInt();
    System.out.println("Enter the second number: ");
    int num2 = reader.nextInt();
    reader.close();
    
    System.out.println(num1 + "+" + num2);
    System.out.println(num1 + num2);
    System.out.println(num1 + "-" + num2);
    System.out.println(num1 - num2);
    System.out.println(num1 + "*" + num2);
    System.out.println(num1 * num2);
    System.out.println(num1 + "/" + num2);
    System.out.println(num1 / num2);
    System.out.println(num1 + "%" + num2);
    System.out.println(num1 % num2);
  }
}