package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    private static String playerName;
    private static String playerAnswer;
    private static int countCorrectAnswers = 0;
    public static final int QA_COUNT = 2;
    public static final int ROUNDS_NEED_TO_WIN = 3;
    public static final int BOUND_TO_GENERATE_NUMBERS = 21;

    public static void gameLogic(String gameRule, String[][] questionsAndAnswers) {
        greeting(gameRule);
        while (countCorrectAnswers < ROUNDS_NEED_TO_WIN) {
            gameRound(questionsAndAnswers[countCorrectAnswers][0], questionsAndAnswers[countCorrectAnswers][1]);
        }
        playerWonMessage();
    }

    public static void greeting(String gameRule) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWelcome to the Brain Games!"
                            + "\nMay I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!\n" + gameRule);
    }

    public static void gameRound(String generatedQuestion, String rightAnswer) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Question: " + generatedQuestion
                + "\nYour answer: ");
        playerAnswer = scanner.nextLine();
        if (isCorrectAnswer(rightAnswer)) {
            System.out.println("Correct!");
            countCorrectAnswers++;
        } else {
            System.out.println("'" + playerAnswer + "' is wrong answer ;(. "
                    + "Correct answer was '" + rightAnswer + "'."
                    + "\nLet's try again, " + playerName + "!");
            countCorrectAnswers = ROUNDS_NEED_TO_WIN + 1;
        }
    }

    public static int generateRandomNumber(int maxBound) {
        Random random = new Random();
        return random.nextInt(maxBound);
    }

    public static boolean isCorrectAnswer(String rightAnswer) {
        return rightAnswer.equals(playerAnswer);
    }

    public static void playerWonMessage() {
        if (countCorrectAnswers == ROUNDS_NEED_TO_WIN) {
            System.out.println("Congratulations, " + playerName + "!");
        }
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static String getPlayerAnswer() {
        return playerAnswer;
    }

    public static int getCountCorrectAnswers() {
        return countCorrectAnswers;
    }
}
