/*
 * Selection 9
 * Asks user for 3 words and outputs them inalphabetical order
 * Jonathan Xu
 * February 15, 2018
*/


import java.util.Scanner;

public class Selection9 {
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter word 1:");
    String w1 = input.nextLine();
    System.out.print("Enter word 2:");
    String w2 = input.nextLine();
    System.out.print("Enter word 3:");
    String w3 = input.nextLine();
    
    int compare1 = w1.compareTo(w2);
    int compare2 = w1.compareTo(w3);
    int compare3 = w2.compareTo(w3);
    
    if(compare1 > 0){
      if(compare3 > 0){
        System.out.println(w1 + " " + w2 + " " + w3);
      }
      else if (compare2 <= compare3){
        System.out.println(w1 + " " + w3 + " " + w2);
      }
    }
    if(compare1 == 0){
      if(compare3 >= 0){
        System.out.println(w3 + " " + w2 + " " + w1);
      }
      else if (compare3 < 0){
        System.out.println(w1 + " " + w2 + " " + w3);
      }
    }
    else{
      if(compare3 >= 0){
        System.out.println(w3 + " " + w2 + " " + w1);
      }
      else if (compare3 < 0){
        System.out.println(w2 + " " + w3 + " " + w1);
      }
    }
  }
}