class BankAccount {
  private double balance;
  
  BankAccount(){
    balance = 0;
  }
  BankAccount(double initial){
    balance = initial;
  }
  
  void deposit(double money){
    balance += money;
  }
  void withdraw(double money){
    balance -= money;
  }
  void setBalance(double money){
    balance = money;
  }
  double getBalance(){
    return balance;
  }
}