package dev.clacrone.interview.stacksqueuesbags;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StacksQueuesBagsRunner {
	public static void runStacksQueuesBags() throws FileNotFoundException {
		Scanner in = new Scanner(new File("tobe.txt"));
		
		StackOfStrings stack = new StackOfStrings();
		while(in.hasNext()) {
			String s = in.next();
			if (s.equals("-"))
				System.out.print(stack.pop());
			else
				stack.push(s);
		}
		
		List<String> s = new LinkedList<String>();
	}
}
