// SMALL PROBLEMS 8A PART ONE [BankAccount-transactionFee]

package SmallProblems8A__2_23;

/* A BankAccount keeps track of a user's money balance and ID, and counts how many transactions (deposits/
withdrawals) are made. */
public class BankAccount {
    private String id;          // added by 8A [BankAccount-transactionFee]
    private double balance;
    private int transactions;   // added by 8A [BankAccount-transactionFee]

    // Main Method
    public static void main(String[] args) {
        BankAccount benben = new BankAccount("Benson");
        benben.deposit(100); // Example deposit
        benben.withdraw(50); // Example withdrawal
        benben.transactionFee(5); // Example transaction fee
        System.out.println(benben.toString());
    }
    

    // Constructs a BankAccount object with the given id, and
    // 0 balance and transactions.
    public BankAccount(String id) {     // updated by 8A. Changes 'name' to 'id'. removes double 'balance' from parameter.
        this.id = id;
        this.balance = 0;
        this.transactions = 0;
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
     * dollar sign. Also, always display the cents as a two-digit number. For example, if the same object had a 
     * balance of -17.5, your method should return:
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
        return id + ", " + formattedBalance;
    }


    // returns the field values
    public double getBalance() {
        return this.balance;
    }


    public String getID() {
        return this.id;
    }


    public int getTransactions() {
        return this.transactions;
    }
    

    // Adds the amount to the balance if it is between 0-500.
    // Also counts as 1 transaction.
    public void deposit(double amount) {
        if (amount > 0 && amount <= 500) {
            balance += amount;
            transactions++; // Increment the number of transactions
        }
    }


    // Subtracts the amount from the balance if the user has enough money.
    // Also counts as 1 transaction.
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactions++; // Increment the number of transactions
        }
    }


    // SMALL PROBLEMS 8A PART ONE [BankAccount-transactionFee]
    /* 
     * The transactionFee method accepts a fee amount (a real number) as a
     * parameter, and applies that fee to the user's past transactions. The
     * fee is applied once for the first transaction, twice for the second
     * transaction, three times for the third, and so on. These fees are
     * subtracted out from the user's overall balance. If the user's balance
     * is large enough to afford all of the fees with greater than $0.00
     * remaining, the method returns true. If the balance cannot afford all
     * of the fees or has no money left, the balance is left as 0.0 and the
     * method returns false.
     */
    public boolean transactionFee(double fee) {
        double totalFee = 0;

        for (int i = 1; i <= transactions; i++) {
            totalFee += fee * i;
        }

        if (balance - totalFee > 0.00) {
            balance -= totalFee; // Deduct the total fee from the balance
            return true;
        } else {
            balance = 0.0; // Set the balance to 0.0 if the fees cannot be fully covered
            return false;
        }
    }
}
