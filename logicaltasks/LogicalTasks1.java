package logicaltasks;

public class LogicalTasks1 {
    public static void main(String[] args) {
        /*
         * Написать программу, позволяющую переводить любое число из
         * десятичной системы счисления в 2, 8 и 16-ричную систему.
         */
        toHexadecimal(9);  // 0x9
        toHexadecimal(10); // 0xA
        toHexadecimal(15); // 0xF
        toHexadecimal(16); // 0x10
        toHexadecimal(17); // 0x11
        toHexadecimal(266);// 0x10A

        toOctal(7); // 07
        toOctal(8); // 010
        toOctal(49); // 061
        toOctal(65); // 0101

        toBinary(1); // 00000000000000000000000000000001
        toBinary(-1); // 11111111111111111111111111111111
        toBinary(7); // 000000000000000000000000 0000 0111
        toBinary(-7); //111111111111111111111111 1111 1001

        /*
         * Определить, является ли число простым.
         * Простое число делится без остатка только на 1 и само на себя.
         */
        System.out.println(isPrime(19)); // true
        System.out.println(isPrime(29)); // true
        System.out.println(isPrime(15)); // false
        System.out.println(isPrime(48)); // false

        /*
         * Необходимо перевернуть числою. Цифры должны располагаться в обратном порядке
         * (например, вводим число 1234 – в результате будет 4321).
         */
        revertDigit(123456789); // 987654321
        revertDigit(82739); // 93728

        /*
         * Проверить, что все цифры числа расположены в возрастающем порядке
         * (например, число 11299 соответствует заданию, а число 22044 нет).
         */
        System.out.println(isGrowing(22044)); // false
        System.out.println(isGrowing(1114445999)); // true

        /*
         * Определить количество цифр в числе и их сумму.
         */
        numberOfDigit(2003010); // Number of digits of 2003000 is 7 sum is 6
        numberOfDigit(231); // Number of digits of 231 is 3 sum is 6
    }

    private static void toHexadecimal(int number) {
        System.out.print(number + " in hexadecimal is ");
        String sHex = "";
        do {
            int temp = number % 16;
            if (temp >= 10 & temp <= 15) {
                switch (temp) {
                    case 10:
                        sHex = "A" + sHex;
                        break;
                    case 11:
                        sHex = "B" + sHex;
                        break;
                    case 12:
                        sHex = "C" + sHex;
                        break;
                    case 13:
                        sHex = "D" + sHex;
                        break;
                    case 14:
                        sHex = "E" + sHex;
                        break;
                    case 15:
                        sHex = "F" + sHex;
                        break;
                }
            } else {
                sHex = temp + sHex;
            }
            number /= 16;
        } while (number != 0);
        sHex = "0x" + sHex;
        System.out.println(sHex);
    }

    private static void toOctal(int number) {
        System.out.print(number + " in octal is ");
        String sOctal = "";
        do {
            int temp = number % 8;
            sOctal = temp + sOctal;
            number /= 8;
        } while (number != 0);
        sOctal = "0" + sOctal;
        System.out.println(sOctal);
    }

    private static void toBinary(int number) {
        System.out.print(number + " in binary is ");
        String sBinary = "";
        for (int i = (int) Math.pow(-2, 31); i != 0; i >>>= 1) {
            sBinary += ((number & i) == i) ? 1 : 0;
        }
        System.out.println(sBinary);
    }

    private static boolean isPrime(int number) {
        int i;
        for (i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void revertDigit(int number) {
        int count = 0, temp;
        temp = number;
        do {
            temp /= 10;
            count++; // a number of digits
        } while (temp != 0);

        do {
            temp += (number % 10) * (int) Math.pow(10, --count);
            number /= 10;
        } while (number != 0);
        System.out.println(temp);
    }

    private static boolean isGrowing(long number) {
        do {
            if (number % 10 < number % 100 / 10) {
                return false;
            }
            number /= 10;
        } while (number != 0);
        return true;
    }

    private static void numberOfDigit(long number) {
        long sum = 0, count = 0;
        System.out.print("Number of digits in " + number + " is ");
        do {
            sum += number % 10;
            number /= 10;
            count++;
        } while (number != 0);
        System.out.println(count + " sum is " + sum);
    }
}
