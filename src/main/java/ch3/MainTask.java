package ch3;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        //1
//        String username = "";
//        boolean exit = false;
//        while (!exit) {
//            System.out.print("Enter your name: ");
//            username = scanner.nextLine();
//            if (username.equals("exit")) {
//                exit = true;
//            } else {
//                System.out.println("Hello," + username);
//            }
//        }

//
//        //2
//        System.out.println("Enter string for reverse");
//        StringBuffer stringBuffer = new StringBuffer(scanner.nextLine());
//        stringBuffer.reverse();
//        System.out.println(stringBuffer.toString());

//
//        //3
//        System.out.println("Enter count of numbers: ");
//        int count = scanner.nextInt();
//        for (int i = 0; i < count; i++) {
//            if (i % 2 == 0) {
//                System.out.println(Math.random() + " ");
//            } else {
//                System.out.print(Math.random() + " ");
//            }
//        }

//
//        //4
//        System.out.println("Enter first number");
//        int a = scanner.nextInt();
//
//        System.out.println("Enter second number");
//        int b = scanner.nextInt();
//
//        System.out.println("Sum = " + (a + b));
//        System.out.println("Mult = " + (a * b));

//
//        //5
//        boolean quit = false;
//        int month;
//        while (!quit) {
//            System.out.print("Enter month number: ");
//            month = scanner.nextInt();
//            if (!(month <= 12 && month >= 1)) {
//                System.out.println("Wrong month!");
//            } else {
//                switch (month) {
//                    case 1:
//                        System.out.println("January");
//                        break;
//                    case 2:
//                        System.out.println("February");
//                        break;
//                    case 3:
//                        System.out.println("March");
//                        break;
//                    case 4:
//                        System.out.println("April");
//                        break;
//                    case 5:
//                        System.out.println("May");
//                        break;
//                    case 6:
//                        System.out.println("June");
//                        break;
//                    case 7:
//                        System.out.println("July");
//                        break;
//                    case 8:
//                        System.out.println("August");
//                        break;
//                    case 9:
//                        System.out.println("September");
//                        break;
//                    case 10:
//                        System.out.println("October");
//                        break;
//                    case 11:
//                        System.out.println("November");
//                        break;
//                    case 12:
//                        System.out.println("December");
//                        break;
//                    default:
//                        System.out.println("HOW?!");
//                        break;
//                }
//                quit = true;
//            }
//        }

    }

}