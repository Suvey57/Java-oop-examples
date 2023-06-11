
class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance: $" + balance);
    }
}


class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}


class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Applied interest: $" + interest);
    }
}


public class ATM {
    public static void main(String[] args) {
        Account account1 = new CheckingAccount("123456789", 1000.0, 500.0);
        Account account2 = new SavingsAccount("987654321", 2000.0, 2.5);

        account1.displayBalance();
        account1.deposit(500.0);
        account1.withdraw(1500.0);
        account1.displayBalance();

        account2.displayBalance();
        account2.deposit(1000.0);
        
        if (account2 instanceof SavingsAccount) {
            ((SavingsAccount) account2).applyInterest();
        }
        
        account2.withdraw(2500.0);
        account2.displayBalance();
    }
}
