/**
 * Pet
 * A pet object
*/

abstract public class Pet{
  private String name, s, a;
  private int age;
  //Constructor
  Pet(String name, int age){
    this.name = name;
    this.age = age;
    this.s = s;
    this.a = a;
  }
  
  //Methods
  public String getName(){
    return this.name;
  }
  public int getAge(){
    return this.age;
  }
  public abstract String speak();
  public abstract String action();
}