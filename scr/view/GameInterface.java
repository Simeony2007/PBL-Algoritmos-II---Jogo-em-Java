package scr.view;
import java.util.Scanner;

public class GameInterface {
    private static final Scanner scanner = new Scanner(System.in);

    private GameInterface() {}

    public static String getTextInput() {
        return scanner.nextLine();
    }
    
    public static void showTextLn(String text) {
        System.out.println(text);
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}