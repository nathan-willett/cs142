// CS& 141, Winter 2024

// Blueprint for creating objects of type BankAccount
// which represents an person's account at a bank. It keeps 
// track of the account owner and balance.
// Thanks to Allison Obourn for parts of this program

package week8;

public class BankAccount {
   private String owner;
   private double balance;

   // Creates a new BankAccount with the passed in information
   public BankAccount(String name, double startingBalance) {
    owner = name;
    balance = startingBalance;
   }
   
   // returns the current account balance
   public double getBalance() {
      return balance;
   } 
   
   // withdraws the passed in amount of money from the 
   // account as long as this will not overdraw the account
   // (make the balance negative). Returns true if a withdraw was
   // able to be made succesfully and false otherwise.
   public boolean withdraw(double value) {
      if(balance - value >= 0 && value >= 0) {
         balance -= value;
         return true;
      }
      return false;
   }
}