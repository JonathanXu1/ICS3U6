
import java.util.Random;

public class Ecosytem {
  private int sheepNum, wolfNum;
  private int[] xy;
  private int plantNum = 0;
  Organism[][] map = new Organism[25][25];
  Random rand = new Random();
  
  Ecosystem(int s, int w){
    this.sheepNum = s;
    this.wolfNum = w;
    for(int i = 0; i < sheepNum; i++){
      emptyBlock();
      map[xy[0]][xy[1]] = new Sheep();
    }
    for(int i = 0; i < wolfNum; i++){
      emptyBlock();
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
    emptyBlock();
    map[xy[0]][xy[1]] = new Plant();
    plantNum ++;
  }
  
  public void moveSheep(){
    
  }
}