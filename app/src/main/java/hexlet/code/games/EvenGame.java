package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.*;


public class EvenGame {

    public static void evenGameStart() {
        greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        evenGameLogic();
    }

    private static void evenGameLogic() {
        while (countCorrectAnswers < 3) {
            var questionNumber = generateRandomNumber();
            gameRound(generateQuestion(questionNumber));
            if (isCorrectAnswer(rightAnswer(questionNumber), playerAnswer)) {
                System.out.println("Correct!");
                countCorrectAnswers++;
            } else {
                break;
            }
        }
        playerWonMessage();
    }
    private static String generateQuestion(int questionNumber) {
        return String.valueOf(questionNumber);
    }

    private static String rightAnswer(int questionNumber) {
        return questionNumber % 2 == 0 ? "yes" : "no";
    }
}
