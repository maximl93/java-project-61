package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Cli.greeting;
import static hexlet.code.EvenGame.evenGameStart;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerChoice;

        System.out.print("Please enter the game number and press Enter\n"
                            + "1 - Greet\n"
                            + "2 - Even\n"
                            + "0 - Exit\n"
                            + "Your choice: ");
        playerChoice = scanner.nextInt();

        switch (playerChoice) {
            case 1:
                System.out.println("\nWelcome to the Brain Games!");
                greeting();
                break;
            case 2:
                System.out.println("\nWelcome to the Brain Games!");
                evenGameStart();
                break;
            default:
                break;
        }
    }
}
