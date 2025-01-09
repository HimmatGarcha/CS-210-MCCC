import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private final double RATE = 0.035; // interest rate is 3.5%

    protected long acctNumber;
    protected double balance;
    protected String name;


// constructs a bank account with x owner, y amount a int balance
    public BankAccount(String owner, long account, double initial) {
        name = owner;
        acctNumber = account;
        balance = initial;
    }

//deposits the specified amount into the account
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

// withdraws enter amount from the account unless the ammount exceeds whats in the account
    public double withdraw(double amount, double fee) {
        if (amount + fee <= balance) {
            balance -= amount + fee;
            return balance;
        } else {
            System.out.println("Unable to withdraw specifed amount due to insufficient funds please try again.");
            return balance;
        }
    }
    
// returns the account balance

    public double getBalance() {
        return balance;
    }

// applies interest to account defined by the rate
    public double addInterest() {
        balance += (balance * RATE);
        return balance;
    }
    
// returns a string representation of the bank account 

    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
    }
}

