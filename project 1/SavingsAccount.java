class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String owner, long account, double initial, double interestRate) {
        super(owner, account, initial);
        this.interestRate = interestRate;
    }

    @Override
    public double addInterest() {
        balance += (balance * interestRate);
        return balance;
    }
}

// creates a saving account which applies interest overtime increasing the amount