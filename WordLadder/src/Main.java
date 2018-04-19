import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


public class Main {

	class WordNode {
		String word;
		List<String> path;
		
		public WordNode(String word, List<String> path) {
			this.word = word;
			this.path = path;
		}
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> path = new LinkedList<String>();
		path.add(beginWord);
		WordNode node = new WordNode(beginWord, path);
		
		Queue<WordNode> queue = new LinkedList<WordNode>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			WordNode word = queue.remove();
			if (endWord.equals(word.word)) {
				return word.path.size();
			}
			
			char[] characters = word.word.toCharArray();
			
			for (int i = 0; i < characters.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = characters[i];
					characters[i] = c;
					String newWord = new String(characters);
					if (wordList.contains(newWord)) {
						List<String> newPath = new LinkedList<String>(word.path);
						newPath.add(newWord);
						WordNode newNode = new WordNode(newWord, newPath);
						queue.add(newNode);
					}
					
					characters[i] = temp;
				}
			}
		}
		return 0;
	}
	
	public void binarySearch(int guess) {
		int[] input = new int[300];
		for (int i = 0; i < input.length; i++) {
			input[i] = i;
		}
		
		int numGuesses = 1;
		int min = 0;
		int max = input.length - 1;
		
		while (max >= min) {
			int mid = (max+min) / 2;
			System.out.println("mid: " + mid);
			if (input[mid] == guess) {
				System.out.println("You found " + guess + " at index " + mid + " in " + numGuesses + " guesses.");
				return;
			} else if (input[mid] < guess) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
			numGuesses++;
		}
	}
	
	public int multiply(int[] arr1, int[] arr2) {
		int totalSum = 0;
		int place = 0;
		boolean negative = (arr1[0] < 0 || arr2[0] < 0);
		for (int i = arr1.length-1; i >=0; i--) {
			int sum = 0;
			int mult = 0;
			int first = arr1[i] < 0 ? arr1[i] * -1 : arr1[i];
			for (int j = arr2.length-1; j >= 0; j--) {
				System.out.println("arr1[i]: " + arr1[i]);
				System.out.println("arr2[j]: " + arr2[j]);
				int second = arr2[j] < 0 ? arr2[j] * -1 : arr2[j];
				int n = first * second;
				System.out.println("total: " + n);
				if (mult > 0) {
					n = (int) (n * Math.pow(10, mult));
				}
				
				System.out.println("mult: " + mult);
				System.out.println("total: " + n);
				sum += n;
				mult++;
			}
			System.out.println("sum: " + sum);
			if (place > 0) {
				sum = (int) (sum * Math.pow(10, place));
			}
			System.out.println("place: " + place);
			System.out.println("sum: " + sum);
			place++;
			totalSum += sum;
		}
		System.out.println("totalSum: " + totalSum);
		System.out.println("negative: " + negative);
		if (negative)
			totalSum = totalSum * -1;
		return totalSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
//		List<String> dict = new ArrayList<String>();
//		dict.add("hot");
//		dict.add("dot");
//		dict.add("dog");
//		dict.add("lot");
//		dict.add("log");
//		dict.add("cog");
//		int result = m.ladderLength("hit", "cog", dict);
//		System.out.println("result: " + result);
		
//		m.binarySearch(149);
		System.out.println(m.multiply(new int[] {-1, 2, 3}, new int[] {9, 8, 7}));
	}

}
