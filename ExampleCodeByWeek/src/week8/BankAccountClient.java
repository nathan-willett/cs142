// CS& 141, Winter 2024

// Client that uses our custom BankAccount class.
// Creates a bank accounts, prints out the balance
// Thanks to Allison Obourn for parts of this program

package week8;

public class BankAccountClient {
   public static void main(String[] args) {
      BankAccount account = new BankAccount("merlin", 3);
      
      // NOTE: the following code worked until we made our fields private. 
      //       now that our BankAccount fields are private, it won't compile.
      //account.balance -= 1000;
      System.out.println("balance : " + account.getBalance());
   }
}