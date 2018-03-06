/*
 * Variables 7
 * Calculates restaurant bill
 * Jonathan Xu
 * Feb 8, 4048
*/

import java.util.Scanner;

class Variables7{
  public static void main(String[]args){
    Scanner reader = new Scanner(System.in);
    double tax = 0.13;
    System.out.print("Enter total: $");
    double total = reader.nextDouble()*(1+tax);
    System.out.print("Enter tip: %");
    double tip = reader.nextDouble()/100;
    reader.close();
    
    double grandTotal = total+total*tip;
    System.out.println("The total with tax is $" + total + ", the tip is $" + total*tip + ", and the grand total is " + grandTotal);
  }
}