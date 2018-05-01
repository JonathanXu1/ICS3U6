import java.util.Random;

public class Ecosystem {
  //Comment describing these variables
  private int sheepNum, wolfNum;
  private int[] xy = new int[2];
  private int plantNum = 0;
  Organism[][] map = new Organism[25][25];
  int[][] growProbability = new int[25][25];
  Random rand = new Random();
  
  //Don't use single-letter variable names except as for loop counters
  Ecosystem(int s, int w){
    this.sheepNum = s;
    this.wolfNum = w;
    for(int i = 0; i < sheepNum; i++){
      emptyBlock(map);
      map[xy[0]][xy[1]] = new Sheep();
    }
    for(int i = 0; i < wolfNum; i++){
      emptyBlock(map);
      map[xy[0]][xy[1]] = new Wolf();
    }
  }
  
  //Randomly finds an empty block on the map
  public void emptyBlock(Organism[][] map){
    int x, y;
    do{
      x = rand.nextInt(map[0].length);
      y = rand.nextInt(map.length);
    }while(map[x][y] != null);
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
          if(!(map[y][x] instanceof Animal) && !found){
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
    //New plant nodes are grown randomly
    for(int i = 0; i < 3; i ++){
      emptyBlock(map);
      map[xy[0]][xy[1]] = new Plant();
      plantNum ++;
    }
    //Each plant alive gains 1 health
    for(int i = 0; i < map.length; i++){
      for(int j = 0; j < map[0].length; j++){
        if(map[i][j] instanceof Plant){
          ((Plant)map[i][j]).grow();
        }
      }
    }
    //New plants are grown to probability map
    for(int i = 0; i < growProbability.length; i++){
      for(int j = 0; j < growProbability[0].length; j++){
        growProbability[i][j] = 5;
      }
    }
    for(){
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
            sheepNum --;
          }
          else{
            int y = (option-1) / 3 -1;
            int x = (option-1) % 3 -1;   
            
            if(x != 0 || y!= 0){ //If wants to move
              if(map[y+i][x+j] instanceof Plant){ //Moves and eats grass
                plantNum --;
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              }
              else if(map[y+i][x+j] instanceof Sheep){
                emptyBlock(map, j, i, 1);
                if(xy[0] > -1){
                  map[xy[1]][xy[0]] = new Sheep();
                  ((Animal)map[xy[1]][xy[0]]).changeMoved(true);
                  sheepNum ++;
                  map[i][j].changeHealth(-10);
                  map[y+i][x+j].changeHealth(-10);
                }              
              }
              else{
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              }
            } 
          }
        }
        else if (map[i][j] instanceof Wolf && !((Animal)map[i][j]).moved()){
          int option = ((Wolf)map[i][j]).move(j, i, map);
          
          if(map[i][j].getHealth() <= 0){
            map[i][j] = null;
            wolfNum --;
          }
          else{
            int y = (option-1) / 3 -1;
            int x = (option-1) % 3 -1;   
            
            if(x != 0 || y!= 0){ //If wants to move
              if(map[y+i][x+j] instanceof Sheep){ //Moves and eats sheep
                sheepNum --;
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              }
              else if(map[y+i][x+j] instanceof Wolf){
                emptyBlock(map, j, i, 1);
                if(xy[0] > -1){
                  map[xy[1]][xy[0]] = new Wolf();
                  ((Animal)map[xy[1]][xy[0]]).changeMoved(true);
                  wolfNum ++;
                  map[i][j].changeHealth(-10);
                  map[y+i][x+j].changeHealth(-10);
                }              
              }
              else{
                map[y+i][x+j] = map[i][j];
                map[i][j] = null;
              }
            } 
          }
        }
      }
    }
  }
  
  public boolean checkOver(){
    if(sheepNum == 0 || wolfNum == 0 || plantNum == 0){
      return true;
    }
    else{
      return false;
    }
  }
  
  public Organism[][] getMap(){
    return map;
  }
}