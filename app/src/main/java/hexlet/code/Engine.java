package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static String playerName;
    public static String playerAnswer;
    public static int countCorrectAnswers = 0;

    public static void greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName);
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(1, 20);
    }

    public static boolean isCorrectAnswer(String rightAnswer, String playerAnswer) {
        return rightAnswer.equals(playerAnswer);
    }

    public static void gameRound(String generatedQuestion) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question: " + generatedQuestion);
        System.out.print("Your answer: ");
        playerAnswer = scanner.nextLine();
    }

    public static void playerWonMessage() {
        if (countCorrectAnswers == 3) {
            System.out.println("Congratulations, " + playerName + "!");
        }
    }
}
