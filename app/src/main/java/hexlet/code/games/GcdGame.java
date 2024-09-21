package hexlet.code.games;

import hexlet.code.Engine;

public class GcdGame {

    private static int number1;
    private static int number2;
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            number1 = Engine.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            number2 = Engine.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            oneRound[0] = (number1) + " " + (number2);
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer() {
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
