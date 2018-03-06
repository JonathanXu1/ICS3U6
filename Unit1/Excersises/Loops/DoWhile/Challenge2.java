/*
 * Challenge2
 * Coputes the factorial of a number
 * Jonathan Xu
 * Feb 16, 2018
*/

import java.util.Scanner;

public class Challenge2{
  public static void main(String []args){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number:");
    int number = input.nextInt();
    int count1 = 0;
    int count2 = 0;
    
    do{
      count1 ++;
      count2 = 1;
      do{
        count2 ++;
        System.out.print(count1);
      }while (count1 >= count2);
      
      System.out.println();
    }while (count1 < number);
  }
}