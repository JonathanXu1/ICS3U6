/**
 * File1
 * Asks a user for their address info and saves it to a file
 * Jonathan Xu
 * March 20, 2018
*/

import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

class File1{
  public static void main (String[] args) throws Exception{
    File file = new File("file1.txt");
    PrintWriter output = new PrintWriter(file);
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your address: ");
    String address = input.nextLine();
    input.close();
    output.println(address);
    output.close();
  }
}