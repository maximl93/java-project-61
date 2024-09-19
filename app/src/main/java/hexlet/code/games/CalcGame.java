package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.greeting;
import static hexlet.code.Engine.gameRounds;
import static hexlet.code.Engine.getCountCorrectAnswers;
import static hexlet.code.Engine.ROUNDS_NEED_TO_WIN;
import static hexlet.code.Engine.generateRandomNumber;

public class CalcGame {

    private static int operand1;
    private static int operand2;
    private static String operator;

    public static void calcGameStart() {
        greeting();
        System.out.println("What is the result of the expression?");
        calcGameLogic();
    }

    private static void calcGameLogic() {
        while (getCountCorrectAnswers() < ROUNDS_NEED_TO_WIN) {
            gameRounds(generateQuestion(), rightAnswer());
        }
    }

    private static String generateOperator() {
        Random random = new Random();
        var randomOperator = random.nextInt(1, 4);
        switch (randomOperator) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
            default:
                return "";
        }
    }

    private static String generateQuestion() {
        operand1 = generateRandomNumber();
        operand2 = generateRandomNumber();
        operator = generateOperator();
        return operand1 + " " + operator + " " + operand2;
    }

    private static String rightAnswer() {
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
