class Wolf extends Animal{
  Wolf(){
    setHealth(20);
    setGender();
  }
  
  int move(){
    age();
    return 1;
  }
  
  boolean tryMate(Wolf other){
    if(other.getAge() >= 10 && other.getHealth() > 20 && (other.getGender() != getGender()) ){
      return true;
    }
    else{
      return false;
    }
  }
}