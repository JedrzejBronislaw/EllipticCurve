package jk.domain;

public class EllipseCurve {

	private double a,b;

	public EllipseCurve(double a2, double b2) {
		this.a = a2;
		this.b = b2;
	}

	public String getFormula() {
		return "y^2 = x^3 + " + a + "x + " + b;
	}

//	public double getX(double y){
//
//	}
	public double getY(double x){
		return Math.sqrt(x*x*x + a * x + b);
	}

	public boolean isOnCurve(double x, double y){
		double l = y*y;
		double r =  x*x*x + a*x + b;

		return l==r;
	}

	public Point getPoint(double x){
		return new Point(x, getY(x));
	}
	
//	public double getMinX(){
//		
//	}
}
