package dev.clacrone.interview.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasicQuestions {

	public static Map<Integer, Integer> fibMemMap = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> factMemMap = new HashMap<Integer, Integer>();

	/**
	 * num = (num-1) + (num-2)
	 * 
	 * fib(0) = 0
	 * fib(1) = 1
	 * fib(2) = 1
	 * fib(3) = 2
	 * fib(4) = 3
	 * fib(5) = 5
	 * fib(6) = 8
	 * fib(7) = 13
	 * fib(8) = 21
	 * fib(9) = 34
	 * fib(10) = 55 
	 */
	public static int fibonacci(int num) {
		if (num <= 1) {
			return num;
		}

		return fibonacci(num - 1) + fibonacci(num - 2);
	}

	public static int fibMem(int num) {
		if (num <= 1) {
			return num;
		}
		if (fibMemMap.containsKey(num)) {
			return fibMemMap.get(num);
		} else {
			fibMemMap.put(num, fibMem(num - 1) + fibMem(num - 2));
		}
		return fibMemMap.get(num);
	}

	
	/**
	 * num = num * fact(num-1)
	 * 
	 * fib(0) = 1
	 * fib(1) = 1
	 * fib(2) = 2
	 * fib(3) = 6
	 * fib(4) = 24
	 * fib(5) = 120
	 * fib(6) = 720
	 * fib(7) = 5040
	 * fib(8) = 40320
	 * fib(9) = 362880
	 * fib(10) = 3628800
	 */
	public static int factorial(int num) {
		if (num <= 1) {
			return 1;
		}

		return num * factorial(num - 1);
	}

	public static int factMem(int num) {
		if (num <= 1) {
			return 1;
		}
		if (factMemMap.containsKey(num)) {
			return factMemMap.get(num);
		} else {
			factMemMap.put(num, num * factMem(num - 1));
		}
		return factMemMap.get(num);
	}
	
	/**
	 * Given a number, returns the ordinal.
	 * Input: 2
	 * Returns: 2nd
	 */
	public static String ordinal(int num) {
		String ordinal = num + "";
		if (num % 100 == 11 || num % 100 == 12 || num % 100 == 13) {
			ordinal += "th";
		} else {
			switch (num % 10) {
			case 1:
				ordinal += "st";
				break;
			case 2:
				ordinal += "nd";
				break;
			case 3:
				ordinal += "rd";
				break;
			default:
				ordinal += "th";
				break;
			}
		}

		return ordinal;
	}

	/**
	 * Given an hour and minute, return the angle in degrees.
	 * Clock has 360 degrees.
	 * 12 hours * 60 = 720 mins = 0.5 degree per minute
	 * 60 mins = 6 degrees per minute
	 * @param hour
	 * @param min
	 * @return
	 */
	public static double clockAngle(int hour, int min) {
		double minAngle = 360 / 60;
		double hourAngle = 0.5 * (hour * 60 + min);
		double totalAngle = Math.abs(hourAngle - minAngle);
		totalAngle = Math.min(totalAngle, 360 - totalAngle);
		return totalAngle;
	}

	/**
	 * Convert a string with underscores to camel case
	 * my_name_is_craig convert to myNameIsCraig
	 * @param str
	 * @return
	 */
	public static String camelCase(String str) {
		if (str == null) {
			return null;
		}
		boolean caps = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '_') {
				caps = true;
			} else {
				if (caps) {
					sb.append(str.toUpperCase().charAt(i));
					caps = false;
				} else {
					sb.append(str.charAt(i));
				}
			}
		}

		if (sb.length() > 0) {
			sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
		}

		return sb.toString();
	}

	/**
	 * Given an array of unsigned integers and a sum,
	 * return the indices of 2 numbers that add to sum
	 * @param arr
	 * @param sum
	 * @return
	 */
	public static int[] addToSum(int[] arr, int sum) {
		if (arr == null || arr.length < 2) {
			return new int[] { -1, -1 };
		}
		
		Map<Integer, Integer> pairsMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			int complement = sum - arr[i];
			if (pairsMap.containsKey(complement)) {
				return new int[] { pairsMap.get(complement), i };
			}

			pairsMap.put(arr[i], i);
		}

		return new int[] { -1, -1 };
	}

	
	/**
	 * Given a string determine whether it has all unique chars
	 * @param str
	 * @return
	 */
	public static boolean isUnique(String str) {
		if (str.length() > 256) {
			return false;
		}

		boolean[] letters = new boolean[256];
		Arrays.fill(letters, false);

		for (int i = 0; i < str.length(); i++) {
			if (letters[str.charAt(i)]) {
				return false;
			}
			letters[str.charAt(i)] = true;
		}

		return true;
	}

	/**
	 * Given 2 strings determine if one is the permutation of another
	 * Permutation: Has all the same characters but in a different order
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutation(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}

		int[] letters = new int[256];
		Arrays.fill(letters, 0);

		for (int i = 0; i < s1.length(); i++) {
			letters[s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			letters[s2.charAt(i)]--;
		}

		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 0) {
				return false;
			}
		}

		return true;
	}
	
	public static boolean isPermutation2(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		
		if (s1.length() != s2.length())
			return false;
		
		int[] letters = new int[256];
		
		for (char c : s1.toCharArray())
			letters[c]++;
		
		for (char c : s2.toCharArray())
			letters[c]--;
		
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 0) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Determine whether a number is of base 2
	 * @param num
	 * @return
	 */
	public static boolean isBase2(int num) {
		if ((num & num - 1) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Return the maximum number of chess games for a tournament
	 * Must be base 2 to avoid not playing a game
	 * @param num
	 * @return
	 */
	public static int maxGames(int num) {
		if (!isBase2(num)) {
			return 0;
		}
		return num - 1;
	}

	/**
	 * Determine the maximum number of trips an elevator can make
	 * @param top
	 * @param bottom
	 * @return
	 */
	public static int maxFloors(int top, int bottom) {
		return (int) Math.pow(2, (top - bottom + 1));
	}

	/**
	 * Compress a string
	 * Input: aaabbbbcccdde
	 * Return: a3b4c3d2e
	 * @param str
	 * @return
	 */
	public static String compression(String str) {
		if (str == null || str.length() < 1) {
			return null;
		}

		char letter = 0;
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (letter == str.charAt(i)) {
				counter++;
			} else {
				if (letter != 0) {
					sb.append(letter);
					sb.append(counter);
				}
				letter = str.charAt(i);
				counter = 1;
			}
		}
		sb.append(letter);
		sb.append(counter);
		return sb.toString();
	}
	
	public static String compress(String s) {
		if (s == null)
			return "";
		
		char[] characters = s.toCharArray();
		
		int counter = 0;
		char lastChar = characters[0];
		StringBuilder sb = new StringBuilder();
		
		for (char c : characters) {
			if (c == lastChar) {
				counter++;
			} else {
				sb.append(lastChar);
				sb.append(counter);
				lastChar = c;
				counter = 1;
			}
		}
		
		sb.append(lastChar);
		sb.append(counter);
		
		String compressed = sb.toString();
		
		if (compressed.length() >= s.length())
			return s;
		
		return compressed;
	}

	/**
	 * Reverse a string
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}

		return sb.toString();
	}

	/**
	 * Find the missing number in a series
	 * @param nums
	 * @return
	 */
	public static int missingNumber(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += i;
		}

		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}

		return sum;
	}

	/**
	 * Replace spaces with %20
	 * @param str
	 * @return
	 */
	public static String replaceSpaces(String str) {
		if (str == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static String serializeSpaces(char[] characters, int length) {
		int spaceCount = 0;
		int newLength = 0;
		int i;
		
		for (i = 0; i < length; i++) {
			if (characters[i] == ' ') {
				spaceCount++;
			}
		}
		
		newLength = length + (spaceCount * 2);
//		characters[newLength] = '\0';
		
		for (i = length - 1; i >= 0; i--) {
			if (characters[i] == ' ') {
				characters[newLength - 1] = '0';
				characters[newLength - 2] = '2';
				characters[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				characters[newLength - 1] = characters[i];
				newLength = newLength - 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (char c : characters) {
			sb.append(c);
		}

		return sb.toString();
	}

	/**
	 * FizzBuzz
	 * @param n
	 */
	public static void fizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("fizzbuzz");
			} else if (i % 3 == 0) {
				System.out.println("fizz");
			} else if (i % 5 == 0) {
				System.out.println("buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	/**
	 * Transpose a matrix (rotate)
	 * @param matrix
	 * @return
	 */
	public static int[][] transposeMatrix(int[][] matrix) {
		if (matrix == null) {
			return null;
		}

		if (matrix.length < 1 || matrix[0].length < 1) {
			return null;
		}

		int[][] newMatrix = new int[matrix[0].length][matrix.length];

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[0].length; column++) {
				newMatrix[column][row] = matrix[row][column];
			}
		}

		return newMatrix;
	}
	
	/**
	 * Determine if a string is a substring of another
	 * Input: 'waterbottle', 'erbottlewat'
	 * Return: true
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isSubstring(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		
		String s1s1 = s1 + s1;
		return s1s1.contains(s2);
	}
}
