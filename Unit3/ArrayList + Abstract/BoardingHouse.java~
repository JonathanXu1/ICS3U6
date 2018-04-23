/**
 * BoardingHouse
 * Contains an array of Pets
*/

import java.util.ArrayList;

public class BoardingHouse{
  ArrayList<Pet> cage = new ArrayList<Pet>();
  boolean full;
  
  void add(String name, int age, String animal){
    //Adds pet to the first empty index in pets array
    if(animal.equals("cat")){ //If cat
      cage.add(new Cat(name, age));
    }
    else if(animal.equals("dog")){ //If dog
      cage.add(new Dog(name, age));
    }
  }
  
  void remove(String name){
    //Removes a pet
    if(cage.contains()){
      cage.remove();
    }
    else{
      System.out.println("Pet does not exist!");
    }
  }
  
  void speak(String n){
    full = false;
    for(int i = 0; i < 10; i++){
      if(cage[i] != null && cage[i].name().equals(n) && !full){
        System.out.println(cage[i].speak());
        full = true;
      }
    }
    if(!full){
      System.out.println("empty");
    }
  }
  
  void action(String name){
    full = false;
    for(int i = 0; i < 10; i++){
      if(cage[i] != null && cage[i].name().equals(name) && !full){
        System.out.println(cage[i].action());
        full = true;
      }
    }
    if(!full){
      System.out.println("empty");
    }
  }
}