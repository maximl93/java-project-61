package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.greeting;
import static hexlet.code.Engine.gameRounds;
import static hexlet.code.Engine.countCorrectAnswers;
import static hexlet.code.Engine.generateRandomNumber;

public class ProgressionGame {

    private static int missingNumber;
    private static int missingNumberPosition;
    private static int gap;
    private static final int SIZE_OF_PROGRESSION = 10;

    public static void progressionGameStart() {
        greeting();
        System.out.println("What number is missing in the progression?");
        progressionGameLogic();
    }

    private static void progressionGameLogic() {
        while (countCorrectAnswers < 3) {
            gameRounds(generateQuestion(), rightAnswer());
        }
    }

    private static String generateQuestion() {
        Random random = new Random();
        var progressionNumber = generateRandomNumber();
        gap = generateRandomNumber();
        missingNumberPosition = random.nextInt(1, 10);
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < SIZE_OF_PROGRESSION; i++) {
            if (i == missingNumberPosition) {
                question.append("..").append(" ");
                missingNumber = progressionNumber;
                progressionNumber += gap;
            } else {
                question.append(progressionNumber).append(" ");
                progressionNumber += gap;
            }
        }
        return question.toString();
    }

    private static String rightAnswer() {
        return String.valueOf(missingNumber);
    }
}
