/**
 * Cat
 * Cat Object
*/

public class Cat extends Pet{
  private String speak = "meow";
  private String action = "scratch sofa";
  //Constructor
  Cat(String name, int age){
    super(name, age);
  }
  
  public String speak(){
    return this.speak;
  }
  public String action(){
    return this.action;
  }
}