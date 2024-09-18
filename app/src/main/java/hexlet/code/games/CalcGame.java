package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.Engine.*;

public class CalcGame {
    public static void calcGameStart() {
        greeting();
        System.out.println("What is the result of the expression?");
        calcGameLogic();
    }

    private static void calcGameLogic() {
        while (countCorrectAnswers < 3) {
            var operand1 = generateRandomNumber();
            var operand2 = generateRandomNumber();
            var operator = generateOperator();
            gameRound(generateQuestion(operand1, operand2 , operator));
            if (isCorrectAnswer(rightAnswer(operand1, operand2, operator), playerAnswer)) {
                System.out.println("Correct!");
                countCorrectAnswers++;
            } else {
                System.out.println("'" + playerAnswer + "' is wrong answer ;(. "
                                    + "Correct answer was '" + rightAnswer(operand1, operand2, operator) + "'"
                                    + "\nLet's try again, " + playerName + "!");
                break;
            }
        }
        playerWonMessage();
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

    private static String generateQuestion(int operand1, int operand2, String operator) {
        return operand1 + " " + operator + " " + operand2;
    }

    private static String rightAnswer(int operand1, int operand2, String operator) {
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
