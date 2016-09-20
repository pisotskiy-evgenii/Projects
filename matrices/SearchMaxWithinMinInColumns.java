package matrices;

import java.util.Random;

/**
 * Searching a maximum element between minimum elements within columns
 */
public class SearchMaxWithinMinInColumns {

    /**
     * Searching a maximum element between minimum elements within columns
     *
     * @param matrix the matrix
     * @return max element
     */
    public static int searchMaxWithinMinInColumns(int[][] matrix) {
        int[] arrOfmin = new int[matrix[0].length]; // array for min elements in columns
        int max;
        for (int i = 0; i < matrix[0].length; i++) {
            arrOfmin[i] = matrix[0][i]; // the first min element in column

            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] < arrOfmin[i]) arrOfmin[i] = matrix[j][i];
            }
        }

        max = arrOfmin[0]; // the first max element in array of min elements
        for (int i = 1; i < arrOfmin.length; i++) {
            max = Math.max(max, arrOfmin[i]);
        }
        System.out.println("Array of minimum elements: ");
        showArray(arrOfmin);
        return max;
    }

    public static void main(String[] args) {
        int rows = 4, columns = 5;
        int[][] arr = new int[rows][columns];

        fillMatrixRandomly(arr);
        showMatrix(arr);
        /*
        45	78	95	93	78
        81	72	65	63	33
        36	21	24	77	15
        37	50	13	75	76
         */
        int i = searchMaxWithinMinInColumns(arr);
        System.out.println("Max element: " + i);
        /*
        Array of minimum elements:
        36	21	13	63	15
        Max element: 63
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

    /**
     * Show array of minimum elements within columns in matrix
     *
     * @param arr the array
     */
    private static void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
