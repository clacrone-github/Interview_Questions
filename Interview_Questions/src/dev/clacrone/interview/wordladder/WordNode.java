package dev.clacrone.interview.wordladder;

import java.util.List;

public class WordNode {
	public List<String> path;
	public String word;
	public int numSteps;

	public WordNode(String lastWord, int length, List<String> path) {
		this.path = path;
		this.word = lastWord;
		this.numSteps = length;
	}
}
