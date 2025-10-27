package Lessen_2_13;

public class Main {
    public static void main(String[] args) {
        int size = 5;
        int[][] matrix = new int[size][size];

           for (int i = 0; i < size; i++) {
               matrix[i][i] = 1;
               matrix[i][size - 1 - i] = 1;
        }

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
