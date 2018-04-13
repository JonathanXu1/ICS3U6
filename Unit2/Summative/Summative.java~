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
    int[][] world = loadMap(input2); //Converts map into numbers
    int[][] traps = trapMap(world); //Logs traps in a new map
    
    //Prints map
    for (int i = 0; i < world.length; i++){
      for(int j = 0; j < world.length; j++){
        System.out.print(world[i][j]);
      }
      System.out.println();
    }
        
    //Finds paths
    System.out.println("All possible paths:");
    String paths = findpath(1, 1, 1, world, "");
    for (int i = 0; i < paths.length(); i++){
      if (paths.substring(i, i+1).equals("*")){
        System.out.println();
      }
      else{
        System.out.print(paths.substring(i,i+1));
      }
    }
    
    //Outputs solution
    /*
    String[][] solution = 
    */
    File output = new File("solution.txt");
    PrintWriter output = new PrintWriter(output);
    
    
    input1.close();   
    input2.close();
  }
  
  /*
   * Load Map
   * Converts the chars in the txt file to a 2 dimentional int array
  */
  public static int[][] loadMap(Scanner in) throws Exception{
    String symbol;
    String line = in.nextLine();
    int len = line.length();
    int count = 1;
    
    int[][] map = new int[len][len];
    
    for (int i = 0; i < len; i++){
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
      count ++;
      if (count <= len){
        line = in.nextLine();
      } 
    }
    
    return map;
  }
  
  /**
   * Finds all paths
   */
  public static String findpath(int x, int y, int step, int[][] map, String line) throws Exception {
    int prevNumber = map[y][x];
    map[y][x] = 1; //Traveled places
    step ++;
    String output = "";
    
    if (x == map.length-1 && y == map.length-2){ //If met destinatinon
      output = line + "*";
    }
    else if (map[y-1][x] == 1 && map[y][x+1] == 1 && map[y+1][x] == 1 && map[y][x-1] == 1){ //If deadend
      output = "";
    }
    else {
      if(map[y-1][x] != 1){
        output += findpath(x, y-1, step, map, line + "U");
      }
      if(map[y][x+1] != 1){
        output += findpath(x+1, y, step, map, line + "R");
      }
      if(map[y+1][x] != 1){
        output += findpath(x, y+1, step, map, line + "D");
      }
      if(map[y][x-1] != 1){
        output += findpath(x-1, y, step, map, line + "L");
      } 
    }
    map[y][x]=prevNumber;
    return output;
  }
  
  /*
   * Trap Map
   * Creates a two dimentional int array logging the traps in the map
  */
  public static int[][] trapMap(int[][] map) throw Exception{
    int [][] output = new int[map.length][map.length];
    
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map.length; j++){
        if(map[i][j] == 4){
          output[i][j] = 1;
        }
        else{
          output[i][j] = 0;
        }
      }
    }
    return output;
  }
  
  /*
   *Place traps
  */
  public static String[][] placeTrap(int[][] map, int[][] trap, String dir){
    int count = 0;
    for(int i = 0; i<dir.length(); i++){ //Seperates the single line of paths into an array
      if(dir.substring(i, i+1).equals("*")){
        count++;
      }
    }
    String[] paths = new String[count];
    for (int i = 0; i < count; i ++){
      paths[i] = dir.substring(0, dir.indexOf("*"));
      dir = dir.substring(dir.indexOf("*") + 1);
    }
    
    
  }
}
