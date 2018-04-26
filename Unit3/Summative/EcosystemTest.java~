/**
 * EcosystemTest
 * A program that simulates a basic environment comprising of sheep, grass, and wolves
 * Jonathan Xu
 * April 23, 2018
*/

import java.util.Scanner;

public class EcosystemTest{
  public static void main(String[] args){
    int s, w;
    
    Scanner input = new Scanner(System.in);
    
    String[][] map = new String[25][25];
    updateMap(map);
    DisplayGrid grid = new DisplayGrid(map);//Set up Grid Panel
    
    System.out.println("Enter initial sheep num:");
    s = input.nextInt();
    System.out.println("Enter initial wolf num:");
    s = input.nextInt();

    Ecosystem ecosystem = new Ecosystem(s, w);
    
    while(true){
      Ecosystem.growGrass();
      Ecosystem.moveSheep();
      grid.refresh();
      try{ Thread.sleep(1000); }catch(Exception e) {};
    }
    
    input.close();
  }
}