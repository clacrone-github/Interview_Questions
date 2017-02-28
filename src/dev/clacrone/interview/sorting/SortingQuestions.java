package dev.clacrone.interview.sorting;

import dev.clacrone.interview.arrays.ArrayStructure;

public class SortingQuestions {
	
	private ArrayStructure arrayStructure;
	
	public SortingQuestions(ArrayStructure arrayStructure) {
		this.arrayStructure = arrayStructure;
	}
	
	// Selection sort search for the smallest number in the array
	// saves it in the minimum spot and then repeats searching
	// through the entire array each time
	public void selectionSort() {
		for(int x=0; x < arrayStructure.getArraySize(); x++){
		  int minimum = x;		  
		  for(int y=x; y < arrayStructure.getArraySize(); y++){
			  // To change direction of sort just change 
			  // this from > to <
			  if(arrayStructure.getArray()[minimum] > arrayStructure.getArray()[y]){
				  minimum = y;
			  }
		  }
		  swapValues(x, minimum);
		  arrayStructure.printHorzArray(x, -1);
		}
	}
	
	// The Insertion Sort is normally the best of 
	// the elementary sorts. Unlike the other sorts that
	// had a group sorted at any given time, groups are
	// only partially sorted here.
	public void insertionSort(){
		for (int i = 1; i < arrayStructure.getArraySize(); i++){
			int j = i;
			int toInsert = arrayStructure.getArray()[i];
			while ((j > 0) && (arrayStructure.getArray()[j-1] > toInsert)){
				arrayStructure.getArray()[j] = arrayStructure.getArray()[j-1];
				j--;
				arrayStructure.printHorzArray(i, j);
			}
			arrayStructure.getArray()[j] = toInsert;
			arrayStructure.printHorzArray(i, j);
			System.out.println("\nArray[i] = " + arrayStructure.getArray()[i] + " Array[j] = " + arrayStructure.getArray()[j] + " toInsert = " + toInsert + "\n");  
		}
	}

	// This bubble sort will sort everything from 
	// smallest to largest
	public void bubbleSort(){
		// i starts at the end of the Array
		// As it is decremented all indexes greater
		// then it are sorted
		for (int i = arrayStructure.getArraySize() - 1; i > 1; i--) {
			
			// The inner loop starts at the beginning of 
			// the array and compares each value next to each 
			// other. If the value is greater then they are 
			// swapped
			for (int j = 0; j < i; j++) {
				// To change sort to Descending change to <
				if (arrayStructure.getArray()[j] > arrayStructure.getArray()[j + 1]) {
					swapValues(j, j+1);
					arrayStructure.printHorzArray(i, j);
				}
			}
		}
	}

	public void swapValues(int indexOne, int indexTwo){		
		int temp = arrayStructure.getArray()[indexOne];
		arrayStructure.getArray()[indexOne] = arrayStructure.getArray()[indexTwo];
		arrayStructure.getArray()[indexTwo] = temp;
	}
}
