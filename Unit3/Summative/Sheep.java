import java.util.Random;

class Sheep extends Animal{
  Sheep(){
    setHealth(20);
    setGender();
  }
  
  int move(int x, int y, Organism[][] map){
    age();
    int option = 0;
    Random rand = new Random();
    boolean foundMate = false;
    boolean foundPlant = false;
    
    //Seeks mate when mature
    if(getAge() >= 10 && getHealth() > 20){ 
      for(int i = -1; i < 2; i++){
        for(int j = -1; j < 2; j++){
          if(y+i >= 0 && y+i < map.length && x+j >= 0 && x+j < map[0].length){ //Not edge
            if(map[y+i][x+j] instanceof Sheep && !foundMate ){
              foundMate = tryMate( (Sheep)map[y+i][x+j] );
              if(foundMate){
                option = (i+1)*3 + j + 2;
              }
            }
          }
        }
      }
    }
    
    //Walks to plants
    if(option == 0){
      for(int i = -1; i < 2; i++){
        for(int j = -1; j < 2; j++){
          if(y+i >= 0 && y+i < map.length && x+j >= 0 && x+j < map[0].length){ //Not edge
            if(map[y+i][x+j] instanceof Plant && !foundPlant){
              foundPlant = true;
              eat(map[y+i][x+j].getHealth());
              option = (i+1)*3 + j + 2;
            }
          }
        }
      }
    }
    //Randomly moves to a spot
    if(option == 0){
      int nexti, nextj;
      do{
        do{
          nexti = rand.nextInt(3) -1;
          nextj = rand.nextInt(3) -1;
        }while(nexti+y < 0 || nexti+y >= map.length || nextj+x < 0 || nextj+x >= map[0].length);
      }while(map[nexti+y][nextj+x] instanceof Wolf || (map[nexti+y][nextj+x] instanceof Sheep && x == 0 && y == 0));
      option = (nexti+1)*3 + nextj + 2;
    }

    changeMoved(true);
    return option;
  }
  
  boolean tryMate(Sheep other){
    if(other.getAge() >= 10 && other.getHealth() > 20 && (other.getGender() != getGender()) ){
      changeHealth(-10);
      other.changeHealth(-10);
      return true;
    }
    else{
      return false;
    }
  }
}