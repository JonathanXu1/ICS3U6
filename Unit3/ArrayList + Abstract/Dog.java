/**
 * Dog
 * A dog object
*/

public class Dog extends Pet{
  private String speak = "woof";
  private String action = "wag tail";
  //Constructortem
  Dog(String name, int age){
    super(name, age);
  }
  
  public String speak(){
    return this.speak;
  }
  public String action(){
    return this.action;
  }
}