/**
 * BoardingHouseTest
 * Main class
 * Jonathan Xu
 * April 19, 2018
*/

import java.util.Scanner;

public class BoardingHouseTest{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    boolean end = false;
    String response, name;
    int option, age, type;
    BoardingHouse boardingHouse BoardingHouse();
    
    System.out.println("Welcome to the boarding house!");
    while(!end){
      System.out.println("Choose from the options:");
      System.out.println("1. Board a pet");
      System.out.println("2. Remove a pet");
      System.out.println("3. Make a pet speak");
      System.out.println("4. Make a pet do an action");
      option = input.nextInt();
      
      System.out.println("Enter pet name:");
      name = input.nextLine();
                           
      if(option == 1){
        System.out.println("Enter pet age:");
        age = input.nextInt();
        System.out.println("Choose animal type:");
        System.out.println("1. Cat");
        System.out.println("2. Dog");
        type = input.nextInt();
        if(type == 1){
          boardingHouse.add(name, age, "cat");
        }
        else if(type == 2){
          boardingHouse.add(name, age, "dog");
        }
        System.out.println("Pet added!");
      }
      else if(option == 2){
        boardingHouse.remove(name);
      }
      else if(option == 3){
        boardingHouse.speak(name);
      }
      else if(option == 4){
        boardingHouse.action(name);
      }
      
      System.out.println("Would you like to do another action?");
      response = input.nextLine();
      if(response.toLowerCase().equals("n")){
        end = true;
        System.out.println("Thanks for boarding with us!");
      }
    }
    
    input.close();
  }
}