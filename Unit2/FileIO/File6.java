/**
 * File6
 * Creates an empty java file
 * Jonathan Xu
 * March 21, 2018
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class File6 {
  public static void main(String[] args) throws Exception {
    String scannerName = "";
    
    Scanner input = new Scanner (System.in);
    System.out.print("What is the filename?");
    String name = input.next();
    File file = new File (name + ".java");
    System.out.print("Would you like a scanner? [y/n]");
    String response = input.next();
    if (response.equals("y")){
      System.out.print("What should the scanner variable be called?");
      scannerName = input.next();
    }
    input.nextLine();
    System.out.print("Enter the message you would like the program to output:");
    String message = input.nextLine();
    System.out.println("Creating java program...");
    input.close();
    
    PrintWriter output = new PrintWriter(file);
    output.println("import java.util.Scanner;");
    output.println("public class " + name + "{");
    output.println("public static void main(String[] args) {");
    if (scannerName.length() > 0){
      output.println("Scanner " + scannerName + " = new Scanner(System.in);");
    }
    output.println("System.out.println(\"" + message + "\");");
    output.println("}");
    output.println("}");
    
    System.out.println("Program created!");
    output.close();
  }
}