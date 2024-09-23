package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Gcd {

    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            generateRoundData(oneRound);
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer(int number1, int number2) {
        return number2 == 0 ? String.valueOf(number1) : correctAnswer(number2, number1 % number2);
    }

    private static void generateRoundData(String[] oneRound) {
        var number1 = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
        var number2 = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
        oneRound[0] = (number1) + " " + (number2);
        oneRound[1] = correctAnswer(number1, number2);
    }
}
