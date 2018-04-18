class SavingsAccount extends BankAccount{
  private double interest = 0.025;
  
  SavingsAccount(double initial){
    super(initial);
  }
  SavingsAccount(double initial, double i){
    super(initial);
    this.interest = i;
  }
  
  void addInterest(){
    super.setBalance(getBalance()*(1+interest));
  }
}