/**
 * GeoTriangle
 * Contains three lines and outputs the area
 * Jonathan Xu
 * April 18, 2018
*/

public class GeoTriangle{
  private double halfP, area;
  double a, b, c;
  
  GeoTriangle(GeoLine ln1, GeoLine ln2, GeoLine ln3){
    this.a = ln1.lineLength();
    this.b = ln2.lineLength();
    this.c = ln3.lineLength();
    halfP = (a + b + c)/2;
    area = Math.sqrt(halfP*(halfP-a)*(halfP-b)*(halfP-c));
  }
  
  double getArea (){
    return area;
  }
}