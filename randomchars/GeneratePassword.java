package randomchars;

/**
 * <pre>
 * 150.Сгенерировать пароль для пользователя.
 * Требования: длина от 6 до 20 символов, должен быть ровно один символ
 * подчеркивания, хотя бы две заглавных буквы, не более 5 цифр, любые две
 * цифры подряд недопустимы.
 * Источник: http://www.itmathrepetitor.ru/prog/zadachi-na-vychisleniya/
 * </pre>
 */
public class GeneratePassword {

    // tests method
    public static void main(String... args) {
        System.out.println("first random: ");
        String password;

        long start = System.currentTimeMillis();
        password = new GeneratePassword().getPassword();
        long stop = System.currentTimeMillis();

        System.out.println("\nyour password: \n\n" + password + "\n");// exp: G02eG_m7b / U8_a35zHaZ / i23DL_o1i
        System.out.println("password length " + password.length());
        System.out.println((stop - start) + "mls");
    }

    /////////////////////////////////////////
    private static char[] symbols;
    private static final int MAX_LENGTH = 20;
    private static final int MIN_LENGTH = 6;
    private static final int LENGTH = 8;

    /**
     * Overload method.
     * <p>
     * Generating random password
     *
     * @param length the length of password. Length must be from 6 to 20 inclusive. There is the inspection
     * @return random password
     */
    public String getPassword(int length) {
        if (checkLengthPassword(length)) {
            if (isShort(length)) {
                setShortPassword(length);
            } else {
                setShortPassword(LENGTH);
                symbols = extendPassword(length);
            }
            return covertToString();
        } else {
            return "error. \nPassword length must be from 6 to 20 random chars";
        }
    }

    /**
     * Overload method.
     * <p>
     * Generating random password, length from 6 to 20 inclusive
     *
     * @return password
     */
    public String getPassword() {
        int length = setRandomLenPass();
        return getPassword(length);
    }

    private static int setRandomLenPass() {
        int length = 6 + (int) (Math.random() * 4);
        return length + (int) (Math.random() * 10)
                + (int) (Math.random() * 3);
    }

    private static String covertToString() {
        String password = "";
        for (char symbol : symbols) {
            password += symbol;
        }
        return password;
    }

    private static char[] extendPassword(int length) {
        char[] newSymbols = new char[length];
        System.arraycopy(symbols, 0, newSymbols, 0, symbols.length);
        for (int i = 8; i < length; i++) {
            if (i % 3 == 0) {
                newSymbols[i] = setCapitalLetter();
            } else if (i % 5 == 0) {
                newSymbols[i] = setSpecialSymbol();
            } else if (i % 2 == 0) {
                newSymbols[i] = setLetter();
            } else {
                newSymbols[i] = setSpecialSymbol();
            }
        }
        return newSymbols;
    }

    private static void setShortPassword(int length) {
        symbols = new char[length];

        for (int i = 0; i < symbols.length; i++) {
            if (length > MIN_LENGTH & (i % 3 == 0)) {
                symbols[i] = setLetter();
            } else {
                symbols[i] = setDigital();
            }
            System.out.print(symbols[i] + " ");
        }
        changeDoubleDigitalToLowLetter();
        addTwoUpperLetter();
        addUnderscore();
    }

    private static void changeDoubleDigitalToLowLetter() {
        char tempSymbol = symbols[0];
        for (int i = 1; i < symbols.length; i++) {
            if (tempSymbol == symbols[i]) {
                tempSymbol = symbols[i];
                symbols[i] = setSpecialSymbol();
            } else {
                tempSymbol = symbols[i];
            }
        }
    }

    private static int setPosition() {
        return (int) (Math.random() * symbols.length);
    }

    private static void addTwoUpperLetter() {
        int position;
        int count = 0;
        while (true) {
            position = setPosition();
            if ((symbols[position] >= 'A' & symbols[position] <= 'Z'))
                continue;
            else {
                symbols[position] = setCapitalLetter();
                count++;
                if (count == 2) {
                    return;
                }
            }
        }
    }

    private static void addUnderscore() {
        int position;
        while (true) {
            position = setPosition();
            if (symbols[position] < 'A' || symbols[position] > 'Z') {
                symbols[position] = '_';
                return;
            }
        }
    }

    private static char setDigital() {
        return (char) (48 + (int) (Math.random() * 10));
    }

    private static char setSpecialSymbol() {
        return (char) (33 + (int) (Math.random() * 15));
    }

    private static char setLetter() {
        return (char) (97 + (int) (Math.random() * 26));
    }

    private static char setCapitalLetter() {
        return (char) (65 + (int) (Math.random() * 26));
    }

    private static boolean checkLengthPassword(int length) {
        if (length >= MIN_LENGTH & length <= MAX_LENGTH)
            return true;
        else
            return false;
    }

    private static boolean isShort(int length) {
        return length >= MIN_LENGTH & length <= LENGTH;
    }


}
