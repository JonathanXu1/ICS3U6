
import java.util.Random;

public class Ecosystem {
  private int sheepNum, wolfNum;
  private int[] xy = new int[2];
  private int plantNum = 0;
  Organism[][] map = new Organism[25][25];
  Random rand = new Random();
  
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
  
  public void emptyBlock(Organism[][] map){
    int x, y;
    do{
      x = rand.nextInt(map[0].length);
      y = rand.nextInt(map.length);
    }while(map[x][y] != null);
    xy[0] = x;
    xy[1] = y;
  }
  
  public void emptyBlock(Organism[][] map; int radius){
    int x, y;
    do{
      x = rand.nextInt(map[2*radius+1].length-radius);
      y = rand.nextInt(map.length);
    }while(map[x][y] != null);
  }
  
  public void growGrass(){
    emptyBlock(map);
    map[xy[0]][xy[1]] = new Plant();
    plantNum ++;
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
        if(map[i][j] instanceof Plant){
          ((Plant)map[i][j]).grow();
        }
        else if (map[i][j] instanceof Sheep && !((Animal)map[i][j]).moved()){
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
                sheepNum ++;
                //emptyBlock();
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