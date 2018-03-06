/*
 * Variables 6
 * Calculates area and perimeter of a rectangle
 * Jonathan Xu
 * Feb 8, 4048
*/

import java.util.Scanner;

class Variables6{
  public static void main(String[]args){
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter length:");
    double length = reader.nextDouble();
    System.out.println("Enter width:");
    double width = reader.nextDouble();
    double area = length*width;
    double perimeter = 2 * length + 2 * width;
    System.out.println("The area is " + area + " and the perimeter is " + perimeter);
    reader.close();
  }
}