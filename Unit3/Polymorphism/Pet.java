/**
 * Pet
 * A pet object
*/

public class Pet{
  private String name, s, a;
  private int age;
  //Constructor
  Pet(String name, int age, String s, String a){
    this.name = name;
    this.age = age;
    this.s = s;
    this.a = a;
  }
  
  //Methods
  String name(){
    return this.name;
  }
  String speak(){
    return this.s;
  }
  String action(){
    return this.a;
  }
}