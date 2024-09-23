package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Gcd {

    private static int number1;
    private static int number2;
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            number1 = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            number2 = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            oneRound[0] = (number1) + " " + (number2);
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer() {
        if (number1 == 0) {
            return String.valueOf(number2);
        }

        while (number2 != 0) {
            if (number1 > number2) {
                number1 = number1 - number2;
            } else {
                number2 = number2 - number1;
            }
        }
        return String.valueOf(number1);
    }
}
