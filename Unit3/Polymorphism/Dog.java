/**
 * Dog
 * A dog object
*/

public class Dog extends Pet{
  private String speak = "woof";
  private String action = "wag tail";
  //Constructor
  // Is this supposed to change the speak and action vars in pet,
  // or create and overide the speak and action methods in pet?
  // Also do methods return to the main or can they simple output to the system
  Dog(String name, int age){
    super(name, age, "woof", "wag tail");
  }
}