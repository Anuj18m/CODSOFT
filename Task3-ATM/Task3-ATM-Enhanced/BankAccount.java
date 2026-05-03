import java.util.ArrayList;

public class BankAccount {

    private int accountNumber;
    private int pin;
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(int accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public boolean authenticate(int enteredPin) {
        return this.pin == enteredPin;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited ₹" + amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        transactions.add("Withdrew ₹" + amount);
        return true;
    }

    // 🔥 Transfer methods (IMPORTANT)
    public void transferOut(double amount, int toAccNo) {
        balance -= amount;
        transactions.add("Transferred ₹" + amount + " to " + toAccNo);
    }

    public void transferIn(double amount, int fromAccNo) {
        balance += amount;
        transactions.add("Received ₹" + amount + " from " + fromAccNo);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }
}