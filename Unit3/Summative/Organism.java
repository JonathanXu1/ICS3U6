abstract class Organism{
  private int health;
  
  Organism(){
    this.health = 20;
  }
  
  void changeHealth(int h){
    this.health += h;
  }
  
  int getHealth(){
    return this.health;
  }
}