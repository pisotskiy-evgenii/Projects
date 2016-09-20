package matrices;

import java.util.Random;

public class TransposeMatrix {

    /**
     * Transpose matrix
     *
     * @param matrix the matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < transposedMatrix.length; i++) {
            for (int j = 0; j < transposedMatrix[i].length; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    public static void main(String[] args) {
        int rows = 5, columns = 3;
        int[][] matrix = new int[rows][columns];

        fillMatrixRandomly(matrix);

        System.out.println("Show random matrix: ");
        showMatrix(matrix);
       /*
Show random matrix:
82	17	95
97	59	49
52	13	26
78	68	57
52	68	19
        */
        matrix = transposeMatrix(matrix);

        System.out.println("Transposed matrix: ");
        showMatrix(matrix);
        /*
Transposed matrix:
82	97	52	78	52
17	59	13	68	68
95	49	26	57	19
        */
    }

    /**
     * Fill matrix by random values
     *
     * @param matrix the empty matrix
     */
    private static void fillMatrixRandomly(int[][] matrix) {
        Random r = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 10 + r.nextInt(90);
            }
        }
    }

    /**
     * Show matrix
     *
     * @param matrix the matrix
     */
    private static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
