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
    Scanner input1 = new Scanner(System.in);
    int count = 0;
    String line;

    System.out.println("Would you like to:");
    System.out.println("A: Encode a file");
    System.out.println("B: Decode a file");
    String choice = input1.next().toLowerCase();
    System.out.println("Enter filename (must be in root directory, and include extension):");
    String content = input1.next();
    
    File file = new File(content);
    Scanner input2 = new Scanner(file);
    
    if (choice.equals("a")){
      System.out.println("Encoding file...");
      PrintWriter output = new PrintWriter(encoded);
      while(input2.hasNext()){
        line = input2.nextLine();
        for (int i =0; i < line.length(); i++){
          output.print(encode(line)[i] + " ");
        }
        output.println();
      }
      output.close();
      System.out.println("Encoding complete!");
    }
    else if (choice.equals("b")){
      System.out.println("Decoding file...");
      while (input2.hasNext()){
        line = input2.nextLine();
        for (int i =0; i < line.length(); i++){
          output.print(decode(line));
        }
        output.println();
      }
      System.out.println("Decoding complete!");
    }
    

    input1.close();
    input2.close();
  }
  
  public static int[] encode (String content){
    int[] output = new int [content.length()];
    for (int i = 0; i< content.length(); i++){
      if (!content.substring(i, i+1).equals(" ")){
        output[i] = content.charAt(i);
      }
    }
    return output;
  }
  
  public static String decode (String content){
    String output = "";
    String number;
    while (content.length() > 0){
      number = content.substring(0, content.indexOf(" "));
      for (int i = 0; i < number.length(); i++){
        output += (char) number.charAt(i);
      }
      output += " ";
      content = content.substring(content.indexOf(" "));
    }
    return output;
  }
}