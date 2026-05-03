import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        // Sample accounts
        bank.addAccount(new BankAccount(1001, 1234, 5000));
        bank.addAccount(new BankAccount(1002, 4321, 3000));

        System.out.println("===== Welcome to ATM =====");

        BankAccount currentAccount = null;
        int attempts = 3;

        // 🔐 Login
        while (attempts > 0) {

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            currentAccount = bank.authenticateUser(accNo, pin);

            if (currentAccount != null) {
                System.out.println("Login successful!");
                break;
            } else {
                attempts--;
                System.out.println("Invalid credentials. Attempts left: " + attempts);
            }
        }

        if (currentAccount == null) {
            System.out.println("Account locked. Try later.");
            sc.close();
            return;
        }

        int choice = 0;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transactions");
            System.out.println("5. Transfer Money");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("------------------------");
                    System.out.println("Current Balance: ₹" + currentAccount.getBalance());
                    System.out.println("------------------------");
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    if (sc.hasNextDouble()) {
                        double amount = sc.nextDouble();
                        if (currentAccount.deposit(amount)) {
                            System.out.println("Deposit successful.");
                        } else {
                            System.out.println("Invalid amount.");
                        }
                    } else {
                        System.out.println("Invalid input!");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    if (sc.hasNextDouble()) {
                        double amount = sc.nextDouble();
                        if (currentAccount.withdraw(amount)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Invalid input!");
                        sc.next();
                    }
                    break;

                case 4:
                    System.out.println("Transaction History:");
                    for (String t : currentAccount.getTransactions()) {
                        System.out.println("- " + t);
                    }
                    break;

                case 5:
                    System.out.print("Enter recipient account number: ");
                    int toAcc = sc.nextInt();

                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();

                    if (bank.transfer(currentAccount.getAccountNumber(), toAcc, amt)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed.");
                    }
                    break;

                case 6:
                    System.out.println("Logged out.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}