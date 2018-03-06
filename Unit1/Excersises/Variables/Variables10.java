/*
 * Variables 10
 * Determines # of roots in a quadratic
 * Jonathan Xu
 * Feb 8, 4048
*/

import java.util.Scanner;

class Variables10{
  public static void main(String[]args){
    Scanner reader = new Scanner(System.in);
    System.out.println("Assuming the quatratic is of form Ax^2 + Bx + C,");
    System.out.println("Enter A:");
    int a = reader.nextInt();
    System.out.println("Enter B:");
    int b = reader.nextInt();
    System.out.println("Enter C:");
    int c = reader.nextInt();
    reader.close();
    
    double discriminant = Math.pow(b,2) - 4*a*c;
    System.out.println("The discriminant is " + discriminant);
  }
}