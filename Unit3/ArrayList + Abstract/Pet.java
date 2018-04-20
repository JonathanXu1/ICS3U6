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
  public String name(){
    return this.name;
  }
  public abstract String speak();
  public abstract String action();
}