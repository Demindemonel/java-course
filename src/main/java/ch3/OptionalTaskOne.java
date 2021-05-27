package ch3;

import java.util.Scanner;

public class OptionalTaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers count: ");
        int numbersCount = scanner.nextInt();
        int[] array = new int[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            System.out.println("\r\nEnter number " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        for (int number : array
        ) {
            if (isOrdered(number)) {
                System.out.println("Ordered number is " + number);
                return;
            }
        }

    }

    public static boolean isOrdered(int number) {
        int tmp = number % 10;
        number /= 10;
        while (number != 0) {
            if (tmp <= number % 10) return false;
            tmp = number % 10;
            number /= 10;
        }
        return true;
    }


}
