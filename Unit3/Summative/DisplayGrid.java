/* [DisplayGrid.java]
 * A Small program for Display a 2D String Array graphically
 * @author Mangat
 */

// Graphics Imports
import javax.swing.*;
import java.awt.*;


class DisplayGrid { 

  private JFrame frame;
  private int maxX,maxY, GridToScreenRatio;
  private Organism[][] world;
  private int[] counts;
  private boolean displayInfo = false;
  
  DisplayGrid(Organism[][] map, int[] num, String info) { 
    this.world = map;
    this.counts = num;
    
    maxX = Toolkit.getDefaultToolkit().getScreenSize().width;
    maxY = Toolkit.getDefaultToolkit().getScreenSize().height;
    GridToScreenRatio = maxY / (world.length+1);  //ratio to fit in screen as square map
    
    System.out.println("Map size: "+world.length+" by "+world[0].length + "\nScreen size: "+ maxX +"x"+maxY+ " Ratio: " + GridToScreenRatio);
    
    this.frame = new JFrame("Map of World");
    
    GridAreaPanel worldPanel = new GridAreaPanel();
    
    frame.getContentPane().add(BorderLayout.CENTER, worldPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    frame.setVisible(true);
    
    if(info.equals("y")){
      displayInfo = true;
    }
  }
  
  
  public void refresh() { 
    frame.repaint();
  }
  
  class GridAreaPanel extends JPanel {
    
    public void paintComponent(Graphics g) {        
      //super.repaint();
      
      setDoubleBuffered(true); 
      g.setColor(Color.BLACK);
      g.setFont(new Font("Calibri", Font.PLAIN, 10));
      
      for(int i = 0; i<world[0].length;i=i+1){ 
        for(int j = 0; j<world.length;j=j+1){ 
          if (world[i][j] instanceof Sheep)    //This block can be changed to match character-color pairs
            g.setColor(Color.WHITE);
          else if (world[i][j]instanceof Plant){
            if(world[i][j].getAge() >= 20){
              g.setColor(new Color(255, 204, 102));
            } else if(world[i][j].getHealth() == 20){
              g.setColor(new Color(35, 142, 48));
            } else{
              g.setColor(Color.GREEN);
            }
          } else if (world[i][j]instanceof Wolf){
            g.setColor(Color.GRAY);  
          } else {
            g.setColor(new Color(156, 93, 82));
          }
          g.fillRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
          g.setColor(Color.BLACK);
          g.drawRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
          if(displayInfo){
            if(world[i][j] != null){
              g.drawString(Integer.toString(world[i][j].getHealth()), j*GridToScreenRatio, i*GridToScreenRatio + 15);
            }
            if(world[i][j] instanceof Animal){
              if( ((Animal)world[i][j]).getGender() ){
                g.drawString("M", j*GridToScreenRatio + 10, i*GridToScreenRatio + 15);
              } else{
                g.drawString("F", j*GridToScreenRatio + 10, i*GridToScreenRatio + 15);
              }
            }
          }
        }
      }
      
      //Outputs organism populations, turncounts, and legend on the side panel
      g.setFont(new Font("Calibri", Font.PLAIN, 25));
      g.drawString("Stats", maxX-500, 20);
      g.drawString("Legend", maxX-300, 20);
      
      g.setFont(new Font("Calibri", Font.PLAIN, 18));
      g.drawString("Plant Number: " + Integer.toString(counts[0]), maxX - 500, 50);
      g.drawString("Sheep Number: " + Integer.toString(counts[1]), maxX - 500, 70);
      g.drawString("Wolf Number: " + Integer.toString(counts[2]), maxX - 500, 90);
      g.drawString("Turn: " + Integer.toString(counts[3]), maxX - 500, 110);
      
      g.setFont(new Font("Calibri", Font.BOLD, 18));
      g.setColor(Color.GREEN);
      g.drawString("Seedling", maxX - 300, 50);
      g.setColor(new Color(35, 142, 48));
      g.drawString("Mature Plant", maxX - 300, 70);
      g.fillRect(maxX-500, 150, 30, counts[0]*10/world.length);
      g.setColor(new Color(255, 204, 102));
      g.drawString("Dying Plant", maxX - 300, 90);
      g.setColor(Color.WHITE);
      g.drawString("Sheep", maxX - 300, 110);
      g.fillRect(maxX-450, 150, 30, counts[1]*10/world.length);
      g.setColor(Color.GRAY);  
      g.drawString("Wolf", maxX - 300, 130);
      g.fillRect(maxX-400, 150, 30, counts[2]*10/world.length);
      
      //Draws a time graph to illustrate populations of each animal
      
    }
  }//end of GridAreaPanel
  
} //end of DisplayGrid
