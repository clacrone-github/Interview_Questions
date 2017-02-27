package dev.clacrone.interview.threesum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreeSumRunner {
	public static void runThreeSum() throws FileNotFoundException {
		Scanner in = new Scanner(new File("8ints.txt"));
		
//		long startTime = System.nanoTime();
		long startTime = System.currentTimeMillis();
		int[] ints = new int[in.nextInt()];
		
		for (int i = 0; i < ints.length; i++) {
			ints[i] = in.nextInt();
		}
		System.out.println(ThreeSum.count(ints));
//		long endTime = System.nanoTime();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time: " + (endTime - startTime) + "ms");
	}
}
