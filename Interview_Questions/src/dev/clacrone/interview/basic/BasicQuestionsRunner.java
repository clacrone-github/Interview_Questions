package dev.clacrone.interview.basic;

public class BasicQuestionsRunner {
	public static void runBasicQuestions() {
		boolean result = BasicQuestions.isSubstring("waterbottle", "erbottlewat");
		System.out.println("result is: " + result);
		
		String compressed = BasicQuestions.compress("aabbccdde");
		System.out.println("compressed is: " + result);
		
		for (int i = 0; i < 120; i++) {
			System.out.println(BasicQuestions.ordinal(i));
		}
		
		System.out.println(BasicQuestions.factMem(10));
		
		int[] arr = new int[]{ 1, 3, 2, 5, 7, 5, 8, 9 };
		int[] addToSumResult = BasicQuestions.addToSum(arr, 10);
		System.out.println("[" + addToSumResult[0] + ", " + addToSumResult[1] + "]");
		
		int[][] matrix = new int[][]{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
	
		int[][] response = BasicQuestions.transposeMatrix(matrix);
	
		if (response != null) {
			for (int row = 0; row < response.length; row++) {
				System.out.print("[");
				for (int column = 0; column < response[0].length; column++) {
					System.out.print(response[row][column]);
					if (column < response[0].length - 1) {
						System.out.print(", ");
					}
				}
				System.out.println("]");
			}
		}
	}
}
