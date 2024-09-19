package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.*;


public class EvenGame {

    private static int questionNumber;

    public static void evenGameStart() {
        greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        evenGameLogic();
    }

    private static void evenGameLogic() {
        while (countCorrectAnswers < 3) {
            gameRounds(generateQuestion(), rightAnswer());
        }
    }

    private static String generateQuestion() {
        questionNumber = generateRandomNumber();
        return String.valueOf(questionNumber);
    }

    private static String rightAnswer() {
        return questionNumber % 2 == 0 ? "yes" : "no";
    }
}
