package randomchars;

/**
 * Данна строка, в которой слова разделены пробелами. Написать код
 * упорядычивающий слова в порядке убывания их длинны
 */
public class SortString {

    public static void main(String[] args) {
        String string = "a dddd bb jj ccc eeeee";
        String[] str1 = string.split(" ");
        String[] strTemp = new String[str1.length];

        System.out.println(string); // a dddd bb jj ccc eeeee

        sortWords(str1, strTemp);
        printSortedWords(str1);  // eeeee dddd ccc bb jj a
    }

    private static void sortWords(String[] arr, String[] tempArr) {
        outer:
        for (; ; ) {
            int count = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].length() < arr[i + 1].length()) {
                    tempArr[i] = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tempArr[i];
                } else {
                    count++;
                    if (count == arr.length - 1) {
                        break outer;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private static void printSortedWords(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
