package dev.clacrone.interview.sorting;

import dev.clacrone.interview.arrays.ArrayStructure;

public class SortingQuestionsRunner {
	public static void runSortingQuestions() {
		ArrayStructure newArray = new ArrayStructure();
		newArray.generateRandomArray();
		newArray.printHorzArray(-1,-1);
		
		// newArray.bubbleSort();
		
		// We must Sort first
		// newArray.selectionSort();
		SortingQuestions sq = new SortingQuestions(newArray);
		sq.insertionSort();
	}
}
