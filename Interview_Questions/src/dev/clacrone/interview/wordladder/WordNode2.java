package dev.clacrone.interview.wordladder;

public class WordNode2 {
	public String word;
	public int numSteps;
	public WordNode2 pre;
	
	public WordNode2(String word, int numSteps, WordNode2 pre) {
		// TODO Auto-generated constructor stub
		this.word = word;
		this.numSteps = numSteps;
		this.pre = pre;
	}
}
