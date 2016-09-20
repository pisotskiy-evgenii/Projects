package randomchars;

/**
 * Tasks: Invert strings or words
 */

public class InvertString {
    //test method
    public static void main(String[] args) {
        String in1 = "input string";
        String in2 = "input string to the method test2";

        System.out.println(invertString(in1)); // output: gnirts tupni
        System.out.println(invertOnlyWords(in2)); // output: tupni gnirts ot eht dohtem 2tset

        System.out.println("String has " + countTarget(in2, 't') + " symbol t"); // output: String has 7 symbol t
    }

    private static String invertString(final String in) {
        char[] ch = in.toCharArray();
        String result = new String();
        for (int i = ch.length - 1; i >= 0; i--) {
            result += ch[i];
        }
        return result;
    }

    private static String invertOnlyWords(final String in) {
        String[] temp = in.split(" ");
        String result = new String();
        for (int i = 0; i < temp.length; i++) {
            if (i != temp.length - 1) {
                result += invertString(temp[i]) + " ";
            } else {
                result += invertString(temp[i]);
            }
        }
        return result;
    }

    private static int countTarget(final String in, final char target) {
        char[] ch = in.toCharArray();
        int count = 0;
        for (char ch2 : ch) {
            if (ch2 == target) {
                count++;
            }
        }
        return count;
    }
}
