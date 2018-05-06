/** 
* Animal  
* This class defines all sheep and wolf objects used in the program
* Jonathan Xu
* April 24, 2018
*/ 

import java.util.Random;

abstract class Animal extends Organism{
  private boolean gender;
  private boolean moved;
  Random rand = new Random();
  
  //Constructor sets the initial health and gender of the animal.
  Animal (int h){
    super(h);
    int num = rand.nextInt(2);
    this.gender = num == 0;
  }
  
  //give animals limited range later
  
  /** 
   * move
   * This method determines where an animal should move.
   * @param An integer representing y, and integer represinting x, and an Organism array representing the map.
   * @return An integer, numbered corresponding to a 3 by 3 grid, similar to a phone number pad.
   */  
  abstract int move(int i, int j, Organism[][] o);
  
  /** 
   * eat
   * This method applies the health count of the eaten organism to the eating organism
   * @param An integer representing the health points(calories)
   */   
  void eat(int health){
    changeHealth(health);
  }
  
  /** 
   * age  
   * This method increases the age of all animals by once while reducing their health by 1
   */ 
  void age(){
    changeHealth(-1);
    setAge(getAge()+1);
  }
  
  /** 
   * changeMoved  
   * This method keeps track of whether or not an object has been moved in the ecosystem.
   * @param A boolean, true if animal has been moved, false otherwise.
   */ 
  void changeMoved(boolean m){
    this.moved = m;
  }
  
  /** 
   * moved  
   * @return A boolean, true if animal has been moved, false otherwise.
   */ 
  boolean moved(){
    return this.moved;
  }
  
  /** 
   * getGender  
   * @return A boolean, true if animal is male, false if it's female.
   */ 
  boolean getGender(){
    return gender;
  }
  
    /** 
   * tryMate  
   * This method determines whether or not an animal can mate with another.
   * @param An Animal object representing the other animal.
   * @return A boolean, true if mating is possible, false otherwise.
   */
  boolean tryMate(Animal other){
    if(other.getAge() >= 10 && other.getHealth() > 20 && (other.getGender() != getGender()) ){
      return true;
    } else{
      return false;
    }
  }
}