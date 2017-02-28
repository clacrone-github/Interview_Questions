package dev.clacrone.interview.searching;

import dev.clacrone.interview.arrays.ArrayStructure;

public class SearchingQuestionsRunner {
	public static void runSearchingQuestions() {
		ArrayStructure newArray = new ArrayStructure();
		newArray.generateRandomArray();
		newArray.printHorzArray(-1,-1);
		
		SearchingQuestions sq = new SearchingQuestions(newArray);
		sq.linearSearchForValue(10);
		// newArray.binarySearchForValue(17);
	}
}
