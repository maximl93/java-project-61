package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWelcome to the Brain Games!"
                        + "\nMay I have your name? ");
        var playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }
}
