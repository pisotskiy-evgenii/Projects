package logicaltasks;

public class LogicalTasks2 {

    public static void main(String[] args) {
        /*
         * В американской армии считается несчастливым число 13, а в японской
         * — 4. Перед международными учениями штаб китайской армии решил
         * исключить номера боевой техники, содержащие числа 4 или 13 (например,
         * 40123, 13313, 12345 или 13040), чтобы не смущать иностранных коллег.
         * Если в распоряжении армии имеется 100 тыс. единиц боевой техники и
         * каждая боевая машина имеет номер от 00001 до 99999, то сколько всего
         * номеров придётся исключить?
         */
        militaryParade(40); // 6
        militaryParade(49); // 15
        militaryParade(94); // 20
        militaryParade(114); // 23
        militaryParade(100000); // 43840

        /*
         * В городе N есть большой склад на котором существует 50000 различных
         * полок. Для удобства работников руководство склада решило заказать для
         * каждой полки табличку с номером от 00001 до 50000 в местной типографии,
         * но когда таблички напечатали, оказалось что печатный станок из-за
         * неисправности не печатал цифру 2, поэтому все таблички, в номерах
         * которых содержалась одна или более двойка (например, 00002 или 20202) —
         * надо перепечатывать. Напишите программу, которая подсчитает сколько
         * всего таких ошибочных табличек оказалось в бракованной партии.
         */
        numberIncorrectNameplates(20); // 3
        numberIncorrectNameplates(29); // 12
        numberIncorrectNameplates(92); // 19
        numberIncorrectNameplates(5000); // 2084

        /*
         * В городе N проезд в трамвае осуществляется по бумажным отрывным
         * билетам. Каждую неделю трамвайное депо заказывает в местной типографии
         * рулон билетов с номерами от 000001 до 999999. «Счастливым» считается
         * билетик у которого сумма первых трёх цифр номера равна сумме последних
         * трёх цифр, как, например, в билетах с номерами 003102 или 567576.
         * Трамвайное депо решило подарить сувенир обладателю каждого счастливого
         * билета и теперь раздумывает, как много сувениров потребуется. С помощью
         * программы подсчитайте сколько счастливых билетов в одном рулоне?
         */
        numberOfHappyTickets(); // 55251

        /*
         * Создайте программу, вычисляющую факториал натурального числа n,
         * которое пользователь введёт с клавиатуры. !5 = 1*2*3*4*5 = 120
         */
        factorial(7); // 1 2 6 24 120 720 5040

        /*
         * Для введённого пользователем с клавиатуры натурального числа
         * посчитайте сумму всех его цифр (заранее не известно сколько цифр будет
         * в числе).
         */
        sumNumbersOfdigit(12345); // 15

        /*
         * Выведети все простые числа
         */
        printPrimes(); //2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

        /*
         * отсортировать массив
         */
        sortArr(new int[]{30, 17, 73, 47, 22, 11, 65, 54}); // 11 17 22 30 47 54 65 73

        /*
         * смещение элементов массива
         */
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 1; i <= 3; i++) {
            shiftElementsInArray(arr);
            /*
                [2, 3, 4, 5, 1]
                [3, 4, 5, 1, 2]
                [4, 5, 1, 2, 3]
             */
        }

        /*
         * 1. Создайте программу, выводящую на экран первые 15 элементов
         * последовательности 2 4 8 16 32 64 128 ….
         */
        sequence1(); // 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384 32768

        /*
         * 2. Написать программу, которая примет значение переменной n, и выведет
         * ряд чисел n, n+3, n+6, n+9, … , n+ 5*3.
         */
        sequence2(2); // 2 5 8 11 14 17
        sequence2(5); // 5 8 11 14 17 20
        sequence2(6); // 6 9 12 15 18 21
        sequence2(7); // 7 10 13 16 19 22

        /*
         * 3. вывести ряд -2, 4, -12, 48, -240, 1440, -10080, 80640
         */
        sequence3();
    }

    private static void militaryParade(int machines) {
        int sum = 0; // sum of the nameplates for change
        for (int i = 1; i <= machines; i++) {
            int temp = i;
            do {
                if (temp % 10 == 4 || temp % 100 == 13) {
                    sum++;
                    break;
                }
                temp /= 10;
            } while (temp != 0);
        }
        System.out.println("Number of machines with 4 and 13 is " + sum);
    }

    private static void numberIncorrectNameplates(int shelves) {
        int sum = 0; // sum of the nameplates for change
        for (int i = 1; i <= shelves; i++) {
            int temp = i;
            do {
                if (temp % 10 == 2) {
                    sum++;
                    break;
                }
                temp /= 10;
            } while (temp != 0);
        }
        System.out.println("Number of shelves with 2 is " + sum);
    }

    private static void numberOfHappyTickets() {
        int sum = 0;
        for (int i = 1001; i < 1000000; i++) {
            int i1 = i / 100000 % 10;
            int i2 = i / 10000 % 10;
            int i3 = i / 1000 % 10;
            int i4 = i / 100 % 10;
            int i5 = i / 10 % 10;
            int i6 = i % 10;
            if ((i1 + i2 + i3) == (i4 + i5 + i6)) {
                sum++;
            }
        }
        System.out.println("Number of happy tickets is " + sum);
    }

    private static void factorial(int number) {
        int result = 1;
        System.out.print("factorial !" + number + " = ");

        if (number == 0) {
            System.out.print(result);
        } else {
            for (int i = 1; i <= number; i++) {
                result *= i;
                System.out.print(result + " ");
            }
        }
        System.out.println();
    }

    private static void sumNumbersOfdigit(int number) {
        int result = 0;
        if (number / 10 == 0) {
            System.out.println("Sum of digits in " + number + " is " + result);
        } else {
            System.out.print("Sum of digits in " + number + " is ");
            do {
                result += (number % 10);
                number /= 10;
            } while (number != 0);
            System.out.println(result);
        }
    }

    private static void printPrimes() {
        int count = 0; // counter of divisors
        for (int i = 2; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i % j == 0)) {
                    count++;
                }
            }
            // Only if there are two divisors, the number is prime
            if (count == 2) {
                System.out.print(i + " ");
            }
            count = 0; // reset counter
        }
        System.out.println();
    }

    private static void sortArr(int[] arr) {
        for (int j = 1; j < arr.length - 1; j++) {
            for (int i = arr.length - 1; i >= j; i--) {
                int temp;
                // change position of values
                if (arr[i] < arr[i - 1]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
        // print sorted array
        for (int temp : arr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    private static void shiftElementsInArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        System.out.println(java.util.Arrays.toString(arr));
    }

    private static void sequence1() {
        System.out.print("1) ");
        final int STOP = 15;
        int start = 2, count = 0;
        do {
            System.out.print(start + " ");
            start *= 2;
            count++;
        } while (count < STOP);
        System.out.println();
    }

    private static void sequence2(int n) {
        System.out.print("2) ");
        int result;
        int end = n + 5 * 3;
        for (int i = 0; ; i += 3) {
            result = (n + i);
            System.out.print(result + " ");
            if (result == end)
                break;
        }
        System.out.println();
    }

    private static void sequence3() {
        System.out.print("3) ");
        int start = -2;
        for (int i = -2; i >= -9; i--) {
            System.out.print(start + ", ");
            start *= i;
        }
        System.out.println();
    }
}
