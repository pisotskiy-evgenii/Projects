package logicaltasks;

import java.util.Arrays;

public class LogicalTasks3 {

    public static void main(String[] args) {

        double[] arr = {13, -28, 2.3, 100.95, 504.2, 52, -526.2, -1001};
        /*
         * Сформировать массив из четных чисел
         */
        double[] tmp = takeEvenNumbers(arr);
        System.out.println(Arrays.toString(tmp)); // [-28.0, 52.0]

        /*
         * В массиве найти максимальный элемент и его номер.
         */
        maxElementAndPosition(arr); // Max element of array is arr[4] = 504.2 in position 5

        /*
         * вывести числа фибоначи 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
         */
        fibonacci(16); // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610

    }

    private static double[] takeEvenNumbers(double[] arr) {
        int count = 0; // counts sum of even numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        if (count == 0)
            return new double[count];
        else {
            double[] tmp = new double[count]; // array for even numbers
            count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    tmp[count] = arr[i];
                    count++;
                }
            }
            return tmp;
        }
    }

    private static void maxElementAndPosition(double[] arr) {
        int index = 0;
        double max = arr[index]; // the first max element
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > max) {
                max = arr[i + 1];
                index = i + 1;
            }
        }
        System.out.println("Max element into array is arr[" + index + "] = "
                + max + " in position " + (index + 1));
    }

    private static void fibonacci(int howMany) {
        int f1 = 0, f2 = 1, result;
        if (howMany == 1) {
            System.out.println("fibonacci: " + f1);
        } else if (howMany >= 2) {
            System.out.print("fibonacci: " + f1 + " " + f2);
            for (int nextF = 3; nextF <= howMany; nextF++) {
                result = f1 + f2;
                System.out.print(" " + result);
                f1 = f2;
                f2 = result;
            }
            System.out.println();
        }
    }
}
