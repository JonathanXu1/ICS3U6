/*
 * Challenge
 * Retrieves secret messages from a sentence
 * Jonathan Xu
 * February 12, 2018
*/

import java.util.Scanner;

class Challenge {
  public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your secret message (\"10 words long\"):");
    String sentence = input.nextLine();
    String message = "";
    for (int x = 0; x<11; x++){
      message += sentence.substring(0,1);
      int space = sentence.indexOf(" ");
      sentence = sentence.substring(space+1);   
    }
    message = message.toLowerCase();
    System.out.println("The message is: " + message);
  }
}