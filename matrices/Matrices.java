package matrices;

import java.util.Random;

/**
 * Умножение матриц
 * http://mathhelpplanet.com/static.php?p=umnozhenie-matrits на этом сайте
 * также описаны правила: сложение, вычитание, транспонирование и др
 */
public class Matrices {

    // MatrixA * MatrixB = MatrixC
    // columnsA must be equals to rowsB
    // MatrixC has to have columnsB and rowsA
    public static int[][] multipleMatrices(int matrixA[][], int matrixB[][]) {
        int columnsMatrixA = matrixA[0].length;
        int rowsMatrixB = matrixB.length;
        if (columnsMatrixA != rowsMatrixB) return null;

        int rows = matrixA.length;
        int columns = matrixB[0].length;
        int[][] newMatrix = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                for (int p = 0; p < matrixA[r].length; p++) {
                    newMatrix[r][c] += matrixA[r][p] * matrixB[p][c];
                }
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        Random random = new Random();

        // MatrixA * MatrixB = MatrixC
        // columnsA must be equals to rowsB
        // MatrixC has to have columnsB and rowsA
        int rows = 3, columns = 2, p = 4;
        int[][] matrixA = new int[rows][columns];
        int[][] matrixB = new int[columns][p]; // rowsMatrixB must be equal columnsMatrixA

        initializeMatrix(random, matrixA);
        showMatrix(matrixA);
        /*
        1	4
        2	2
        8	1
         */
        initializeMatrix(random, matrixB);
        showMatrix(matrixB);
        /*
        1	0	7	4
        8	3	6	8
         */
        int[][] matrixC = multipleMatrices(matrixA, matrixB); // if (columnsMatrixA != rowsMatrixB) return null;

        if (matrixC == null)
            System.out.println("null");
        else {
            showMatrix(matrixC);
            /*
            33	12	31	36
            18	6	26	24
            16	3	62	40
             */
        }

        /*
         * Поменять местами начальную и последнюю строки и вывести результат на экран
         */
        System.out.println("Swap the first and the last lines");
        if (matrixC == null)
            System.out.println("null");
        else {
            swapLines(matrixC);
            showMatrix(matrixC);
            /*
            16	3	62	40
            18	6	26	24
            33	12	31	36
             */
        }
    }

    private static void initializeMatrix(Random r, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = r.nextInt(10);
            }
        }
    }

    private static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void swapLines(int[][] matrixC) {
        int[] tmp = matrixC[0];
        matrixC[0] = matrixC[matrixC.length - 1];
        matrixC[matrixC.length - 1] = tmp;
    }
}
