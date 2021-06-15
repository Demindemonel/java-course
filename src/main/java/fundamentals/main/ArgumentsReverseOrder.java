package fundamentals.main;

import java.util.Scanner;

public class ArgumentsReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string for reverse");
        StringBuilder stringBuffer = new StringBuilder(scanner.nextLine());
        stringBuffer.reverse();
        System.out.println(stringBuffer.toString());
    }
}
