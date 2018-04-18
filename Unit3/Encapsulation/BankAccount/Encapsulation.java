/**
 * Encapsulation
 * A bank account system, updated with encapsulation
 * Jonathan Xu
 * April 18, 2018
*/

import java.util.Scanner;

public class Encapsulation{
  public static void main(String[] args){
    int choice;
    double num;
    String response;
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Would you like to make a standard account(1), a savings account(2), or a checking account(3)?");
    choice = input.nextInt();
    System.out.println("Enter inital amount:");
    num = input.nextDouble();
    
    BankAccount account;
    
    if(choice == 1){
      account = new BankAccount(num);
    }
    else if(choice == 2){
      account = new SavingsAccount(num);
    }
    else{
      account = new CheckingAccount(num);
    }
    
    
    System.out.println("Would you like to make a withdrawal? [y/n]");
    response = input.next();
    if (response.toLowerCase().equals("y")){
      System.out.println("How much? $");
      num = input.nextDouble();
      account.withdraw(num);
    }
    System.out.println("Would you like to make a deposit? [y/n]");
    response = input.next();
    if (response.toLowerCase().equals("y")){
      System.out.println("How much? $");
      num = input.nextDouble();
      account.deposit(num);
    }
    
    System.out.println("That is all.");
    if(account instanceof BankAccount){
      System.out.println("Balance: " + account.getBalance());
    }
    
  }
}