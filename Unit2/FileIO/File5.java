/**
 * File5
 * Creates a basic HTML webpage
 * Jonathan Xu
 * March 21, 2018
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class File5 {
  public static void main(String[] args) throws Exception{
    Scanner input = new Scanner (System.in);
    File file = new File ("file5.html");
    
    System.out.println("HTML bot started!");
    System.out.print("Enter title:");
    String title = input.nextLine();
    System.out.print("Enter body:");
    String body = input.nextLine();
    input.close();
    
    System.out.println("Generating webpage...");
    PrintWriter output = new PrintWriter(file);
    output.println("<html>");
    output.println("<head>");
    output.println("<title>" + title + "</title>");
    output.println("</head>");
    output.println("<body>" + body + "</body>");
    output.println("</html>");
    
    System.out.println("Webpage generated!");
    output.close();
  }
}