package logicaltasks;

/*
 * Найти максимальный полиндром при перемножении двух трех значных чисел. Пример
 * полиндрома: 121, 1221, 1111, 15151, 15020002051 (в обе стороны)
 */

/**
 * There is a main method
 * <code>
 *     boolean isPalindrome(int num){...}
 * <code/>
 *
 * which defines if the number is a palindrome.
 */
public class Palindrome {

	private static final int MIN_MULTIPLIER = 100;
	private static final int MAX_MULTIPLIER = 999;

	public static void main(String[] args) {
		maxPalindrome(MIN_MULTIPLIER, MAX_MULTIPLIER);
	}

	/**
	 * Computes the maximum palindrome
	 *
	 * @param MIN_MULTIPLIER minimum multiplier
	 * @param MAX_MULTIPLIER maximum multiplier
	 */
	public static void maxPalindrome(int MIN_MULTIPLIER, int MAX_MULTIPLIER) {
		int max_palindrome = 0;
		int iterations = 0;
		int countPalindrome = 0;

		for(int i = MAX_MULTIPLIER; i >= MIN_MULTIPLIER; i--) {
			iterations++;

			for(int j = MAX_MULTIPLIER; j >= i; j--)
			{
				iterations++;
				if(i * j < max_palindrome) break;

				//System.out.println("iter: " + i + "*" + j + " = " + (i * j));
				if(isPalindrome(i * j)) {
					countPalindrome++;
					System.out.println("-----------" + i + "*" + j + " = " + (i * j)); // 888888, 906609
					if(i * j > max_palindrome) max_palindrome = i * j;
					break;
				}
			}
		}
		System.out.println("max = " + max_palindrome); // max = 906609
		System.out.println("palindromes = " + countPalindrome); // palindromes = 2
		System.out.println("iterations = " + iterations); // iterations = 4948
	}

	/**
	 * Checks whether integer is a palindrome
	 *
	 * @param num
	 *           integer for checking
	 * @return true if integer is a palindrome
	 *
	 */

	public static boolean isPalindrome(int num) {
		int size = 0;

		int tmp = num;
		do {
			tmp /= 10;
			size++;
		} while(tmp != 0);

		int[] arr = new int[size];

		for(int i = 0; i < size; i++) {
			arr[i] = num % 10;
			num /= 10;
		}

		for(int i = 0; i < size / 2; i++) {
			if(arr[i] != arr[size - 1 - i]) return false;
		}
		return true;
	}
}
