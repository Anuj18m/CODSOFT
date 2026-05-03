public class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Withdraw
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    // Get Balance
    public double getBalance() {
        return balance;
    }
}