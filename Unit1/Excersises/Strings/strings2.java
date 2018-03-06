/*
 * Strings2
 * Asks for sentence and makes all chars lowercase except first one
 * Jonathan Xu
 * February 12, 2018
*/

import java.util.Scanner;

class Strings2 {
  public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter word:");
    String sentence = input.nextLine();
    String proper = sentence.substring(0,1).toUpperCase() + sentence.substring(1).toLowerCase();
    System.out.println(proper);
  }
}