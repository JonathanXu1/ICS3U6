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
    
    System.out.println("Enter initial sheep num:");
    s = input.nextInt();
    System.out.println("Enter initial wolf num:");
    w = input.nextInt();
    input.close();

    Ecosystem ecosystem = new Ecosystem(s, w); //Bad variable names - Classname should be different from variable name
    /*
     * For OOP - I like using capitalized variable names for top-level classes that actions happen to, like
     * Game or System (this is just personal preference though)
     */
    DisplayGrid grid = new DisplayGrid(ecosystem.getMap(), Ecosystem.animals); //Set up Grid Panel
    
    do{
      ecosystem.growGrass(); //Looks for grass and grows them over time
      ecosystem.moveAnimals(); //Sheep and wolves move around
      grid.refresh(); //Might want to choose a variable name that reflects the display nature of the grid. 
      try{ Thread.sleep(100); }catch(Exception e) {}; //Split this into multiple lines
    } while(!ecosystem.checkOver()); //Continues running until one species becomes extinct
    
  }
}