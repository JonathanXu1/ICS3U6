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
    full = false;
    for(int i = 0; i < cage.size(); i++){
      if(cage.get(i).getName().equals(name)){
        cage.remove(i);
        full = true;
      }
    }
    if(!full){
      System.out.println("Pet does not exist!");
    }
  }
  
  void speak(String name){
    full = false;
    for(int i = 0; i < cage.size(); i++){
      if(cage.get(i).getName().equals(name) && !full){
        System.out.println(cage.get(i).speak());
        full = true;
      }
    }
    if(!full){
      System.out.println("empty");
    }
  }
  
  void action(String name){
    full = false;
    for(int i = 0; i < cage.size(); i++){
      if(cage.get(i).getName().equals(name) && !full){
        System.out.println(cage.get(i).action());
        full = true;
      }
    }
    if(!full){
      System.out.println("empty");
    }
  }
}