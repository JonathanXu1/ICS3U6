 /**
 * Class2
 * Sets up an array of student objects and outputs them
 * Jonathan Xu
 * April 11, 2018
*/

import java.util.Scanner;

public class class2{
  public static void main(String[] args){
    Student[] students = new Student[4];
    Scanner input = new Scanner(System.in);
    String name;
    double mark;
    
    System.out.println("Welcome to teach a cyst!"); //Welcome
    //Input
    for(int i = 1; i < 5; i++){
      System.out.println("Enter student " + i + "'s name:");
      input.next();
      name = input.nextLine();
      students[i-1] = new Student(name);
      for (int j = 1; j < 5; j++){
        System.out.println("Enter mark " + j);
        students[i-1].setMark(j, input.nextDouble());
      }
    }
    
    //Output
    System.out.println("Output:");
    for(int i = 0; i < 4; i++){
      System.out.println(students[i].getName());
      for(int j = 1; j < 5; j++){
        System.out.println("Mark " + j + ": " + students[i].getMark(j));
      }
      System.out.println("Average :" + students[i].getAverage());
      System.out.println();
    }
  }
}
