package dev.clacrone.interview.searching;

import dev.clacrone.interview.arrays.ArrayStructure;

public class SearchingQuestions {

	private ArrayStructure arrayStructure;
	
	public SearchingQuestions(ArrayStructure arrayStructure) {
		this.arrayStructure = arrayStructure;
	}
	
	public String linearSearchForValue(int value) {	
		boolean valueInArray = false;
		String indexsWithValue = "";
		for (int i = 0; i < arrayStructure.getArraySize(); i++) {
			if (arrayStructure.getArray()[i] == value) {
				valueInArray = true;
				indexsWithValue+= i + " ";
			}
			arrayStructure.printHorzArray(i, -1);
		}
		
		if (!valueInArray) {
			indexsWithValue = "None";
		}
		
		System.out.print("The Value was Found in the Following: " + indexsWithValue);
		System.out.println();
		return indexsWithValue;
	}
	
	//The Binary Search is quicker than the linear search
	// because all the values are sorted. Because everything
	// is sorted once you get to a number larger than what
	// you are looking for you can stop the search. Also
	// you be able to start searching from the middle 
	// which speeds the search. It also works best when 
	// there are no duplicates
	public void binarySearchForValue(int value) {
		int lowIndex = 0;
		int highIndex = arrayStructure.getArraySize() - 1;
		while (lowIndex <= highIndex) {
			int middleIndex = (highIndex + lowIndex) / 2;
			if (arrayStructure.getArray()[middleIndex] < value) {
				lowIndex = middleIndex + 1;
			} else if (arrayStructure.getArray()[middleIndex] > value) { 
				highIndex = middleIndex - 1;
			} else {
				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);
				lowIndex = highIndex + 1;
			}
			arrayStructure.printHorzArray(middleIndex, -1);
		}
	}
}
