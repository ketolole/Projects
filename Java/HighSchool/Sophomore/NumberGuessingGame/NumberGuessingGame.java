import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        int guess;
        String feedback;

        System.out.println("Think of a number between " + lowerBound + " and " + upperBound);
        System.out.println("(This is just for you to put here, I promise I don't actually know it): ");
        int numb = scanner.nextInt();
        int count = 0;
        while (true) {
            guess = lowerBound + (upperBound - lowerBound) / 2;
            System.out.println("Is the number " + guess + "? (higher/lower/yes)");
            feedback = scanner.nextLine().toLowerCase();
    
            if (feedback.equals("yes") || feedback.equals("exit")) {
                System.out.println("Heheheha, I am the best guessr! My number of tries: " + count);
                break;
            } else if (feedback.equals("higher")) {
                lowerBound = guess + 1;
            } else if (feedback.equals("lower")) {
                upperBound = guess - 1;
            } else {
                System.out.println("Invalid input. You have to answer with 'higher', 'lower', or 'yes'.");
            }
            count++;
        }
        scanner.close();
    }
}