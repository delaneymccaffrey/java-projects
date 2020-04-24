/*
CSE 17
Delaney McCaffrey
mdm219
Program #2    DEADLINE: October 16, 2018
Program: Simple Bank
*/

public class BankAccount {
  
   /** The BankAccount class is aggregated by the Bank class */
  
  //fields
  protected int accountNum;
  protected String customerName;
  protected double balance;
  
  /** BankAccount constructor */
  public BankAccount(int accountNum, String customerName, double balance) {
    this.accountNum = accountNum;  //variable hiding
    this.customerName = customerName;
    this.balance = balance;
  }

  /** BankAccount constructor */
  public BankAccount(int accountNum, String customerName) {
    this(accountNum, customerName, 0.0);
  }
  
  /** Get method for account number */
  public int getAccountNum() {
    return accountNum;
  }
  
  /** Get method for customer name */
  public String getCustomerName() {
    return customerName;
  }
  
  /** Get method for balance */
  public double getBalance() {
    return balance;
  }
  
  /** This method adds a deposit amount to the BankAcccount it is called upon */
  public void makeDeposit(double depositAmt) {
    balance += depositAmt;
  }
    
  /** This method prints the account info of the BankAccount */
  public void printAccountInfo() {  
    int num = this.getAccountNum();
    String name = this.getCustomerName();
    double bal = this.getBalance();
    System.out.println(num+" "+name+" "+bal);
  }

}

