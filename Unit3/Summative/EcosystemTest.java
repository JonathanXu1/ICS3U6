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

    Ecosystem ecosystem = new Ecosystem(s, w);
    DisplayGrid grid = new DisplayGrid(ecosystem.getMap());//Set up Grid Panel
    
    do{
      ecosystem.growGrass();
      ecosystem.moveAnimals();
      grid.refresh();
      System.out.println("refreshed!");
      try{ Thread.sleep(1000); }catch(Exception e) {};
    } while(!ecosystem.checkOver());
    
  }
}