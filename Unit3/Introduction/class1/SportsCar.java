class SportsCar {
  String manufacturer;
  String model;
  double fuelTankSize;
  double topSpeed;
  double cost;
  double mpg;
  
  SportsCar(String maker, String m, double tank, double speed, double c, double efficiency){
    this.manufacturer = maker;
    this.model = m;
    this.fuelTankSize = tank;
    this.topSpeed = speed;
    this.cost = c;
    this.mpg = efficiency;
  }
  
  public double range(){
    return mpg*fuelTankSize;
  }
}