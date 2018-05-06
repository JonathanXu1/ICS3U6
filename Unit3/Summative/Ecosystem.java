/** 
* Ecosystem  
* Simulates all movements and interactions of an array of organisms
* Jonathan Xu
* April 24, 2018
*/ 

import java.util.Random;

public class Ecosystem {
  //Comment describing these variables
  private int[] xy = new int[2];
  private Organism[][] map = new Organism[25][25];
  private int[][] growProbability = new int[25][25];
  Random rand = new Random();
  private static int [] animals = new int[3];
  
  //Don't use single-letter variable names except as for loop counters
  Ecosystem(int s, int w){
    for(int i = 0; i < s; i++){
      emptyBlock(map);
      map[xy[1]][xy[0]] = new Sheep();
    }
    for(int i = 0; i < w; i++){
      emptyBlock(map);
      map[xy[1]][xy[0]] = new Wolf();
    }
  }
  
  //Randomly finds an empty block on the map
  public void emptyBlock(Organism[][] world){
    int x, y;
    do{
      x = rand.nextInt(world[0].length);
      y = rand.nextInt(world.length);
    }while(world[y][x] != null);
    xy[0] = x;
    xy[1] = y;
  }
  
  //Finds a random empty block in the map, with set radius from center
  public void emptyBlock(Organism[][] map, int originX, int originY, int radius){
    int x, y;
    boolean found = false;
    for(int i = - radius; i <= radius; i ++){
      for(int j = -radius; j <= radius; j ++){
        x = originX + i;
        y = originY + i;
        if(x >= 0 && x < map[0].length && y >=0 && y < map.length){
          if(!(map[y][x] instanceof Animal) && (!found)){
            found = true;
            xy[0] = x;
            xy[1] = y;
          }
        }
      }
    }
    if(!found){
      xy[0] = -1;
    }
  }
  
  public void growGrass(){
    emptyBlock(map);
    map[xy[1]][xy[0]] = new Plant();
    //Each plant alive gains 1 health, unless it's over 20 turs old
    for(int i = 0; i < map.length; i++){
      for(int j = 0; j < map[0].length; j++){
        if(map[i][j] instanceof Plant){
          if(map[i][j].getAge() > 20){
            map[i][j].changeHealth(-1);
          } else{
            ((Plant)map[i][j]).grow();
          }
          if(map[i][j].getHealth() <= 0){
            map[i][j] = null;
          }
        }
      }
    }
    //Ambient probability is set up
    for(int i = 0; i < growProbability.length; i++){
      for(int j = 0; j < growProbability[0].length; j++){
        growProbability[i][j] = 1;
      }
    }
    //If the map contains a plant, increase the growprobability of surrounding boxes by 100
    for(int i = 0; i < growProbability.length; i++){
      for(int j = 0; j < growProbability[0].length; j++){
        if((map[i][j] instanceof Plant) && (map[i][j].getHealth() == 20)){
          for(int k = -1; k < 2; k++){
            for(int l = -1; l < 2; l++){
              if((i+k >= 0) && (i+k < map.length) && (j+l >= 0) && (j+l < map[0].length)){ //If not off edge of map
                growProbability[i+k][j+l] += 150;
              }
            }
          }
        }
      }
    }
    //Grows new plants according to the grow probability array
    for(int i = 0; i < growProbability.length; i++){
      for(int j = 0; j < growProbability[0].length; j++){
        int chance = rand.nextInt(1000);
        if((chance < growProbability[i][j]) && (map[i][j] == null)){
          map[i][j] = new Plant();
        }
      }
    }
  }
  
  public void moveAnimals(){
    for(int i = 0; i < map.length; i++){ //y
      for(int j = 0; j < map[0].length; j++){
        if(map[i][j] instanceof Animal){
          ((Animal)map[i][j]).changeMoved(false); 
        }
      }
    }
    for(int i = 0; i < map.length; i++){ //y
      for(int j = 0; j < map[0].length; j++){
        if (map[i][j] instanceof Sheep && !((Animal)map[i][j]).moved()){
          int option = ((Sheep)map[i][j]).move(j, i, map);
          
          if(map[i][j].getHealth() <= 0){
            map[i][j] = null;
          } else{
            int y = (option-1) / 3 -1;
            int x = (option-1) % 3 -1;   
            
            if(x != 0 || y!= 0){ //If wants to move
              if(map[y+i][x+j] instanceof Plant){ //Moves and eats grass
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              } else if(map[y+i][x+j] instanceof Sheep){
                emptyBlock(map, j, i, 1);
                if(xy[0] > -1){
                  map[xy[1]][xy[0]] = new Sheep();
                  ((Animal)map[xy[1]][xy[0]]).changeMoved(true);
                  map[i][j].changeHealth(-10);
                  map[y+i][x+j].changeHealth(-10);
                }              
              } else{
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              }
            } 
          }
        } else if (map[i][j] instanceof Wolf && !((Animal)map[i][j]).moved()){
          int option = ((Wolf)map[i][j]).move(j, i, map);
          
          if(map[i][j].getHealth() <= 0){
            map[i][j] = null;
          } else{
            int y = (option-1) / 3 -1;
            int x = (option-1) % 3 -1;   
            
            if(x != 0 || y!= 0){ //If wants to move
              if(map[y+i][x+j] instanceof Sheep){ //Moves and eats sheep
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              } else if(map[y+i][x+j] instanceof Wolf){
                emptyBlock(map, j, i, 1);
                if(xy[0] > -1){
                  map[xy[1]][xy[0]] = new Wolf();
                  ((Animal)map[xy[1]][xy[0]]).changeMoved(true);
                  map[i][j].changeHealth(-10);
                  map[y+i][x+j].changeHealth(-10);
                }              
              } else if(map[y+i][x+j] instanceof Plant){ //Tramples grass
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              } else{ //Moves on blank block
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              }
            } 
          }
        } 
      }
    }
  }
  
  public int[] updateCount(){
    animals[0] = 0;
    animals[1] = 0;
    animals[2] = 0;
    for(int i = 0; i < map.length; i ++){
      for(int j = 0; j < map[0].length; j++){
        if(map[i][j] instanceof Plant){
          animals[0] ++;
        } else if(map[i][j] instanceof Animal){
          if( ((Animal)map[i][j]) instanceof Sheep ){
            animals[1] ++;
          } else if( ((Animal)map[i][j]) instanceof Wolf ){
            animals[2] ++;
          }
        }
      }
    }
    return animals;
  }
  
  public boolean checkOver(){
    return animals[0] <= 0 || animals[1] <= 0 || animals[2] <= 0;
  }
  
  public Organism[][] getMap(){
    return map;
  }
}