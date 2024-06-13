package week4;

// Allison Obourn
// CS 142, Spring 2024
// Lecture 13

// Creates two bank accounts and outputs their IDs. Then outputs
// the next account ID that will be given out to the next 
// new account created

public class BankAccountClient {
   public static void main(String[] args) {
      BankAccount merlin = new BankAccount();
      BankAccount percy = new BankAccount();
      
      System.out.println("Merlin id: " + merlin.getID()); // 1000
      System.out.println("Percy id: " + percy.getID());   // 1001
      
      System.out.println("The next account created will have ID: " + 
         BankAccount.getNextAccountNumber());
   }
}