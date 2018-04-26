class Sheep extends Animal{
  Sheep(){
    setHealth(20);
  }
  
  int move(int x, int y, Organism[][] map){
    //Walks to plants
    for(int i = x-1; i < x+2; i++){
      for(int j = y-1; j < y+2; j++){
        if(i >= 0 && i < map.length && j >= 0 && j < map[0].length){ //Not edge
          if(map[i][j] ){
          }
          else{
          }
        }
      }
    }
  }
}