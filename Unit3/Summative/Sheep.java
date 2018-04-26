import java.util.Random;

class Sheep extends Animal{
  Sheep(){
    setHealth(20);
  }
  
  int move(int x, int y, Organism[][] map){
    age();
    //Walks to plants
    boolean foundPlant = false;
    int option = 0, custi, custj;
    Random rand = new Random();
    
    for(int i = -1; i < 2; i++){
      for(int j = -1; j < 2; j++){
        if(y+i >= 0 && y+i < map.length && x+j >= 0 && x+j < map[0].length){ //Not edge
          if(map[y+i][x+j] instanceof Plant && !foundPlant){
            foundPlant = true;
            eat(map[y+1][x+1].getHealth());
            option = (i+1)*3 + j + 2;
          }
        }
      }
    }
    //Randomly moves to a spot
    if(!foundPlant){
      do{
        do{
          custi = rand.nextInt(3) -1;
          custj = rand.nextInt(3) -1;
        }while(custi+y < 0 || custi+y >= map.length || custj+x < 0 || custj+x >= map[0].length);
      }while(map[custi+y][custj+x] instanceof Wolf || (map[custi+y][custj+x] instanceof Sheep && x == 0 && y == 0));
      option = (custi+1)*3 + custj + 2;
    }

    changeMoved(true);
    return option;
  }
}