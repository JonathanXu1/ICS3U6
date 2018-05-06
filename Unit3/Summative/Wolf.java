import java.util.Random;

class Wolf extends Animal{
  Wolf(){
    super(25);
  }
  
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
    //Randomly moves to a spot
    if(option == 0){
      int nextx, nexty;
      do{
        do{
          //The program randomly generates a random set of coordinates and determines if it's off the map or another aimal
          nextx = rand.nextInt(3) -1;
          nexty = rand.nextInt(3) -1;
        }while(nexty+y < 0 || nexty+y >= map.length || nextx+x < 0 || nextx+x >= map[0].length);
      }while(map[nexty+y][nextx+x] instanceof Animal && (nextx != 0 || nexty != 0) ); //problem here
      option = (nexty+1)*3 + nextx + 2;
    }

    changeMoved(true);
    return option;
  }
}