/**
 * Wolf
 * Defines all the paramaters of a wolf
 * Jonathan Xu
 * April 24, 2018
*/

import java.util.Random;

class Wolf extends Animal{
  Wolf(){
    super(30);
  }
  
  /**
   * move
   * This method covers the decision process of a wolf. It prioritizes mating over eating sheep over fighting other wolves.
   * @param Integers representing the coordinates of the animal, and an Organism array representing the map.
   * @return An integer, a number that correlates to a 3 by 3 grid of move choices (similar to a numpad).
   */
  int move(int x, int y, Organism[][] map){
    age();
    int option = 0;
    Random rand = new Random();
    boolean foundMate = false;
    boolean foundSheep = false;
    
    //Seeks mate when mature
    if(getAge() >= 10 && getHealth() > 20){ 
      for(int i = -1; i < 2; i++){
        for(int j = -1; j < 2; j++){
          if(y+i >= 0 && y+i < map.length && x+j >= 0 && x+j < map[0].length){ //Not edge
            if(map[y+i][x+j] instanceof Wolf && !foundMate ){
              foundMate = tryMate( (Wolf)map[y+i][x+j] );
              if(foundMate){
                option = (i+1)*3 + j + 2;
              }
            }
          }
        }
      }
    }
    
    //Walks to sheep
    if(option == 0 && getHealth() < 25){
      for(int i = -1; i < 2; i++){
        for(int j = -1; j < 2; j++){
          if(y+i >= 0 && y+i < map.length && x+j >= 0 && x+j < map[0].length){ //Not edge
            if(map[y+i][x+j] instanceof Sheep && !foundSheep){
              foundSheep = true;
              eat(map[y+i][x+j].getHealth());
              option = (i+1)*3 + j + 2;
            }
          }
        }
      }
    }
    
    //give wolves fighting ability later, figure out comparables
    //Randomly moves to a spot
    if(option == 0){
      int nextx, nexty;
      do{
        do{
          //The program randomly generates a random set of coordinates and determines if it's off the map or another aimal
          nextx = rand.nextInt(3) -1;
          nexty = rand.nextInt(3) -1;
        } while(nexty+y < 0 || nexty+y >= map.length || nextx+x < 0 || nextx+x >= map[0].length);
      } while( !(map[nexty+y][nextx+x] instanceof Wolf && map[nexty+y][nextx+x].getGender() && map[nexty+y][nextx+x].getGender() == getGender()) && (nextx != 0 || nexty != 0) ); //Comparable interface somehow
      option = (nexty+1)*3 + nextx + 2;
    }

    changeMoved(true);
    return option;
  }
}