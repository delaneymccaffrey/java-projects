/*
CSE 17
Delaney McCaffrey
mdm219
Program #2    DEADLINE: October 16, 2018
Program: Simple Bank
*/

public class CheckingAccount extends BankAccount {
  
  /** The CheckingAccount class is a subclass of BankAccount */
  
  //field
  private double monthlyFee;
  
  /** CheckingAccount constructor 
    * Some fields are inherited from the superclass BankAccount */
  public CheckingAccount(int accountNum, String customerName, double balance, double monthlyFee) {
    super(accountNum, customerName, balance);
    this.monthlyFee = monthlyFee;
  }
  
  /** Get method for the monthly fee */
  public double getMonthlyFee() {
     return monthlyFee;
  }
  
  /** Set method for the monthly fee */
  public void setMonthlyFee(double monthlyFee) {
    this.monthlyFee = monthlyFee;
  }

  /** This method subtracts the monthly fee from the SavingsAccount that it is called upon */
  public void applyFee() {
    balance -= monthlyFee;
  }

  /** Prints the account info from the SavingsAccount */
  public void printAccountInfo() {  
    int num = this.getAccountNum();
    String name = this.getCustomerName();
    double bal = this.getBalance();
    double fee = this.getMonthlyFee();
    System.out.printf("%5d %-20s%8.2f\tMonthly fee: $%-2.2f\n", num, name, bal, fee); //formated printing
  }
  
}