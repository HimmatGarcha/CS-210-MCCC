//***************************************************************************
// Account.java      Author: Himmat Garcha
//
// Represents a bank account with basic services such as deposit and withdraw
//***************************************************************************

import java.text.NumberFormat;

public class Account
{
   private final double RATE = 0.035; // intrest rate which is 3.5%
   
   private long acctNumber;
   private double balance;
   private String name;
   
  //------------------------------------------------------------
  // sets up the account and defines its owner, account number
  // and its intial balance.
  //------------------------------------------------------------
   public Account(String owner, long account, double initial)
   {
      name = owner;
      acctNumber = account;
      balance = initial;
      
   }
  
  //------------------------------------------------------------
  // deposits x amount in the account and returns new balance
  //------------------------------------------------------------
   public double deposit(double amount)
   {
      balance = balance + amount;
      return balance;
   }
   
  //------------------------------------------------------------
  // withdraws x amount in the account and returns new balance
  //------------------------------------------------------------
   public double withdraw(double amount, double fee)
   {
      balance = balance - amount - fee;
      return balance;
   }
   
  //------------------------------------------------------------
  // returns balance
  //------------------------------------------------------------   
  public double getBalance()
  {
     return balance;
  }
   
   
   
  //------------------------------------------------------------
  // adds interest to the account and returns new balance
  //------------------------------------------------------------
   public double addInterest()
   {
      balance += (balance * RATE);
      return balance;
   }
   
  //------------------------------------------------------------
  // returns a single line description of the account as a string
  //------------------------------------------------------------
   public String toSting()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
      return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
   }
}
   
