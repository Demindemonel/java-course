package sandbox;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(isSameNumbers(number));
    }

    public static int isSameNumbers(int number) {
        int tmp = number % 10;
        number /= 10;
        if (number == 0) return tmp;
        if (tmp != isSameNumbers(number)) return -1;
        return number;
    }
}
