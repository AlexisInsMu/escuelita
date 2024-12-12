package utils;

import java.io.IOException;

public class TerminalUtils {
    public static void clearTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("The thread was interrupted while waiting for the terminal to clear: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An I/O error occurred while trying to clear the terminal: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while trying to clear the terminal: " + e.getMessage());
        }
    }
}