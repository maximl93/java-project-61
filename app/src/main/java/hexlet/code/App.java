package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

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
                EvenGame.gameStart();
                break;
            case "3":
                CalcGame.gameStart();
                break;
            case "4":
                GcdGame.gameStart();
                break;
            case "5":
                ProgressionGame.gameStart();
                break;
            case "6":
                PrimeGame.gameStart();
                break;
            default:
                break;
        }
    }
}
