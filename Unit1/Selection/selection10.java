/*
 * Selection 10
 * Help user pick a new car
 * Jonathan Xu
 * February 15, 2018
*/


import java.util.Scanner;

public class Selection10 {
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.print("Do you have $200,000 to $500,000?");
    String answer = input.nextLine().toLowerCase();
    if (answer.equals("y")){
      System.out.print("Do you want to get places quickly?");
      answer = input.nextLine().toLowerCase();
      if (answer.equals("y")){
        System.out.print("Purchase a lamborghini Aventador?");
      }
      else {
        System.out.print("Purchase a Rolls-Royce Phantom");
      }
    }
    else {
      System.out.print("Do you have $100,000 to $200,000?");
      answer = input.nextLine().toLowerCase();
      if (answer.equals("y")){
        System.out.print("Do you like imports?");
        answer = input.nextLine().toLowerCase();
        if (answer.equals("y")){
          System.out.print("Purchase a Nissan GTR");
        }
        else {
          System.out.print("Purchase a Dodge Viper SRT");
        }
      }
      else {
        System.out.print("Purchase a Honda Fit");
      }
    }
  }
}