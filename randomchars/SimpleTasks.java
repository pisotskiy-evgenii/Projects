package randomchars;

import java.io.IOException;

public class SimpleTasks {

    public static void main(String[] args) throws IOException {

        // Вывести на экран произведение чисел от 1 до 10
        int result = 1;
        for (int i = 1; i <= 10; i++) {
            result = result * i;
        }
        System.out.println(result + "\n");  // 3628800

        //Вывести на экран сумму чисел от 1 до 10 построчно
        int SumNumber = 0;
        for (int i = 1; i <= 10; i++) {
            SumNumber = SumNumber + i;
        }
        System.out.print(SumNumber + " "); // 55
        System.out.println("\n");

        // вывод таблицы умножения
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
        /*
1	2	3	4	5	6	7	8	9	10
2	4	6	8	10	12	14	16	18	20
3	6	9	12	15	18	21	24	27	30
4	8	12	16	20	24	28	32	36	40
5	10	15	20	25	30	35	40	45	50
6	12	18	24	30	36	42	48	54	60
7	14	21	28	35	42	49	56	63	70
8	16	24	32	40	48	56	64	72	80
9	18	27	36	45	54	63	72	81	90
10	20	30	40	50	60	70	80	90	100
         */

        // вывод строк из массива строк
        System.out.println();
        String[] colors = {"red", "orange", "yellow", "green", "blue",
                "navy blue", "purple"};
        for (int i = 0; i < colors.length; i++) {
            System.out.print(colors[i] + " ");
            if (i != 0 & i % 3 == 0) {
                System.out.println("");
            }
        }
        /*
red orange yellow green
blue navy blue purple
         */
    }
}
