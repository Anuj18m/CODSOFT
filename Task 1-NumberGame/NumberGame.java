import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Game!");

        int randomNumber = random.nextInt(100) + 1;

        boolean guessedCorrectly = false;

        for (int i = 0; i < 5; i++) {

            System.out.println("Attempt " + (i + 1) + " of 5");
            System.out.print("Enter your guess (1–100): ");

            int userNumber = scanner.nextInt();

            if (userNumber == randomNumber) {
                guessedCorrectly = true;
                break;
            } else if (userNumber < randomNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        if (guessedCorrectly) {
            System.out.println("🎉 Congratulations! You guessed the number!");
        } else {
            System.out.println("❌ Game Over! The number was: " + randomNumber);
        }

        scanner.close();
    }
}