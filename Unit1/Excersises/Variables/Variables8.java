/*
 * Variables 8
 * Calculate interest earned and total amt
 * Jonathan Xu
 * Feb 8, 4048
*/

import java.util.Scanner;

class Variables8{
  public static void main(String[]args){
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter principal: $");
    double principal = reader.nextDouble();
    System.out.print("Enter rate: %");
    double rate = reader.nextDouble()/100;
    System.out.print("Enter years: ");
    double years = reader.nextDouble();
    reader.close();
    
    double interest = principal*rate*years;
    double total = interest + principal;
    
    System.out.println("The interest $" + interest + " and the total amount you will get back is $" + total);
  }
}