package hexlet.code.games;

import hexlet.code.Engine;

public class ProgressionGame {

    private static int missingNumber;
    private static final int SIZE_OF_PROGRESSION = 10;
    private static final String GAME_RULE = "What number is missing in the progression?";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            var progressionNumber = Engine.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            var gap = Engine.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            var missingNumberPosition = Engine.generateRandomNumber(SIZE_OF_PROGRESSION);
            StringBuilder question = new StringBuilder();
            for (int i = 0; i < SIZE_OF_PROGRESSION; i++) {
                if (i == missingNumberPosition) {
                    question.append("..").append(" ");
                    missingNumber = progressionNumber;
                    progressionNumber += gap;
                } else {
                    question.append(progressionNumber).append(" ");
                    progressionNumber += gap;
                }
            }
            oneRound[0] = question.toString();
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer() {
        return String.valueOf(missingNumber);
    }
}
