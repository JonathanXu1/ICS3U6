
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
    x = rand.nextInt(24);
    y = rand.nextInt(24);
    while(map[x][y] != null){
      x = rand.nextInt(24);
      y = rand.nextInt(24);
    }
    xy[0] = x;
    xy[1] = y;
  }
  
  public void growGrass(){
    emptyBlock(map);
    map[xy[0]][xy[1]] = new Plant();
    plantNum ++;
  }
  
  public void moveAnimals(){
    for(int i = 0; i < map.length; i++){ //y
      for(int j = 0; j < map[0].length; j++){
        if(map[i][j] instanceof Sheep){
        }
        if(map[i][j] instanceof Wolf){
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