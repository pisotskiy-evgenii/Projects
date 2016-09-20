package randomchars;

/**
 * <pre>
 * Сгенерируйте строку символов длины от 3 до 10, в которой ровно 2 символа "!".
 * Источник: http://www.itmathrepetitor.ru/prog/zadachi-na-vychisleniya/
 * </pre>
 */
public class RandomString {
    //test method
    public static void main(String[] args) {
        String line = new RandomString().getRandomLine(); // or you can set any length

        System.out.println(line); // example: !C81! / !8uj'#!c / tv!NsAY!}S
        System.out.println("length " + line.length());
    }

    ///////////////////////////////////////////////////////
    private final char specialSymbol = '!';

    /* Overload method for the random string with length from 3 to 10 random chars inclusive */
    public String getRandomLine() {
        int lengthLine = setRandomLength();
        return getRandomLine(lengthLine);
    }

    /* Overload method for the random string with set up length*/
    public String getRandomLine(int len) {
        char[] randomChars = setArrayRandomChars(len);
        changeAnyTwoCharFor(specialSymbol, randomChars);
        return getLine(randomChars);
    }

    private String getLine(char[] arrChars) {
        String line = "";
        for (char ch : arrChars) {
            line += ch;
        }
        return line;
    }

    private void changeAnyTwoCharFor(char symbol, char[] arrChars) {
        int position;
        int count = countSpecialSymbol(symbol, arrChars);
        System.out.println(count);
        while (count < 2) {
            position = getPosition(arrChars.length);
            if (arrChars[position] != symbol) {
                arrChars[position] = symbol;
                count++;
            }
        }
    }

    private int countSpecialSymbol(char symbol, char[] arrChars) {
        int count = 0;
        for (char c : arrChars) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }

    private char[] setArrayRandomChars(int len) {
        char[] randomChar = new char[len];
        for (int i = 0; i < len; i++) {
            randomChar[i] = getChar();
        }
        return randomChar;
    }

    private int getPosition(int len) {
        return (int) (Math.random() * len);
    }

    private char getChar() {
        return (char) (33 + (int) (Math.random() * 94));
    }

    private int setRandomLength() {
        return 3 + (int) (Math.random() * 8);
    }
}
