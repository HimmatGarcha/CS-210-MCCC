import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private long nextAccountNumber = 1000; // Starting account number
    private final String correctPassword = "12345";

// starts interface

    public void start() {
        int passwordAttempts = 0;
        while (passwordAttempts < 3) {
            System.out.print("Please enter your password: ");
            String enterPassword = scanner.nextLine();
            if (enterPassword.equals(correctPassword)) {
                showMainMenu();
                break;
            } else {
                System.out.println("Incorrect password try again");
                passwordAttempts++;
            }
        }
        if (passwordAttempts == 3) {
            System.out.println("Too many incorrect attempts. Please try again later, exiting system.");
            return;
        }
    }
// above code is the login interface user has three attempts to login in with a preset password
//if they fail to login in after 3 tries program ends if they get it correct options are displayed

    private void showMainMenu() {
        int choice;
        do {
            System.out.println("---------------------------------------------");
            System.out.println("Welcome to our Bank System");
            System.out.println("---------------------------------------------");
            System.out.println("<1> Account summary");
            System.out.println("<2> Create a new account");
            System.out.println("<3> Make deposit");
            System.out.println("<4> Withdraw");
            System.out.println("<5> Process check");
            System.out.println("<6> Exit");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    displayAllAccounts();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    makeDeposit();
                    break;
                case 4:
                    makeWithdrawal();
                    break;
                case 5:
                    processCheck();
                    break;
                case 6:
                    System.out.println("Thanks for using our Bank System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }

// displays main menu of the bank system and all of the options


// shows all accounts made

    private void displayAllAccounts() {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
    
// guide users through creating a new account

    private void createAccount() {
        System.out.println("Do you want to create a new");
        System.out.println("<1> Checking Account");
        System.out.println("<2> Saving Account");
        System.out.print(" Which type of account you would like to make: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Please enter the starting deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Please enter the owners name: ");
        String owner = scanner.nextLine();

        if (choice == 1) {
            accounts.add(new CheckingAccount(owner, nextAccountNumber++, deposit));
            System.out.println("Your checking account is created.");
        } else if (choice == 2) {
            System.out.print("Please enter the interest rate (e.g., 0.03 for 3%): ");
            double interestRate = scanner.nextDouble();
            scanner.nextLine(); 
            accounts.add(new SavingsAccount(owner, nextAccountNumber++, deposit, interestRate));
            System.out.println("Your saving account is created.");
        } else {
            System.out.println("Invalid choice.");
        }
    }
    
    // deposit x money into account

    private void makeDeposit() {
        System.out.print("Please enter your account number: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); 
        System.out.print("Please enter the deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        for (BankAccount account : accounts) {
            if (account.acctNumber == accountNumber) {
                account.deposit(amount);
                System.out.printf("$%.2f has been deposited to Account #%d\n", amount, accountNumber);
                return;
            }
        }
        System.out.println("Account not found.");
    }
    
   // withdraws x money

    private void makeWithdrawal() {
        System.out.print("Please enter your account number: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); 
        System.out.print("Please enter the withdrawal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        for (BankAccount account : accounts) {
            if (account.acctNumber == accountNumber) {
                account.withdraw(amount, 0); 
                System.out.printf("$%.2f has been withdrawn from Account #%d\n", amount, accountNumber);
                return;
            }
        }
        System.out.println("Account not found.");
    }

// process check and checks if the check bounces or not if bounces will ask to try again if check is entered wrong with say invalid otherwise will work 

    private void processCheck() {
        System.out.print("Please enter the account number: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); 
        for (BankAccount account : accounts) {
            if (account.acctNumber == accountNumber && account instanceof CheckingAccount) {
                System.out.print("Please enter the check amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); 
                if (((CheckingAccount) account).processCheck(amount)) {
                    System.out.printf("Check with amount of $%.2f has been processed from Account #%d\n", amount, accountNumber);
                } else {
                    System.out.println("Check could not be processed. Please try again.");
                }
                return;
            }
        }
        System.out.println("Invalid check or account not found.");
    }
}