package randomchars;

/**
 * FROM http://www.itmathrepetitor.ru/prog/zadachi-na-vychisleniya/
 * <p>
 * 1) Вывести квадрат 7 на 7 из случайных букв.
 * 2) Вывести англ. алфавит по 5 букв в строке.
 */
public class RandCharSquare {
    private static final int SIZE_SQUARE = 7;
    private static final int START = 1;

    public static void main(String[] args) {
        /* Вывести квадрат 7 на 7 из случайных букв. */
        for (int i = START; i <= SIZE_SQUARE; i++) {
            for (int j = START; j <= SIZE_SQUARE; j++) {
                System.out.print(getRandChar() + " ");
            }
            System.out.println();
        }
        System.out.println();


		/* Вывести англ. алфавит по 5 букв в строке. */
        int lengthStr = 5;
        int next = 65;
        int finish = 90;
        out:
        while (true) {
            for (int i = 1; i <= lengthStr; i++) {
                if ('A' <= nextChar(next) & nextChar(next) <= 'Z') {
                    System.out.print(nextChar(next) + " ");
                }
                next++;
                if (next >= finish) {
                    break out;
                }
            }
            System.out.println();
        }
    }

    private static char getRandChar() {
        return (char) (int) (65 + Math.random() * 26);
    }

    private static char nextChar(int next) {
        return (char) next;
    }
}
