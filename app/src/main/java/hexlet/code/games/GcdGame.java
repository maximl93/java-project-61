package hexlet.code.games;

import static hexlet.code.Engine.*;

public class GcdGame {

    private static int number1;
    private static int number2;

    public static void nodGameStart() {
        greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
        gcdGameLogic();
    }

    public static void  gcdGameLogic() {
        while (countCorrectAnswers < 3) {
            gameRounds(generateQuestion(), rightAnswer());
        }
    }

    public static String generateQuestion() {
        number1 = generateRandomNumber();
        number2 = generateRandomNumber();
        return (number1 * 5) + " " + (number2 * 5);
    }

    public static String rightAnswer() {
        number1 = number1 * 5;
        number2 = number2 * 5;

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
