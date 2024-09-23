package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {

    private static int missingNumber;
    private static final int SIZE_OF_PROGRESSION = 10;
    private static final String GAME_RULE = "What number is missing in the progression?";

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

    private static String generateProgression(int progressionNumber, int gap, int missingNumberPosition) {
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
        return question.toString();
    }

    private static String correctAnswer() {
        return String.valueOf(missingNumber);
    }

    private static void generateRoundData(String[] oneRound) {
        var progressionNumber = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
        var gap = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
        var missingNumberPosition = Util.generateRandomNumber(SIZE_OF_PROGRESSION);
        oneRound[0] = generateProgression(progressionNumber, gap, missingNumberPosition);
        oneRound[1] = correctAnswer();
    }
}
