/**
 * MHMW Summative
 * The monster hunter assignment
 * Jonathan Xu
 * March 27, 2018
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Summative {
  public static void main(String[] args) throws Exception{
    Scanner input1 = new Scanner(System.in);
    String response;
    
    // Welcome
    System.out.println("Welcome to the monster hunter mini world!");
    System.out.print("Enter your filename (including .txt extension");
    response = input1.nextLine();
    
    //Initialize
    File file = new File(response);
    Scanner input2 = new Scanner(file);
    int[][] world = loadMap(input2);
    
    //Prints map
    for (int i = 0; i < world.length; i++){
      for(int j = 0; j < world.length; j++){
        System.out.print(world[i][j]);
        if(world[i][j] = 2){ //Find starting position
          int[] start = [j, i];
        }
        System.out.println();
    }
    
    System.out.println("All possible paths:");
    System.out.println(findpath(1, 1, 1, world));
      
    input1.close();   
    input2.close();
  }
  
  /**
   * keypoints
  */
  public static int[][] loadMap(Scanner in) throws Exception{
    String symbol;
    String line = in.nextLine();
    int len = line.length();
    int count = 1;
    
    int[][] map = new int[len][len];
    
    for (int i = 0; i < len; i++){
      count ++;
      for (int j = 0; j < len; j++){
        symbol = line.substring(j, j+1);
        if ("+-|".contains(symbol)){
          map[i][j] = 1;
        }
        else if (symbol.equals("N")){
          map[i][j] = 2;
        }
        else if (symbol.equals("F")){
          map[i][j] = 3;
        }
        else if (symbol.equals("P")){
          map[i][j] = 4;
        }
      }
      if (count <= len){
        line = in.nextLine();
      } 
    }
    
    return map;
  }
  
  
  /**
   * keypoints
  */
  public static int findpath(int x, inty, int step, int[][] map) throws Exception {
    map[x][y] = 5; //Traveled places
    step ++;
    
    if (x == map.length-1 && y == map.length-2){ //If met destinatinon
      return steps;
    }
    else {
      if (map[x][y-1] != 1 || map[x+1][y] != 1 || map[x][y+1] != 1 || map[x-1][y] != 1){ //Not dead end
        if(map[x][y-1] != 1){
          return findpath(x, y-1, step, map) + "f";
        }
        if(map[x+1][y] != 1){
          return findpath(map[x+1][y] + "r";
        }
        if(map[x][y+1] != 1){
        }
        if(map[x-1][y] != 1){
        }
      }
      else {
      }
    }
  }
}