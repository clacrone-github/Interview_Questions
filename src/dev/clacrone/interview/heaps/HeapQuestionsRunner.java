package dev.clacrone.interview.heaps;

import java.util.ArrayList;
import java.util.List;

import dev.clacrone.interview.utils.Point;

public class HeapQuestionsRunner {
	public static void runHeapQuestions() {
		int k = 10;
		Point origin = new Point(0, 0);
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1,1));
		points.add(new Point(11,11));
		points.add(new Point(2,2));
		points.add(new Point(10,10));
		points.add(new Point(3,3));
		points.add(new Point(9,9));
		points.add(new Point(4,4));
		points.add(new Point(8,8));
		points.add(new Point(5,5));
		points.add(new Point(7,7));
		points.add(new Point(6,6));
		points.add(new Point(3,5));
		
		List<Point> result = HeapQuestions.findKClosestStars(points, origin, k);
		System.out.println("result: " + result);
	}
}
