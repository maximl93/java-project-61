package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {

    private static int progressionNumber;
    private static int gap;
    private static int missingNumberPosition;
    private static int missingNumber;
    private static final int SIZE_OF_PROGRESSION = 10;
    private static final String GAME_RULE = "What number is missing in the progression?";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            generateRoundData();
            oneRound[0] = generateProgression(progressionNumber, gap, missingNumberPosition);
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String generateProgression(int progressionNumber, int gap, int missingNumberPosition) {
        String[] progression = new String[SIZE_OF_PROGRESSION];
        for (int i = 0; i < SIZE_OF_PROGRESSION; i++) {
            progression[i] = String.valueOf(progressionNumber);
            progressionNumber += gap;
        }
        missingNumber = Integer.parseInt(progression[missingNumberPosition]);
        progression[missingNumberPosition] = "..";
        return String.join(" ", progression);
    }

    private static String correctAnswer() {
        return String.valueOf(missingNumber);
    }

    private static void generateRoundData() {
        progressionNumber = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
        gap = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
        missingNumberPosition = Util.generateRandomNumber(SIZE_OF_PROGRESSION);
    }
}
