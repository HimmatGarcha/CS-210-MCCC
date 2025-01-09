
class CheckingAccount extends BankAccount {
    private static final double CHECK_PROCESS_FEE = 1.0;

    public CheckingAccount(String owner, long account, double initial) {
        super(owner, account, initial);
    }

    public boolean processCheck(double amount) {
        return withdraw(amount, CHECK_PROCESS_FEE) != balance;
    }
}


// constructs a checking account and creates a check using withdraw fn
