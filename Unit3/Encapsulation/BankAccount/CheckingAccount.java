class CheckingAccount extends BankAccount{
  private double fee = 1;
  private double min = 100;
  
  CheckingAccount(double initial){
    super(initial);
  }
  
  void withdraw(double money){
    super.withdraw(money);
    if(super.getBalance() < min){
       super.withdraw(1);
    }
  }
}