/*
CSE 17
Delaney McCaffrey
mdm219
Program #2    DEADLINE: October 16, 2018
Program: Simple Bank
*/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/** The Bank class aggregates BankAccount and contains the main method */
public class Bank {

  //fields
  private String name;
  private BankAccount[] accounts;
  private int totalAccounts;
  public static int MAX_ACCOUNTS = 20;
  
  /** Bank constructor */
  public Bank(String name) {
    this.name = name;
    totalAccounts = 0;
    accounts = new BankAccount[MAX_ACCOUNTS];
  }
  
  /** Get method for bank name */
  public String getName() {
    return name;
  }
  
  /** Adds a new bank account to the accounts array */
  public void addAccount(BankAccount newAcct) {
    accounts[totalAccounts] = newAcct;
    totalAccounts++;
  }
  
  /** Prints the bank summary including each bank account  */
  public void printBankSummary() { 
    System.out.println("Bank Name: "+this.getName());
    for(int i=0; i<totalAccounts; i++){
      accounts[i].printAccountInfo();   //uses polymorphism to call correct method, dynamic binding 
    }
    System.out.println();
  }
  
  /** Adds interest to all SavingsAccounts */
  public void accrueInterestToSavingsAccounts() {
    SavingsAccount s;
    for(int i=0; i<totalAccounts; i++){
      if(accounts[i] instanceof SavingsAccount) { //use instanceof to determine which BankAccounts are SavingsAccounts
        s = (SavingsAccount)accounts[i];
        s.accrueInterest();
      }
    }
  }
  
  /** Subtracts the monthly fee from every CheckingAccount */
  public void applyFeesToCheckingAccounts() {
    CheckingAccount c;
    for(int i=0; i<totalAccounts; i++){
      if(accounts[i] instanceof CheckingAccount) { //use instanceof to determine which BankAccounts are CheckingAccounts
        c = (CheckingAccount)accounts[i];
        c.applyFee();
      }
    }
  }
  
  /** Uses scanner to load info from file, constructs BankAccounts and puts them into accounts array 
    * Note: If file not formatted correctly error will occur*/
  public void loadAccountsFromFile(File acctFile) throws FileNotFoundException {
    Scanner input = new Scanner(acctFile); //new scanner
    String reader;
    int num;
    String accName;
    double bal;
    double other;
    while(input.hasNext()) {  
      input.useDelimiter("\\t|[\\n\\r\\f]+"); //use delimiter to specify how to read from file
      reader = input.next();
      if (reader.equals("C")) { //constructs CheckingAccount
        num = input.nextInt();
        accName = input.next();
        bal = input.nextDouble();
        other = input.nextDouble();
        accounts[totalAccounts] = new CheckingAccount(num, accName, bal, other);
        totalAccounts++;
      }
      else if (reader.equals("S")) { //contructs SavingsAccount
        num = input.nextInt();
        accName = input.next();
        bal = input.nextDouble();
        other = input.nextDouble();
        accounts[totalAccounts] = new SavingsAccount(num, accName, bal, other);
        totalAccounts++;
      }
    }
  }
 
  /** The main method creates a new bank, prints bank summary, 
    * accrues interest to savings accounts and applies fees to checking accounts,
    * then prints the bank summary again */
  public static void main(String[] args) throws FileNotFoundException {
   
    if(args.length !=1) {
      System.out.println("Usage: java Bank filename"); //tell user how to interact with code
      System.exit(0);
    }
    
    Bank myBank = new Bank("Java S&L"); //construct new bank
  
    String filename = args[0];
    File file = new File(filename);  //prepares for file to be read
    
    myBank.loadAccountsFromFile(file);
    myBank.printBankSummary();
    myBank.accrueInterestToSavingsAccounts();
    myBank.applyFeesToCheckingAccounts();
    myBank.printBankSummary();

  }
  
}