import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1; // 1 to 100
        int maxAttempts = 5;
        int guess;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have " + maxAttempts + " attempts.");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            System.out.print("Attempt " + attempt + ": ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // remove invalid input
                attempt--; // don't count invalid input
                continue;
            }

            guess = sc.nextInt();

            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a number between 1 and 100.");
                attempt--; // don't count invalid range
                continue;
            }

            if (guess == secretNumber) {
                System.out.println("Correct! You guessed the number.");
                sc.close();
                return;
            } else if (guess < secretNumber) {
                System.out.println("Too Low");
            } else {
                System.out.println("Too High");
            }
        }

        System.out.println("Game Over!");
        System.out.println("The correct number was: " + secretNumber);

        sc.close();
    }
}

