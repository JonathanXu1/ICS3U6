/**
 * File2
 * Opens a .txt document and counts the number of words it contains
 * Jonathan Xu
 * March 20, 2018
*/

import java.io.File;
import java.util.Scanner;

public class File2{
  public static void main(String[] args) throws Exception{
    File file = new File ("file2.txt");
    Scanner input = new Scanner(file);
    int count = 0;
    
    while(input.hasNext()){
      input.next();
      count++;
    }
    
    System.out.println("Words: " + count);
  }
}