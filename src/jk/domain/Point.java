package jk.domain;

public class Point {

	private double x,y;

	public void setX(double x) {
		this.x = x;
	}
	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}
	public double getY() {
		return y;
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
