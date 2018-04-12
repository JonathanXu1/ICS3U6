class CheckingAccount extends BankAccount{
  double fee = 1;
  double min = 100;
  
  void CheckingAccount(double initial){
    super.balance = initial;
  }
  
  void withdraw(double money){
    super.balance -= money;
    if(super.balance < min){
       super.balance -= 1;
    }
  }
}