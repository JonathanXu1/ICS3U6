/*
 * Do while 1
 * Asks for secret password and responds
 * Jonathan Xu
 * Feb 15, 2018
*/

import java.util.Scanner;

public class DoWhile1{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a secret password:");
    String password = input.nextLine();
    String key = "";
    
    do{
      System.out.print("Enter password:");
      key = input.nextLine();
      if (key.equals(password)){
        System.out.println("Password Accepted.");
      }
      else{
        System.out.println("Error-incorrect password.");
      }   }while (!password.equals(key));
      
  }
}
