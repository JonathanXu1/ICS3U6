/**
 * File3
 * Asks for a password and allows for password modification
 * Jonathan Xu
 * March 20, 2018
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class File3{
  public static void main (String[] args) throws Exception{
    File file = new File ("file3.txt");
    Scanner input1 = new Scanner (System.in);
    Scanner input2 = new Scanner (file);
    
    System.out.print("Enter password:");
    String response = input1.next();
    String saved = input2.next();
    input2.close();
    
    while (!response.equals(saved)){
      System.out.println("Incorrect Password!");
      System.out.print("Enter password:");
      response = input1.next();
    }
    
    System.out.println("Correct Password!");
    System.out.print("Would you like to change your password? [y/n]");
    response = input1.next().toLowerCase();
    
    if (response.equals("y")){
      System.out.print("What's the new password?");
      response = input1.next();
      PrintWriter output = new PrintWriter(file);
      output.println(response);
      output.close();
      System.out.println("Password Updated!");
      System.out.println("Quitting...");
    }
    else if (response.equals("n")){
      System.out.println("Quitting...");
    }
    
    input1.close();
  }
}