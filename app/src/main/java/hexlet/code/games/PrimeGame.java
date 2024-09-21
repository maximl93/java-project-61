package hexlet.code.games;

import java.math.BigInteger;

import hexlet.code.Engine;


public class PrimeGame {

    private static int questionNumber;
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            questionNumber = Engine.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            oneRound[0] = String.valueOf(questionNumber);
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer() {
        BigInteger bigInteger = BigInteger.valueOf(questionNumber);
        if (bigInteger.isProbablePrime((int) Math.log(questionNumber)) && questionNumber != 1) {
            return "yes";
        } else {
            return "no";
        }
    }
}
