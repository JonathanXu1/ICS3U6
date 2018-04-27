abstract class Animal extends Organism{
  private boolean gender;
  private boolean moved;
  
  //abstract int move();
  
  void eat(int health){
    changeHealth(health);
  }
  
  void age(){
    changeHealth(-1);
    setAge(getAge()+1);
  }
  
  void changeMoved(boolean m){
    this.moved = m;
  }
  
  boolean moved(){
    return this.moved;
  }
}