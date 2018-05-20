/*
 * For5
 * Asks user for word and prints it i amount of times
 * Jonathan Xu
 * Feb 16, 2018
*/

import java.util.Scanner;

public class For5{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter word:");
    String word = input.nextLine();
    System.out.print("How many times do you want to print it?");
    int times = input.nextInt();
    for(int i = 1; i <= times; i++){
      System.out.println(word);
    }
    input.close();
  }
}