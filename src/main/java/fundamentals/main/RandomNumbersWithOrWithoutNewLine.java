package fundamentals.main;

import java.util.Scanner;

public class RandomNumbersWithOrWithoutNewLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter count of numbers: ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                System.out.println(Math.random() + " ");
            } else {
                System.out.print(Math.random() + " ");
            }
        }
    }
}
