package dev.clacrone.interview.utils;

public class Point implements Comparable {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Point that = (Point) o;
		if (this.y == that.y && this.x == that.x) 
			return 0;
        if (this.y < that.y || (this.y == that.y && this.x < that.x)) 
        	return -1;
        return 1;
	}
	
	
}
