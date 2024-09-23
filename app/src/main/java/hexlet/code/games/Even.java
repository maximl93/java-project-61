package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Util;


public class Even {

    private static int evenOrOdd;
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            generateRoundData();
            oneRound[0] = String.valueOf(evenOrOdd);
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer() {
        return evenOrOdd % 2 == 0 ? "yes" : "no";
    }

    private static void generateRoundData() {
        evenOrOdd = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
    }
}
