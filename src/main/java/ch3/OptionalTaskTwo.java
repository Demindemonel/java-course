package ch3;

import java.util.Arrays;
import java.util.Random;

public class OptionalTaskTwo {
    public static void main(String[] args) {
        int n = 3;

        int[][] a = new int[n][n];
        int min = -10;
        int max = 10;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = r.nextInt(max - min) + min;
            }
        }

        for (int[] i :
                a) {
            System.out.println(Arrays.toString(i));
        }

        //ABS сортировка по второму столбцу
        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int u = i + 1; u < n; u++) {
                if (a[i][k] > a[u][k]) {
                    for (int j = 0; j < n; j++) {
                        int tmp = a[i][j];
                        a[i][j] = a[u][j];
                        a[u][j] = tmp;
                    }
                }
            }
        }
//        for (int[] i :
//                a) {
//            for (int j :
//                    i) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }
        for (int[] i :
                a) {
            System.out.println(Arrays.toString(i));
        }
    }

}
