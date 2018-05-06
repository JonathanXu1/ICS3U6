/**
 * Organism
 * This class initializes all organisms (!null objects) in the map.
 * Jonathan Xu
 * April 23, 2018
*/

abstract class Organism{
  private int health;
  private int age = 0;
  
  //Constructor sets the intial health of the organism
  Organism(int init){
    this.health = init;
  }
  
  /**
   * changeHealth
   * @param An integer which is the health change.
  */
  void changeHealth(int h){
    this.health += h;
  }
  
  /**
   * getHealth
   * @return and integer representing the current health of the organism.
  */
  int getHealth(){
    return this.health;
  }
  
  /**
   * getAge
   * @return an int for the age of the organism.
  */
  int getAge(){
    return age;
  }
  
  /**
   * setAge
   * Increases current age by 1.
  */
  void upAge(){
    this.age ++;
  }
}