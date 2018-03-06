/*
 * Selection 5
 * Evaluates marks
 * Jonathan Xu
 * February 14, 2018
*/

import java.util.Scanner;

public class Selection5{
  public static void main(String []args){
  Scanner input = new Scanner(System.in);
  System.out.print("Enter mark:");
  Float mark = input.nextFloat();
  
  if ((mark >= 75) && (mark <= 100)) {
    System.out.println("Great");
  }
  else if ((mark >= 50)  && (mark <= 100)) {
    System.out.println("Pass");
  }
  else if ((mark >= 0)  && (mark <= 100)) {
    System.out.println("Fail");
  }
  else {
    System.out.println("Invalid");
  }
  input.close();
  }
}