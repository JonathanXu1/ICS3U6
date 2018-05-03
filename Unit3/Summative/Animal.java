import java.util.Random;

abstract class Animal extends Organism{
  private boolean gender;
  private boolean moved;
  Random rand = new Random();
  
  abstract int move(int i, int j, Organism[][] o);
  
  Animal (int h){
    super(h);
    int num = rand.nextInt(2);
    if(num == 0){ //male
      this.gender = true;
    }
    else{ //female
      this.gender = false;
    }
  }
  
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
    
  boolean getGender(){
    return gender;
  }
  
  boolean tryMate(Animal other){
    if(other.getAge() >= 10 && other.getHealth() > 20 && (other.getGender() != getGender()) ){
      return true;
    }
    else{
      return false;
    }
  }
}