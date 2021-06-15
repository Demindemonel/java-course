package fundamentals.optional;

import java.util.Arrays;
import java.util.Random;

public class MatrixRowsSortByColumn {
    public static void main(String[] args) {
        int matrixDimension = 3;

        int[][] array = new int[matrixDimension][matrixDimension];
        int min = -10;
        int max = 10;
        Random r = new Random();
        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                array[i][j] = r.nextInt(max - min) + min;
            }
        }

        PrintArray(array);

        int columnForSort = 1;
        for (int i = 0; i < matrixDimension; i++) {
            for (int u = i + 1; u < matrixDimension; u++) {
                if (array[i][columnForSort] > array[u][columnForSort]) {
                    for (int j = 0; j < matrixDimension; j++) {
                        int tmp = array[i][j];
                        array[i][j] = array[u][j];
                        array[u][j] = tmp;
                    }
                }
            }
        }

        PrintArray(array);
    }

    private static void PrintArray(int[][] array) {
        for (int[] i : array) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }
}
