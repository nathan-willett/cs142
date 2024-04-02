// SMALL PROBLEMS 7B PART ONE [BankAccount-toString]

package SmallProblems7B__2_23;

public class BankAccount {
    /*
     * By declaring name and balance as private fields, you restrict direct access to these variables from 
     * outside the class. This is a key aspect of encapsulation, which is about bundling the data (attributes) 
     * and methods (functions or operations) that operate on the data into a single unit, and restricting access 
     * to the internals of that unit. Data hiding is a principle that supports encapsulation by making fields 
     * private and only accessible through public methods (getters and setters), thus allowing you to control 
     * how the data is accessed or modified.
     * 
     * Declaring fields at the class level and controlling their access through constructors and methods follows 
     * object-oriented best practices. It makes the code more maintainable, modular, and easier to understand. 
     * It allows for the detailed implementation of features like lazy initialization or read-only fields (where 
     * applicable).
     */
    private String name;
    private double balance;
    
    // Main Method
    public static void main(String[] args) {
        // Create an instance of BankAccount
        BankAccount benben = new BankAccount("Benson", 17.25);
        
        // Call toString method and print the result
        System.out.println(benben.toString());
    }
    
    // Constructor for the BankAccount object
    public BankAccount (String name, double balance) {
        this.name = name;
        this.balance = 0;
    }
    
   // SMALL PROBLEMS 7B PART ONE [BankAccount-toString]
   /* 
    * Add the following method to the BankAccount class: 
    * 
    * public String toString()
    * 
    * Your method should return a string that contains the account's name and balance separated by a comma and
    * space. For example, if an account object named benben has the name "Benson" and a balance of 17.25, the 
    * call of benben.toString() should return:
    * 
    * Benson, $17.25
    * 
    * There are some special cases you should handle. If the balance is negative, put the - sign before the
    * dollar sign. Also, always display the cents as a two-digit number. For example, if the same object had
    * a balance of -17.5, your method should return:
    * 
    * Benson, -$17.50
    */
    @Override
    public String toString() {
        String formattedBalance;
        // Check if the balance is negative and format accordingly
        if (balance < 0) {
            formattedBalance = String.format("-$%.2f", -balance);
        } else {
            formattedBalance = String.format("$%.2f", balance);
        }
        return name + ", " + formattedBalance;
    }
}
