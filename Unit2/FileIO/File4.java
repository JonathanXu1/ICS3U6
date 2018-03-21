/**
 * File4
 * Encodes/decodes a file
 * Jonathan Xu
 * March 20, 2018
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class File4 {
  public static void main (String[] args) throws Exception{
    File encoded = new File ("file4.coded");
    File decoded = new File ("file4.txt");
    Scanner input1 = new Scanner(System.in);
    String line;

    System.out.println("Would you like to:");
    System.out.println("A: Encode a file");
    System.out.println("B: Decode a file");
    String choice = input1.next().toLowerCase();
    
    System.out.println("Enter filename (must be in root directory, and include extension):");
    String name = input1.next();
    File file = new File(name);
    Scanner input2 = new Scanner(file);
    
    if (choice.equals("a")){
      System.out.println("Encoding file...");
      PrintWriter output = new PrintWriter(encoded);
      while(input2.hasNext()){
        line = input2.nextLine();
        output.println(encode(line));
      }
      output.close();
      System.out.println("Encoding complete!");
      System.out.println("File saved to file4.coded.");
    }
    else if (choice.equals("b")){
      System.out.println("Decoding file...");
      PrintWriter output = new PrintWriter(decoded);
      while (input2.hasNext()){
        line = input2.nextLine();
        output.println(decode(line));
      }
      output.close();
      System.out.println("Decoding complete!");
      System.out.println("File saved to file4.txt.");
    }
    
    input1.close();
    input2.close();
  }
  
  public static String encode (String content){
    String output = "";
    int number;
    for (int i = 0; i< content.length(); i++){
      number = content.charAt(i);
      output += Integer.toString(number) + " ";
    }
    return output;
  }
  
  public static String decode (String content) throws Exception{
    String output = "";
    int number;
    while (content.length() > 0){
      if (content.indexOf(" ") == -1){     //If the line doesn't contain strings anymore
        number = Integer.parseInt(content);
        output += (char) number;
        content = "";
      } 
      else {
        number = Integer.parseInt(content.substring(0, content.indexOf(" ")));
        output += (char) number;
        content = content.substring(content.indexOf(" ")+1);
      }

    }
    return output;
  }
}