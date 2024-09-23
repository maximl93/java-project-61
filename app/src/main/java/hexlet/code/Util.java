package hexlet.code;

import java.util.Random;

public class Util {

    public static int generateRandomNumber(int maxBound) {
        Random random = new Random();
        return random.nextInt(maxBound);
    }
}
