/**
 * GeoLine
 * Returns the length of a line
*/

public class GeoLine{
  private double x1, y1, x2, y2, len;
  private int[] coordinate1, coordinate2 = new int[2];
  
  GeoLine(GeoCoordinate xy1, GeoCoordinate xy2){
    coordinate1 = xy1.readXy();
    coordinate2 = xy2.readXy();
    this.x1 = coordinate1[0];
    this.y1 = coordinate1[1];
    this.x2 = coordinate2[0];
    this.y2 = coordinate2[1];
    len = Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2));
  }
  
  double lineLength (){
    return len;
  }
  
}