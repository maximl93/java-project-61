package hexlet.code.games;

import java.util.Random;

import hexlet.code.Engine;

public class CalcGame {

    private static int operand1;
    private static int operand2;
    private static String operator;
    private static final int BOUND_TO_CREATE_OPERATOR = 4;
    private static final String GAME_RULE = "What is the result of the expression?";

    public static void gameStart() {
        Engine.gameLogic(GAME_RULE, generateQuestionsAndAnswers());
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_NEED_TO_WIN][Engine.QA_COUNT];
        for (String[] oneRound : questionsAndAnswers) {
            operand1 = Engine.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            operand2 = Engine.generateRandomNumber(Engine.BOUND_TO_GENERATE_NUMBERS);
            operator = generateOperator();
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

    private static String generateOperator() {
        Random random = new Random();
        var randomOperator = random.nextInt(1, BOUND_TO_CREATE_OPERATOR);
        switch (randomOperator) {
            case 1:
                return "+";
            case 2:
                return "-";
            default:
                return "*";
        }
    }
}
