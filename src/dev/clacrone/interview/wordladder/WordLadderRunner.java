package dev.clacrone.interview.wordladder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderRunner {
	
	public static void runWordLadder() {
		runWordLadderFindLadders();
		runWordLadderShortestPath();
		runWordLadderGetLadderLength();
	}
	
	public static void runWordLadderGetLadderLength() {
		WordLadder ladder = new WordLadder();
		
		String start = "cat";
		String end = "dog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("bat");
		dict.add("cot");
		dict.add("cog");
		dict.add("cow");
		dict.add("rat");
		dict.add("but");
		dict.add("cut");
		dict.add("dog");
		dict.add("web");
		
		int result = ladder.getLadderLength(dict, start, end);
		System.out.println("The result is: " + result);
	}
	
	public static void runWordLadderFindLadders() {
		WordLadder ladder = new WordLadder();
				
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		List<List<String>> ladders = ladder.findLadders(dict, start, end);
		for (List<String> lad : ladders) {
			for (String s : lad) {
				System.out.print(s + " => ");
			}
			System.out.println();
		}
	}
	public static void runWordLadderShortestPath() {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("CAT");
		dictionary.add("BAT");
		dictionary.add("COT");
		dictionary.add("COG");
		dictionary.add("COW");
		dictionary.add("RAT");
		dictionary.add("BUT");
		dictionary.add("CUT");
		dictionary.add("DOG");
		dictionary.add("WEB");
		
		String startWord = "CAT";
		String endWord = "DOG";
		
		WordNode result = WordLadder.getShortestTransformationIterative(startWord, endWord, dictionary);
		//Ladder result = getShortestTransformationRecursive(startWord, endWord, dictionary);
		
		if (result != null) {
			System.out.println("Length is " + result.numSteps + " and path is : " + result.path);
		} else {
			System.out.println("No Path Found");
		}
	}
}
