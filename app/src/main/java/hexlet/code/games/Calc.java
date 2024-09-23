package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {

    private static int operand1;
    private static int operand2;
    private static String operator;
    private static final int BOUND_TO_GENERATE_OPERATOR = 3;
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            operand1 = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            operand2 = Util.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            operator = OPERATORS[Util.generateRandomNumber(BOUND_TO_GENERATE_OPERATOR)];
            oneRound[0] = operand1 + " " + operator + " " + operand2;
            oneRound[1] = correctAnswer();
        }
        return questionsAndAnswers;
    }

    private static String correctAnswer() {
        switch (operator) {
            case "+":
                return String.valueOf(Math.addExact(operand1, operand2));
            case "-":
                return String.valueOf(Math.subtractExact(operand1, operand2));
            case "*":
                return String.valueOf(Math.multiplyExact(operand1, operand2));
            default:
                return String.valueOf(0);
        }
    }
}
