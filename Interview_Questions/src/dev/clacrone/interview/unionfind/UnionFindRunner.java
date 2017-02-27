package dev.clacrone.interview.unionfind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnionFindRunner {
	public static void runUnionFind() throws FileNotFoundException {
		Scanner in = new Scanner(new File("tinyUF.txt"));
		
		int N = in.nextInt();
		long startTime = System.nanoTime();
//		QuickFindUF quickFind = new QuickFindUF(N);
//		QuickUnionUF quickFind = new QuickUnionUF(N);
		WeightedQuickUnionUF quickFind = new WeightedQuickUnionUF(N);
		
		for (int i = 0; i <= N; i++) {
			int p = in.nextInt();
			int q = in.nextInt();
			if (!quickFind.connected(p, q)) {
				quickFind.union(p, q);
				System.out.println("creating a union: (" + p + " " + q + ")");
			} else {
				System.out.println("(" + p + " " + q + ") is already connected");
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Execution time took: " + (endTime - startTime) + "ms");
	}
}
