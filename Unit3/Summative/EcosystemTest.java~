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
    DisplayGrid grid = new DisplayGrid(ecosystem.getMap(), ecosystem.updateCount()); //Set up Grid Panel
    
    try{ Thread.sleep(2000); 
      }catch(Exception e) {};
    
    do{
      ecosystem.growGrass(); //Looks for grass and grows them over time
      ecosystem.moveAnimals(); //Sheep and wolves move around
      ecosystem.updateCount();
      grid.refresh();
      try{ Thread.sleep(500); 
      }catch(Exception e) {};
    } while(!ecosystem.checkOver()); //Continues running until one species becomes extinct
    
  }
}