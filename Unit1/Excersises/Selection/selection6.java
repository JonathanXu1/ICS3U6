/*
 * Selection 6
 * Password check
 * Jonathan Xu
 * February 14, 2018
*/

import java.util.Scanner;

public class Selection6{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter password:");
    String password = input.nextLine();
    if (password.equals("happy")){
      System.out.println("You are logged in.");
    }
    else{
      System.out.println("Incorrect password.");
    }
    input.close();
  }
}