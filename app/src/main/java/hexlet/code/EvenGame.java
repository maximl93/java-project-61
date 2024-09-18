package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {

    public static void evenGameStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        var playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        evenGameLogic(playerName);
    }

    private static void evenGameLogic(String playerName) {
        var countCorrectAnswers = 0;
        Scanner scanner = new Scanner(System.in);
        while (countCorrectAnswers < 3) {
            var question = generateRandomNumber();
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            var playerAnswer = scanner.nextLine();
            if (isCorrectAnswer(question, playerAnswer)) {
                System.out.println("Correct!");
                countCorrectAnswers++;
            } else {
                break;
            }
        }
        if (countCorrectAnswers == 3) {
            System.out.println("Congratulations, " + playerName + "!");
        }
    }

    private static boolean isCorrectAnswer(int question, String playerAnswer) {
        if (isEven(question) && playerAnswer.equals("yes")) {
            return true;
        } else {
            return !isEven(question) && playerAnswer.equals("no");
        }
    }

    private static boolean isEven(int question) {
        return question % 2 == 0;
    }

    private static int generateRandomNumber() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(1, 20);
    }
}
