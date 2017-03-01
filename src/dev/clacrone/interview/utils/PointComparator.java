package dev.clacrone.interview.utils;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {

	@Override
	public int compare(Point p1, Point p2) {
		// TODO Auto-generated method stub
		if (p1.getY() == p2.getY() && p1.getX() == p2.getX()) 
			return 0;
        if (p2.getY() < p1.getY() || (p2.getY() == p1.getY() && p2.getX() < p1.getX())) 
        	return -1;
        return 1;
	}

}
