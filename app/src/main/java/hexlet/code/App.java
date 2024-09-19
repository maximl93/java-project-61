package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.greeting;
import static hexlet.code.games.EvenGame.evenGameStart;
import static hexlet.code.games.CalcGame.calcGameStart;
import static hexlet.code.games.GcdGame.nodGameStart;
import static hexlet.code.games.PrimeGame.primeGameStart;
import static hexlet.code.games.ProgressionGame.progressionGameStart;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerChoice;

        System.out.print("Please enter the game number and press Enter\n"
                            + "1 - Greet\n"
                            + "2 - Even\n"
                            + "3 - Calc\n"
                            + "4 - GCD\n"
                            + "5 - Progression\n"
                            + "6 - Prime\n"
                            + "0 - Exit\n"
                            + "Your choice: ");
        playerChoice = scanner.nextInt();

        switch (playerChoice) {
            case 1:
                greeting();
                break;
            case 2:
                evenGameStart();
                break;
            case 3:
                calcGameStart();
                break;
            case 4:
                nodGameStart();
                break;
            case 5:
                progressionGameStart();
                break;
            case 6:
                primeGameStart();
                break;
            default:
                break;
        }
    }
}
