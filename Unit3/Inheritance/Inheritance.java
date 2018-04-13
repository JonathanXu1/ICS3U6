/**
 * Inheritance
 * A bank accound system
 * Jonathan Xu
 * April 12, 2018
*/

import java.util.Scanner;

public class Inheritance{
  public static void main(String[] args){
    int choice;
    double num;
    String response;
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Would you like to make a standard account(1), a savings account(2), or a checking account(3)?");
    choice = input.nextInt();
    System.out.println("Enter inital amount:");
    num = input.nextDouble();
    
    if(choice == 1){
      BankAccount account = new BankAccount(num);
    }
    else if(choice == 2){
      SavingsAccount account = new SavingsAccount(num);
    }
    else if(choice == 3){
      CheckingAccount account = new CheckingAccount(num);
    }
    
    System.out.println("Would you like to make a withdrawal? [y/n]");
    response = input.next();
    if (response.toLowerCase.equals("y")){
      System.out.println("How much? $");
      num = input.nextDouble();
      account.withdraw(num);
    }
    System.out.println("Would you like to make a deposit? [y/n]");
    response = input.next();
    if (response.toLowerCase.equals("y")){
      System.out.println("How much? $");
      num = input.nextDouble();
      account.deposit(num);
    }
    
    System.out.println("That is all.");
    System.out.println("Balance: " + account.getBalance());    
  }
}