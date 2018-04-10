/**
 * MHMW Summative
 * The monster hunter assignment
 * Jonathan Xu
 * March 27, 2018
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class Summative {
  public static ArrayList<String> path = new ArrayList<String>();
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
      }
      System.out.println();
    }
    
    System.out.println("All possible paths:");
    findpath(1, 1, 1, world, "");
    for(String s:path){
      System.out.println(s);
    }
    
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
          map[i][j] = 1;
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
  public static void findpath(int x, int y, int step, int[][] map, String line) throws Exception {
    int prevNumber = map[y][x];
    map[y][x] = 1; //Traveled places
    step ++;
    
    if (x == map.length-1 && y == map.length-2){ //If met destinatinon
      path.add(line);
    }
    else if (map[y-1][x] == 1 && map[y][x+1] == 1 && map[y+1][x] == 1 && map[y][x-1] == 1){
    }
    else {
      if(map[y-1][x] != 1){
        findpath(x, y-1, step, map, line + "U");
      }
      if(map[y][x+1] != 1){
        findpath(x+1, y, step, map, line + "R");
      }
      if(map[y+1][x] != 1){
        findpath(x, y+1, step, map, line + "D");
      }
      if(map[y][x-1] != 1){
        findpath(x-1, y, step, map, line + "L");
      } 
    }
    map[y][x]=prevNumber;
  }
}