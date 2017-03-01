package dev.clacrone.interview.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import dev.clacrone.interview.utils.Point;
import dev.clacrone.interview.utils.PointComparator;

public class HeapQuestions {
	
	public static List<Point> findKClosestStars(List<Point> stars, Point origin, int k) {
		if (stars == null || stars.isEmpty()) {
			return null;
		}
		
		if (stars.size() <= k) {
			return stars;
		}
		
		List<Point> result = new ArrayList<Point>();
		PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new PointComparator());
		for (Point star : stars) {
			if (queue.size() < k) {
				queue.add(star);
			} else {
				System.out.println("AFTER K: ");
				for (Point p : queue) {
					System.out.print("p: (" + p.getX() + ", " + p.getY() + ")   ");
					result.add(p);
				}
				System.out.println();
				
				double newDistance = calculateDistance(star, origin);
				double oldDistance = calculateDistance(queue.peek(), origin);
				if (newDistance < oldDistance) {
					Point p = queue.remove();
					System.out.println("REMOVED: (" + p.getX() + ", " + p.getY() + ")   ");
					queue.add(star);
				}
			}
		}
		
		
		System.out.println("head: (" + queue.peek().getX() + ", " + queue.peek().getY() + ")");
		for (Point p : queue) {
			System.out.print("p: (" + p.getX() + ", " + p.getY() + ")   ");
			result.add(p);
		}
		return result;
	}
	
	private static double calculateDistance(Point a, Point b) {
		return Math.sqrt(Math.pow(Math.abs(a.getX()-b.getX()), 2) + Math.pow(Math.abs(a.getY()-b.getY()), 2));
	}
}
