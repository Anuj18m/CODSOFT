import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    public BankAccount authenticateUser(int accountNumber, int pin) {
        BankAccount acc = findAccount(accountNumber);

        if (acc != null && acc.authenticate(pin)) {
            return acc;
        }

        return null;
    }

    // 🔥 Correct transfer logic
    public boolean transfer(int fromAccNo, int toAccNo, double amount) {

        BankAccount from = findAccount(fromAccNo);
        BankAccount to = findAccount(toAccNo);

        if (from == null || to == null) return false;

        if (amount <= 0 || amount > from.getBalance()) return false;

        // Use transfer-specific methods
        from.transferOut(amount, toAccNo);
        to.transferIn(amount, fromAccNo);

        return true;
    }
}