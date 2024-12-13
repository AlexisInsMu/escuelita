package utils;

public class TerminalUtils {
    public static void clearTerminal() {
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                System.err.println("An error occurred while trying to clear the terminal: " + e.getMessage());
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}