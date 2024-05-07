// Allison Obourn
// CS 142, Spring 2024
// Lecture 13

// Represents a personal bank account. Each bank account has an owner with
// a name on record. It also has an ID number that is unique for each account. 
// The first account will always be 1000, the next 1001, etc.

public class BankAccount {
    private String name;
    private int id;
    
    // the initial account number of the first account 
    private static int nextAccount = 1000;

    public BankAccount() {
        id = nextAccount;  // give number to account
        nextAccount++;     // increase the account number so the next account
    }                      // is one number higher

    // other methods here ...

    // return this account's id
    public int getID() {   
        return id;
    }
    
    // returns the account number that will be given to the next account
    // created
    public static int getNextAccountNumber() {
        return nextAccount;
    }
}

