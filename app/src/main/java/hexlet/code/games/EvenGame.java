package hexlet.code.games;


import static hexlet.code.Engine.greeting;
import static hexlet.code.Engine.gameRounds;
import static hexlet.code.Engine.getCountCorrectAnswers;
import static hexlet.code.Engine.ROUNDS_NEED_TO_WIN;
import static hexlet.code.Engine.generateRandomNumber;


public class EvenGame {

    private static int questionNumber;

    public static void evenGameStart() {
        greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        evenGameLogic();
    }

    private static void evenGameLogic() {
        while (getCountCorrectAnswers() < ROUNDS_NEED_TO_WIN) {
            gameRounds(generateQuestion(), rightAnswer());
        }
    }

    private static String generateQuestion() {
        questionNumber = generateRandomNumber();
        return String.valueOf(questionNumber);
    }

    private static String rightAnswer() {
        return questionNumber % 2 == 0 ? "yes" : "no";
    }
}
