/*
 * For 6
 * Counts from a number to another number
 * Jonathan Xu
 * Feb 16, 2018
*/

import java.util.Scanner;

public class For6{
  public static void main (String[] args){
    Scanner input = new Scanner (System.in);
    System.out.print("Where should I start counting?");
    int start = input.nextInt();
    System.out.print("Where should I stop counting?");
    int end = input.nextInt();
    for(int i = start; i <= end; i++){
      System.out.println(i);
    }
    input.close();
  }
}