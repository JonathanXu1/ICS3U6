/**
 * GeoTriangle
 * Contains three lines and outputs the area
 * Jonathan Xu
 * April 18, 2018
*/

public class GeoTriangle{
  private double halfP, area;
  
  GeoTriangle(double a, double b, double c){
    halfP = (a + b + c)/2;
    area = Math.sqrt(halfP*(halfP-a)*(halfP-b)*(halfP-c));
  }
  
  double getArea (){
    return area;
  }
}