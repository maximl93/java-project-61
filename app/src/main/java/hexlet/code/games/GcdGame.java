package hexlet.code.games;

import static hexlet.code.Engine.greeting;
import static hexlet.code.Engine.gameRounds;
import static hexlet.code.Engine.getCountCorrectAnswers;
import static hexlet.code.Engine.ROUNDS_NEED_TO_WIN;
import static hexlet.code.Engine.generateRandomNumber;

public class GcdGame {

    private static int number1;
    private static int number2;

    public static void nodGameStart() {
        greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
        gcdGameLogic();
    }

    public static void  gcdGameLogic() {
        while (getCountCorrectAnswers() < ROUNDS_NEED_TO_WIN) {
            gameRounds(generateQuestion(), rightAnswer());
        }
    }

    public static String generateQuestion() {
        number1 = generateRandomNumber();
        number2 = generateRandomNumber();
        return (number1) + " " + (number2);
    }

    public static String rightAnswer() {
        while (number1 != number2) {
            if (number1 > number2) {
                number1 = number1 - number2;
            } else {
                number2 = number2 - number1;
            }
        }
        return String.valueOf(number1);
    }
}
