
import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game!");

        // Initial Story
        System.out.println("You find yourself in a dark forest. There are two paths in front of you.");
        System.out.println("Do you want to go left or right? (Enter 'left' or 'right')");

        // First decision
        String choice1 = scanner.nextLine().toLowerCase();

        if (choice1.equals("left")) {
            System.out.println("You walk down the left path and encounter a wild bear.");
            System.out.println("Do you want to run or stay? (Enter 'run' or 'stay')");

            // Second decision
            String choice2 = scanner.nextLine().toLowerCase();

            if (choice2.equals("run")) {
                System.out.println("You run away safely and find a village. You win!");
            } else if (choice2.equals("stay")) {
                System.out.println("The bear attacks you. You lose!");
            } else {
                System.out.println("Invalid input. The bear attacks you. You lose!");
            }

        } else if (choice1.equals("right")) {
            System.out.println("You walk down the right path and find a treasure chest.");
            System.out.println("Do you want to open it or leave it? (Enter 'open' or 'leave')");

            // Second decision
            String choice2 = scanner.nextLine().toLowerCase();

            if (choice2.equals("open")) {
                System.out.println("You open the chest and find gold. You win!");
            } else if (choice2.equals("leave")) {
                System.out.println("You leave the chest and walk away safely. You win!");
            } else {
                System.out.println("Invalid input. You walk away safely. You win!");
            }

        } else {
            System.out.println("Invalid input. You get lost in the forest. You lose!");
        }

        scanner.close();
        System.out.println("Thank you for playing the Adventure Game!");
    }
}
