/**
 * Plant
 * This class defines all plant objects in the map
 * Jonathan Xu
 * April 24, 2018
*/

class Plant extends Organism{
  //Constructor sets plant's initial health
  Plant(){
    super(10);
  }
  
  /**
   * grow
   * This method increases the health of the plant by 1.
  */
  void grow(){
    if(getHealth() < 20){
      changeHealth(1);
    }
    upAge();
  }
}