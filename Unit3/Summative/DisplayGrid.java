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
  private int[] animalNum;
  
  DisplayGrid(Organism[][] map, int[] num) { 
    this.world = map;
    this.animalNum = num;
    
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
  }
  
  
  public void refresh() { 
    frame.repaint();
  }
  
  
  
  class GridAreaPanel extends JPanel {
    
    public void paintComponent(Graphics g) {        
      //super.repaint();
      
      setDoubleBuffered(true); 
      g.setColor(Color.BLACK);
      
      for(int i = 0; i<world[0].length;i=i+1){ 
        for(int j = 0; j<world.length;j=j+1){ 
          if (world[i][j] instanceof Sheep)    //This block can be changed to match character-color pairs
            g.setColor(Color.WHITE);
          else if (world[i][j]instanceof Plant)
            g.setColor(Color.GREEN);
          else if (world[i][j]instanceof Wolf)
            g.setColor(Color.GRAY);
          else 
            g.setColor(new Color(156, 93, 82));
          
          g.fillRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
          g.setColor(Color.BLACK);
          g.drawRect(j*GridToScreenRatio, i*GridToScreenRatio, GridToScreenRatio, GridToScreenRatio);
          if(world[i][j] != null){
            g.drawString(Integer.toString(world[i][j].getHealth()), j*GridToScreenRatio, i*GridToScreenRatio + 15);
          }
          if(world[i][j] instanceof Animal){
            if( ((Animal)world[i][j]).getGender() ){
              g.drawString("M", j*GridToScreenRatio + 15, i*GridToScreenRatio + 15);
            }
            else{
              g.drawString("F", j*GridToScreenRatio + 15, i*GridToScreenRatio + 15);
            }
          }
        }
      }
      
      g.drawString("Plant Number: " + Integer.toString(animalNum[0]), maxX - 200, 20 );
      g.drawString("Sheep Number: " + Integer.toString(animalNum[1]), maxX - 200, 40 );
      g.drawString("Wolf Number: " + Integer.toString(animalNum[2]), maxX - 200, 60 );
    }
  }//end of GridAreaPanel
  
} //end of DisplayGrid
