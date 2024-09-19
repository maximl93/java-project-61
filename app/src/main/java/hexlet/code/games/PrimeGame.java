package hexlet.code.games;

import java.math.BigInteger;

import static hexlet.code.Engine.greeting;
import static hexlet.code.Engine.gameRounds;
import static hexlet.code.Engine.getCountCorrectAnswers;
import static hexlet.code.Engine.ROUNDS_NEED_TO_WIN;
import static hexlet.code.Engine.generateRandomNumber;

public class PrimeGame {

    private static int questionNumber;

    public static void primeGameStart() {
        greeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        primeGameLogic();
    }

    private static void primeGameLogic() {
        while (getCountCorrectAnswers() < ROUNDS_NEED_TO_WIN) {
            gameRounds(generateQuestion(), rightAnswer());
        }
    }

    private static String generateQuestion() {
        questionNumber = generateRandomNumber();
        return String.valueOf(questionNumber);
    }

    private static String rightAnswer() {
        BigInteger bigInteger = BigInteger.valueOf(questionNumber);
        if (bigInteger.isProbablePrime((int) Math.log(questionNumber)) && questionNumber != 1) {
            return "yes";
        } else {
            return "no";
        }
    }
}
