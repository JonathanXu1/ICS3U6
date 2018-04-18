/**
 * GeoCoordinate
 * Stores an x and y
*/

public class GeoCoordinate{
  private int x, y;
  private int[] output = new int[2];
  
  GeoCoordinate (int x, int y){
    this.x = x;
    this.y = y;
  }
  
  int[] readXy (){
    output[0] = x;
    output[1] = y;
    return output;
  }
}