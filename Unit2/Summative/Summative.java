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
    String response, traps, minTraps;
    int count = 0;
    int maxSteps;
    String[] trapMap;
    
    // Welcome
    System.out.println("Welcome to the monster hunter mini world!");
    System.out.print("Enter your filename (including .txt extension");
    response = input1.nextLine();
    input1.close();
    
    //Initialize
    File file = new File(response);
    Scanner input2 = new Scanner(file);
    int[][] world = loadMap(input2); //Converts map into numbers
        
    //Finds paths
    String paths = findPath(1, 1, 1, world, "");
    for(int i = 0 ; i < paths.length(); i++){
      if (paths.charAt(i) == '*'){
        count++;
      }
    }
    String[] path = new String[count];
    for(int i = 0; i < count; i++){
      path[i] = paths.substring(0, paths.indexOf("*"));
      paths = paths.substring(paths.indexOf("*") + 1);
    }
    
    //Finds all used traps
    System.out.println("Used trap co-ordinates:");
    traps = findTrap(world, path);
    System.out.println(traps.substring(traps.indexOf(" ")+1));
    
    //Finds min number of traps
    System.out.println("Minimum trap co-ordinates:");
    minTraps = placeTrap(traps, path);
    System.out.println(minTraps);
    
    //Outputs solution
    File solution = new File("solution.txt");
    PrintWriter output = new PrintWriter(solution);
    input2 = new Scanner(file);
    trapMap = drawMap(input2, minTraps);
    for(int i = 0; i < trapMap.length; i++){
      output.println(trapMap[i]);
    }
    input2.close();
    
    //Finds max steps
    System.out.println("Max steps:");
    maxSteps = countSteps(path, minTraps);
    System.out.println(maxSteps);
    output.println("Maximum steps it will take for the monster to get trapped:" + maxSteps);
    output.close();
  }
  
  /**
   * loadMap
   * This method reads a map.txt file and converts it to an easier to understand 2D array.
   * @param The scanner for the text file that visually represents the maze.
   * @return A 2D array, in which walls, possible trap positions, starting and ending points are represented with integers.
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
   *findPath
   * This method takes an the xy co-ordinates of a marker, looks at the map, and moves the marker recursively to all open paths.
   * @param Two ints representing the xy co-ordinates of the marker, an int for step count, a 2D int array representing the map,
   * and a string of previous turns taken.
   * @return A string representing all the paths that can be taken from the start to the finish point
   */
  public static String findPath(int x, int y, int step, int[][] map, String line) throws Exception {
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
        output += findPath(x, y-1, step, map, line + "U");
      }
      if(map[y][x+1] != 1){
        output += findPath(x+1, y, step, map, line + "R");
      }
      if(map[y+1][x] != 1){
        output += findPath(x, y+1, step, map, line + "D");
      }
      if(map[y][x-1] != 1){
        output += findPath(x-1, y, step, map, line + "L");
      } 
    }
    map[y][x]=prevNumber;
    return output;
  }
  
  /**
   *findTrap
   * This method accepts a map and a set of paths. It finds the number of possible trap locations and the location of them.
   * @param A 2D int array representing the map, and a string array of paths
   * @return A string that represents the xy co-ordinates of the possible trap locations
   */
  public static String findTrap(int[][] map, String[] dir){
    int count = 0;
    int x,y;
    String path;
    String traps = "";
    for(int i = 0; i < dir.length; i++){
      x = 1;
      y = 1;
      path = dir[i];
      for(int j = 0; j < path.length(); j++){
        if(path.charAt(j) == 'U'){
          y --;
        }
        else if(path.charAt(j) == 'D'){
          y ++;
        }
        else if(path.charAt(j) == 'L'){
          x --;
        }
        else if(path.charAt(j) == 'R'){
          x ++;
        }
        if(map[y][x] == 4 && !traps.contains(Integer.toString(x) + "," + Integer.toString(y))){
          traps += Integer.toString(x) + "," + Integer.toString(y) + " ";
          count++;
        }
      }
    }
    return count + " " + traps;
  }
  
  /**
   *placeTrap
   * This method accepts a set of possible trap locations and a set of paths.
   * It activates each possible combination of traps and determines if all paths can travel through it
   * @param A string that represents the xy co-ordinates of the set of traps and a string array which contains individual paths
   * @return A string that represents the xy co-ordinates of the minimum number of traps required
  */
  public static String placeTrap(String traps, String[] dir){
    int trapCount = Integer.parseInt(traps.substring(0, traps.indexOf(" ")));
    traps = traps.substring(traps.indexOf(" ")+1);
    String binStr, actiTrap;
    int x, y, actiCount;
    boolean trapped, works;
    String minTrap = "";
    int min = Integer.MAX_VALUE;
    
    //Copies trap co-ordinates from string data to 2 arrays
    int[] trapx = new int[trapCount];
    int[] trapy = new int[trapCount];
    for(int i = 0; i < trapCount; i++){
      trapx[i] = Integer.parseInt(traps.substring(0, traps.indexOf(",")));
      trapy[i] = Integer.parseInt(traps.substring(traps.indexOf(",") + 1, traps.indexOf(" ")));
      traps = traps.substring(traps.indexOf(" ") + 1);
    }
    
    //Iterates through all traps in binary
    for(int i = 1; i <= Math.pow(2, trapCount)-1; i++){
      binStr = Integer.toBinaryString(i);
      actiTrap = " ";
      actiCount = 0;
      
      for(int j = binStr.length()-1; j >= 0; j--){ //Activates corresponding traps
        if(binStr.charAt(j) == '1'){
          actiTrap += trapx[binStr.length()-j-1] + "," + trapy[binStr.length()-j-1] + " ";
          actiCount ++;
        }
      }
      
      //Navigates through each working path to see if the monster gets trapped
      works = true;
      for(int j = 0; j < dir.length; j++){
        x = y = 1;
        trapped = false;
        for(int k = 0; k < dir[j].length(); k++){
          if(dir[j].charAt(k) == 'U'){
            y --;
          }
          else if(dir[j].charAt(k) == 'D'){
            y ++;
          }
          else if(dir[j].charAt(k) == 'L'){
            x --;
          }
          else if(dir[j].charAt(k) == 'R'){
            x ++;
          }
          if(actiTrap.contains(" " + Integer.toString(x) + "," + Integer.toString(y) + " ")){ //Lands on an activated trap
            trapped = true;
          }
        }
        if(!trapped){
          works = false;
        }
      }
      if (works && actiCount < min){
        min = actiCount;
        minTrap = actiTrap;
      }
    }
    return minTrap;
  }
  
  /**
   *drawMap
   * This method accepts the map file and replaces the activated traps with the letter "T"
   * @param A scanner of the map file, and a string of the traps to activate.
   * @return A string array of the modified map, one line per row of the map.
   */
  public static String[] drawMap(Scanner in, String traps) throws Exception{
    String symbol;
    String line = in.nextLine();
    int len = line.length();
    int count = 1;
    
    String[] finalMap = new String[len];
    for(int i = 0; i < len; i++){
      finalMap[i] = "";
    }
    
    for (int y = 0; y < len; y++){
      for (int x = 0; x < len; x++){
        symbol = line.substring(x, x+1);
        if (traps.contains(" " + Integer.toString(x) + "," + Integer.toString(y) + " ")){
          finalMap[y] += "T";
        }
        else{
          finalMap[y] += symbol;
        }
      }
      count ++;
      if (count <= len){
        line = in.nextLine();
      }
    }
    
    return finalMap;
  }
  
 /**
   *countSteps
   * This method takes a path and outputs the minimum number of steps the monster can take before it gets trapped.
   * @param A string array of all paths to the food source, and a string representing the xy co-ordinates of all activated traps.
   * @return An integer, representing the max number of steps the monster can take before getting trapped.
   */
  public static int countSteps(String[] p, String traps){
    int max = 0;
    int x, y;
    int count;
    boolean trapped ;
    for(int i = 0; i < p.length; i++){
      x = y = 1;
      count = 1;
      trapped = false;
      for(int j = 0; j < p[i].length(); j++){
        if(p[i].charAt(j) == 'U'){
          y --;
        }
        else if(p[i].charAt(j) == 'D'){
          y ++;
        }
        else if(p[i].charAt(j) == 'L'){
          x --;
        }
        else if(p[i].charAt(j) == 'R'){
          x ++;
        }
        count++;
        if(traps.contains(" " + Integer.toString(x) + "," + Integer.toString(y) + " ") && !trapped){
          trapped = true;
          if(count > max){
            max = count;
          }
        }
      }
    }
    return max;
  }
}