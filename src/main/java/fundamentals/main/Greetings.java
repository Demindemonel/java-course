package fundamentals.main;

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = null;

        while (!"exit".equals(username)) {
            System.out.print("Enter your name: ");
            username = scanner.nextLine();
            if (!username.equals("exit")) System.out.println("Hello," + username);
        }
    }
}