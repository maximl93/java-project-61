package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static String playerName;
    public static String playerAnswer;
    public static int countCorrectAnswers = 0;

    public static void greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWelcome to the Brain Games!"
                            + "\nMay I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(1, 21);
    }

    public static boolean isCorrectAnswer(String rightAnswer) {
        return rightAnswer.equals(playerAnswer);
    }

    public static void playerWonMessage() {
        if (countCorrectAnswers == 3) {
            System.out.println("Congratulations, " + playerName + "!");
        }
    }

    public static void gameRounds(String generatedQuestion, String rightAnswer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question: " + generatedQuestion);
        System.out.print("Your answer: ");
        playerAnswer = scanner.nextLine();
        if (isCorrectAnswer(rightAnswer)) {
            System.out.println("Correct!");
            countCorrectAnswers++;
        } else {
            System.out.println("'" + playerAnswer + "' is wrong answer ;(. "
                    + "Correct answer was '" + rightAnswer + "'."
                    + "\nLet's try again, " + playerName + "!");
            countCorrectAnswers = 10;
        }
        playerWonMessage();
    }
}
