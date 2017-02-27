package dev.clacrone.interview.threesum;

public class ThreeSum {
	public static int count(int[] a) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int binarySearch(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else 
				return mid;
		}
		return -1;
	}
}
