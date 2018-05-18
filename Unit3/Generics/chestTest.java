class ChestTest{
  public static void main(String[] args){
    Chest good = new Chest<Gold>();
    Chest okay = new Chest<Key>();
    Chest bad = new Chest<Snake>();
    
    System.out.println(good.interact().getValue());
    System.out.println(okay.interact());
    System.out.println(bad.interact());
  }
}