class Chest<T>{
  T item;
  Chest(){
    item = (T) new Object();
  }
  T interact(){
    return item;
  }
}