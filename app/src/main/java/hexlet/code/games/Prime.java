package hexlet.code.games;

import java.math.BigInteger;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {

    private static int primeNumber;
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            generateRoundData();
            oneRound[0] = String.valueOf(primeNumber);
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer() {
        BigInteger bigInteger = BigInteger.valueOf(primeNumber);
        if (bigInteger.isProbablePrime((int) Math.log(primeNumber)) && primeNumber != 1 && primeNumber != 0) {
            return "yes";
        } else {
            return "no";
        }
    }

    private static void generateRoundData() {
        primeNumber = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
    }
}
