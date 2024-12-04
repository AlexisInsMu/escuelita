import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        while (!in.hasNextInt()) in.nextLine();
        num = in.nextInt();
    }
}
