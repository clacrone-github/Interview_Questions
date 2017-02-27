package dev.clacrone.interview.wordladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {
	
	public static WordNode getShortestTransformationIterative(String startWord,
			String endWord, Set<String> dictionary) {
		if (startWord == null || endWord == null || startWord.equalsIgnoreCase(endWord)) {
			return null;
		}
		
		List<String> path = new LinkedList<String>();
		path.add(startWord);
		
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(startWord, 1, path));
		
		if (!dictionary.contains(endWord)) {
			dictionary.add(endWord);
		}
		
		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			
			if (word.equalsIgnoreCase(endWord)) {
				return top;
			}
			
			char[] arr = word.toCharArray();
			
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'A'; c <= 'Z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}
					
					String newWord = new String(arr);
					if (dictionary.contains(newWord)) {
						List<String> list = new LinkedList<String>(top.path);
						list.add(newWord);
						
						queue.add(new WordNode(newWord, top.numSteps + 1, list));
						dictionary.remove(newWord);
					}
					
					arr[i] = temp;
				}
			}
		}
		
		return null;
	}
	
	public List<List<String>> findLadders(Set<String> dict, String start, String end) {
		// TODO Auto-generated constructor stub
		List<List<String>> result = new ArrayList<List<String>>();
		
		List<WordNode2> queue = new LinkedList<WordNode2>();
		queue.add(new WordNode2(start, 1, null));
		
		if (!dict.contains(end)) {
			dict.add(end);
		}
		
		int minStep = 0;
		
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> unvisited = new HashSet<String>();
		
		unvisited.addAll(dict);
		
		int preNumSteps = 0;
		
		while (!queue.isEmpty()) {
			WordNode2 top = queue.remove(0);
			String word = top.word;
			
			int currNumSteps = top.numSteps;
			
			if (word.equals(end)) {
				if (minStep == 0) {
					minStep = top.numSteps;
				}
				
				if (top.numSteps == minStep && minStep != 0) {
					ArrayList<String> t = new ArrayList<String>();
					t.add(top.word);
					while (top.pre != null) {
						t.add(0, top.pre.word);
						top = top.pre;
					}
					result.add(t);
					continue;
				}
			}
			
			if (preNumSteps < currNumSteps) {
				unvisited.removeAll(visited);
			}
			
			preNumSteps = currNumSteps;
			
			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}
					
					String newWord = new String(arr);
					if (unvisited.contains(newWord)) {
						queue.add(new WordNode2(newWord, top.numSteps + 1, top));
						visited.add(newWord);
					}
					
					arr[i] = temp;
				}
			}
		}
		
		return result;
	}
	
	public int getLadderLength(Set<String> dictionary, String beginWord, String endWord) {
		if (beginWord == null || endWord == null || beginWord.equalsIgnoreCase(endWord)) {
			return 0;
		}
		
		LinkedList<WordNode3> queue = new LinkedList<WordNode3>();
		queue.add(new WordNode3(beginWord, 1));
		
		if (!dictionary.contains(endWord)) {
			dictionary.add(endWord);
		}
		
		while (!queue.isEmpty()) {
			WordNode3 top = queue.remove(0);
			String word = top.word;
			
			if (word.equalsIgnoreCase(endWord)) {
				return top.numSteps;
			}
			
			char[] arr = word.toCharArray();
			
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}
					
					String newWord = new String(arr);
					if (dictionary.contains(newWord)) {
						queue.add(new WordNode3(newWord, top.numSteps + 1));
						dictionary.remove(newWord);
					}
					
					arr[i] = temp;
				}
			}
		}
		
		return 0;
	}
}
