class Plant extends Organism{
  Plant(){
    super(10);
  }
  
  void grow(){
    if(getHealth() < 20){
      changeHealth(1);
    }
    setAge(getAge()+1);
  }
}