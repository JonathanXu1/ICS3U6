import java.util.Random;

abstract class Animal extends Organism{
  private boolean gender;
  private boolean moved;
  
  abstract int move();
  abstract boolean tryMate();
  
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
  
  void setGender(){
    int num = rand.nextInt(2);
    if(num == 0){ //male
      gender = true;
    }
    else{ //female
      gender = false;
    }
  }
  
  boolean getGender(){
    return gender;
  }
}