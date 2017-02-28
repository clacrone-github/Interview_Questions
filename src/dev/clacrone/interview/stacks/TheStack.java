package dev.clacrone.interview.stacks;

import java.util.Arrays;

public class TheStack {
	private String[] stackArray;
	private int stackSize;
	private int topOfStack = -1;
	
	public TheStack(int size) {
		this.stackSize = size;
		this.stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String input) {
		if (topOfStack + 1 < stackSize) {
			topOfStack++;
			stackArray[topOfStack] = input;
		} else {
			System.out.println("Sorry but the stack is full");
		}
		displayTheStack();
		System.out.println("PUSH " + input + " was added to the stack");
	}
	
	public String pop() {
		if (topOfStack >= 0) {
			System.out.println("POP " + stackArray[topOfStack] + " was removed from the stack");
			stackArray[topOfStack] = "-1";
			displayTheStack();
			return stackArray[topOfStack--];
		} else {
			System.out.println("Sorry but the stack is empty");
			displayTheStack();
			return "-1";
		}
	}
	
	public String peek() {
		displayTheStack();
		System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack");
		return stackArray[topOfStack];
	}
	
	public void displayTheStack(){
		for (int n = 0; n < 61; n++) {
			System.out.print("-");
		}
		
		System.out.println();
		
		for (int n = 0; n < stackSize; n++) {
			System.out.format("| %2s "+ " ", n);	
		}
		
		System.out.println("|");
		
		for (int n = 0; n < 61; n++) {
			System.out.print("-");
		}
		
		System.out.println();
		
		for (int n = 0; n < stackSize; n++) {
			if (stackArray[n].equals("-1")) { 
				System.out.print("|     ");
			} else {
				System.out.print(String.format("| %2s "+ " ", stackArray[n]));
			}
		}
		
		System.out.println("|");
		
		for (int n = 0; n < 61; n++) {
			System.out.print("-");	
		}
		
		System.out.println();
	}
}
