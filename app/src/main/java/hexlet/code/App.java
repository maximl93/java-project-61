package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerChoice;

        System.out.print("Please enter the game number and press Enter\n"
                            + "1 - Greet\n"
                            + "2 - Even\n"
                            + "3 - Calc\n"
                            + "4 - GCD\n"
                            + "5 - Progression\n"
                            + "6 - Prime\n"
                            + "0 - Exit\n"
                            + "Your choice: ");
        playerChoice = scanner.nextLine();

        switch (playerChoice) {
            case "1":
                Cli.greeting();
                break;
            case "2":
                Even.gameStart();
                break;
            case "3":
                Calc.gameStart();
                break;
            case "4":
                Gcd.gameStart();
                break;
            case "5":
                Progression.gameStart();
                break;
            case "6":
                Prime.gameStart();
                break;
            default:
                break;
        }
    }
}
