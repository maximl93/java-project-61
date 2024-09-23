package hexlet.code.games;


import hexlet.code.Engine;
import hexlet.code.Util;


public class EvenGame {

    private static int questionNumber;
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            questionNumber = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            oneRound[0] = String.valueOf(questionNumber);
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer() {
        return questionNumber % 2 == 0 ? "yes" : "no";
    }
}
