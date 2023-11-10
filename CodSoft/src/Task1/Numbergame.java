package Task1;
import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        
        int maxRange = 100;
        
        int randomNumber = random.nextInt(maxRange ) ;
        
        int attempts = 0;
        
        boolean hasGuessedCorrectly = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a random number between 1 to 100 " );
        
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            
              if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the correct number, which is " + randomNumber + ".");
                System.out.println("It took you " + attempts + " attempts to guess it!");
            }
        }
        
        scanner.close();
    }
}
