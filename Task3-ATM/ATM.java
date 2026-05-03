import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000);

        int choice = 0;
        String lastTransaction = "No transactions yet";

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("5. View Last Transaction");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");

                    if (sc.hasNextDouble()) {
                        double depositAmount = sc.nextDouble();

                        if (account.deposit(depositAmount)) {
                            System.out.println("Deposit successful.");
                            System.out.println("Updated Balance: ₹" + account.getBalance());
                            lastTransaction = "Deposited ₹" + depositAmount;
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }

                    } else {
                        System.out.println("Invalid input!");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");

                    if (sc.hasNextDouble()) {
                        double withdrawAmount = sc.nextDouble();

                        if (account.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful.");
                            System.out.println("Updated Balance: ₹" + account.getBalance());
                            lastTransaction = "Withdrew ₹" + withdrawAmount;
                        } else {
                            System.out.println("Insufficient balance or invalid amount.");
                        }

                    } else {
                        System.out.println("Invalid input!");
                        sc.next();
                    }
                    break;

                case 5:
                    System.out.println("Last Transaction: " + lastTransaction);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}