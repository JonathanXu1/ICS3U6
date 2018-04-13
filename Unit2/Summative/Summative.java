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
    //Prints paths
    for (int i = 0; i < paths.length(); i++){
      if (paths.substring(i, i+1).equals("*")){
        System.out.println();
      }
      else{
        System.out.print(paths.substring(i,i+1));
      }
    }
    
    //Finds all traps
    String[] alltraps = findTrap(world);
    
    //Lays down traps
    int[][] traps = trapMap(world, alltraps, paths); //Logs traps in a new map
    
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
   * Creates a string array logging the trap co-ordinates
  */
  public static String[] findTrap(int[][] map) throw Exception{
    int count = 0;
    
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map.length; j++){
        if(map[i][j] == 4){
          count ++;
        }
      }
    }
    
    String[] traps = new String[count + 1]; //Initializes a string array
    traps[0] = Integer.toString(count); //First index is # of traps
    count = 1;
    for (int i = 0; i < map.length; i++){
      for (int j = 0; j < map.length; j++){
        if(map[i][j] == 4){
          traps[count] = Integer.toString(j) + "," + Integer.toString(i); //xy co-ordinates of trap saved as string
          count ++;
        }
      }
    }
    
    return traps;
  }
  
  /*
   *Place traps
  */
  public static String[][] trapMap(int[][] map, String[] traps, String dir){
    int count, bincount = 0;
    int x, y = 1;
    int trapx, trapy;
    flag trapped;
    String binary, loc;
    for(int i = 0; i<dir.length(); i++){ //Seperates the single line of paths into an array
      if(dir.charAt(i) == "*"){
        count++;
      }
    }
    String[] paths = new String[count];
    for (int i = 0; i < count; i ++){
      paths[i] = dir.substring(0, dir.indexOf("*"));
      dir = dir.substring(dir.indexOf("*") + 1);
    }
    
    int[][] empty = new int[map.length][map.length] ;
    bincount = 0; //Resets counter for use in binary traps
    
    //Iterates through all possible combinations of traps
    while(!works){
      works = true;
      bincount++;
      binary = Integer.toBinaryString(bincount);
      for(int i = binary.length()-1; i >=0; i--){
        loc = traps[binary.length()-i-1];
        trapx = Integer.parseInt(loc.substring(0, loc.indexOf(" ")));
        trapy = Integer.parseInt(loc.substring(loc.indexOf(" ")+1));
        if(binary.charAt(i) == "1"){
          empty[trapy][trapx] = 1;
        }
        else{
          empty[trapy][trapx] = 0;
        }
      }
      
      for (int i = 0; i < count, i++){
        trapped = false;
        for (int j = 0; j < paths[i].length; j++){
          if(paths[i].substring(j, j+1).equals("U")){
            y -= 1;
          }
          else if(paths[i].substring(j, j+1).equals("D")){
            y += 1;
          }
          else if(paths[i].substring(j, j+1).equals("L")){
            x -= 1;
          }
          else if(paths[i].substring(j, j+1).equals("R")){
            x += 1;
          }
          if (empty[y][x] == 1){
            trapped = true;
          }
        }
        if (!trapped){
          works = false;
        }
      }
    }
  }
  
}
