/**
 * Wolf
 * Defines all the paramaters of a wolf
 * Jonathan Xu
 * April 24, 2018
*/

import java.util.Random;

class Wolf extends Animal implements Comparable<Wolf> {
  Wolf(){
    super(20);
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
    boolean foughtWolf = false;
    
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
    if(option == 0 && getHealth() < 80){
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
    
    //Randomly moves to a spot
    if(option == 0){
      int nextx, nexty;
      do{
        do{
          //The program randomly generates a random set of coordinates and determines if it's off the map or another aimal
          nextx = rand.nextInt(3) -1;
          nexty = rand.nextInt(3) -1;
        } while(nexty+y < 0 || nexty+y >= map.length || nextx+x < 0 || nextx+x >= map[0].length);
        //Checks if the random spot contains a male wolf and if it's weaker than the current wolf
        if( (map[nexty+y][nextx+x] instanceof Wolf)){
          if( (((Animal)map[nexty+y][nextx+x]).getGender())  && (getGender()) && (compareTo((Wolf)map[nexty+y][nextx+x]) == 1) ){
            foughtWolf = true;
          }
        }
        //Loop continues if there is a non-self wolf object in the target area or if both wolves are male and the other is weaker
      } while((map[nexty+y][nextx+x] instanceof Wolf) && (nextx != 0 || nexty != 0) && (!foughtWolf));
      option = (nexty+1)*3 + nextx + 2;
    }

    changeMoved(true);
    return option;
  }
  
  /**
   * compareTo
   * This method compares the health values of the wolf to another wolf.
   * @param A Wolf object reresenting another wolf.
   * @return An integer, 1 if the current wolf is stronger than the other wolf,
   * 0 if the current wolf is weaker than the other wolf, 0 otherwise
  */
  public int compareTo(Wolf other){
    if(this.getHealth() > other.getHealth()){
      return 1;
    }
    else if(this.getHealth() < other.getHealth()){
      return -1;
    }
    else{
      return 0;
    }
  }
}