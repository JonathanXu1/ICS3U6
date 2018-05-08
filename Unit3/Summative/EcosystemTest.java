/**
 * EcosystemTest
 * A program that simulates a basic environment comprising of sheep, grass, and wolves
 * Jonathan Xu
 * April 23, 2018
 * 40 / 5
*/

import java.util.Scanner;
import javax.swing.JOptionPane;

public class EcosystemTest{
  public static void main(String[] args){
    int s, w, d, r;
    String info;
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Welcome to the ecosystem simulator!");
    d = Integer.parseInt(JOptionPane.showInputDialog("Enter grid dimsension (recommended 40): "));
    s = Integer.parseInt(JOptionPane.showInputDialog("Enter initial sheep num (recommended 200):"));
    w = Integer.parseInt(JOptionPane.showInputDialog("Enter initial wolf num (recommended 10):"));
    r = Integer.parseInt(JOptionPane.showInputDialog("Enter plant spawning rate of new plant nodes disregarding growth probabilities (recommended 3):"));
    info = JOptionPane.showInputDialog("Would you like to see organism info? [y/n]").toLowerCase();
    input.close();

    Ecosystem ecosystem = new Ecosystem(s, w, d, r);
    
    DisplayGrid grid = new DisplayGrid(ecosystem.getMap(), ecosystem.updateCount(), info); //Set up Grid Panel
    boolean over = false;
    
    try{ 
      Thread.sleep(2000); 
    } catch(Exception e) {};
    
    do{
      ecosystem.growGrass(); //Looks for grass and grows them over time
      ecosystem.moveAnimals(); //Sheep and wolves move around
      ecosystem.updateCount();
      grid.refresh();
      over = ecosystem.checkOver();
    try{ 
      Thread.sleep(100); 
     } catch(Exception e) {};
    } while(!over); //Continues running until one species becomes extinct
  }
}