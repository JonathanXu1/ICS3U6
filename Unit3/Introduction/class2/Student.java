 class Student {
  String name;
  double[] mark = new double[4];
  static String school = "Richmond Hill High School";
  double average = 0.00;
  
  Student(String n){
    name = n;
  }
  
  Student(String n, double mark1, double mark2, double mark3, double mark4){
    name = n;
    mark[0] = mark1;
    mark[1] = mark2;
    mark[2] = mark3;
    mark[3] = mark4;
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String n){
    name = n;
  }
  
  public String getSchool(){
    return school;
  }
  
  public double getMark(int period){
    return mark[period-1];
  }
  
  public void setMark(int period, double m){
    mark[period-1] = m;
  }
  
  public double getAverage(){
    for(int i = 0; i < 4; i++){
      average += mark[i];
    }
    return average/4;
  }
}