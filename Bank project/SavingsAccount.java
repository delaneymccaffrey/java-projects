/*
CSE 17
Delaney McCaffrey
mdm219
Program #2    DEADLINE: October 16, 2018
Program: Simple Bank
*/ 

public class SavingsAccount extends BankAccount {
  
  /** The SavingsAccount class is a subclass of BankAccount */
  
  //field
  private double interestRate;
  
  /** SavingsAccount constructor
    * Some fields are inherited from the superclass BankAccount */
  public SavingsAccount(int accountNum, String customerName, double balance, double interestRate) {
    super(accountNum, customerName, balance);
    this.interestRate = interestRate;
  }
  
  /** SavingsAccount constructor
    * Some fields are inherited from the superclass BankAccount */
  public SavingsAccount(int accountNum, String customerName, double interestRate) {
    this(accountNum, customerName, 0.0, interestRate);
  }
  
  /** Get method for interest rate */ 
  public double getInterestRate() {
    return interestRate;
  }
  
  /** This method adds the interest to the balance */
  public void accrueInterest() {
    balance += (interestRate * balance);
  }
  
  /** Prints the account info of the SavingsAccount */
  public void printAccountInfo() {  
    int num = this.getAccountNum();
    String name = this.getCustomerName();
    double bal = this.getBalance();
    double rate = this.getInterestRate();
    rate *= 100; 
    System.out.printf("%5d %-20s%8.2f\tInterest rate: %-2.1f%%\n", num, name, bal, rate); //formated printing
  }
    
}