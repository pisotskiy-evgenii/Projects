package logicaltasks;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Дано натуральное число n. Выведите все правильные скобочные последовательности,
 * состоящие из n открывающихся круглых скобок и n закрывающихся круглых скобок
 * в лексикографическом порядке.
 */

public class Parentheses {

    // ArrayList collects the correct sequence of parentheses
    private static ArrayList<String> correctSeqParentheses = new ArrayList<>();

    public static void main(String... args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Please, type amount of pairs parentheses: ");

        int pairsParentheses = reader.nextInt(); // for example was typed - 3
        reader.close();

        int sum = sumCorrectSequences(pairsParentheses);
        System.out.println("Amount of correct sequences parentheses is " + sum); // 5

        printCorrectSequence();
        /*
()()()
()(())
(())()
(()())
((()))
         */
    }

    /**
     * Computes the sum of the correct sequences parentheses
     *
     * @param pair amount of pairs parentheses
     * @return the sum of the correct sequences parentheses
     */
    private static int sumCorrectSequences(int pair) {
        if (pair == 0) {
            return 0;
        } else if (pair < 0) {
            throw new IllegalArgumentException("Illegal pair " + pair);
        }

        int sum = 0;
        int amountParentheses = pair * 2;
        long combinations = sumCombinations(amountParentheses);

        char[] seqParentheses;

        for (long index = 0; index < combinations; index++) {
            seqParentheses = nextSequence(combinations, index, amountParentheses);

            if (isCorrectSequence(seqParentheses)) {
                correctSeqParentheses.add(new String(seqParentheses));
                sum++;
            }
        }
        return sum;
    }

    /**
     * Computes the sum of all combinations of sequences parentheses (correct and wrong)
     *
     * @param amountParentheses amount parentheses
     * @return the sum of all combinations of sequences parentheses
     */
    private static long sumCombinations(long amountParentheses) {
        int base = 2;
        if (amountParentheses == 0) return 1;
        return base * sumCombinations(amountParentheses - 1);
    }

    /**
     * Creates all combinations of a sequence parentheses
     *
     * @param combinations      the sum of all combinations of sequences parentheses (correct and wrong)
     * @param item              index of parenthesis in sequence
     * @param amountParentheses amount parentheses
     * @return combination of a sequence parentheses
     */
    private static char[] nextSequence(long combinations, long item, int amountParentheses) {
        char[] seqParentheses = new char[amountParentheses];
        int index = -1;
        long bits = combinations >> 1;

        while (bits != 0) {
            index++;
            if ((item & bits) == 0) {
                seqParentheses[index] = ')';
            } else {
                seqParentheses[index] = '(';
            }
            bits >>= 1;
        }
        return seqParentheses;
    }

    /**
     * Checks the sequence of parentheses
     *
     * @param seqParentheses sequence of parentheses
     * @return true, if the sequence is correct
     */
    private static boolean isCorrectSequence(char[] seqParentheses) {
        int markCorrect = 0;
        for (char parenthesis : seqParentheses) {
            if (parenthesis == '(') {
                markCorrect++;
            } else {
                markCorrect--;
            }
            if (markCorrect < 0) {
                return false;
            }
        }
        if (markCorrect == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Shows all correct sequences of parentheses
     */
    private static void printCorrectSequence() {
        for (String str : correctSeqParentheses) {
            System.out.println(str);
        }
    }
}
