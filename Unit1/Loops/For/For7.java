/*
 * For 7
 * Asks user for 10 number and oututs sum, average, and highest number
 * Jonathan Xu
 * Feb 16, 2018
*/

import java.util.Scanner;

public class For7{
  public static void main (String[] args){
    Scanner input = new Scanner (System.in);
    double[] number;
    number = new double[10];
    double sum = 0;
    double highest = Double.NEGATIVE_INFINITY;
    
    for (int i = 1; i <= 10; i++){
      System.out.print("Enter number " + i);
      number[i-1] = input.nextDouble();
      if (number[i-1] > highest) {
        highest = number[i-1];
      }
      sum += number[i-1];
    }
    
    input.close();
    System.out.println("Sum: " + sum);
    System.out.println("Average: " + sum/10);
    System.out.println("Highest: " + highest);
  }
}