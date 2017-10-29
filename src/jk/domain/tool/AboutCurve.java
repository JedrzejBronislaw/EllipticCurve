package jk.domain.tool;

import java.util.ArrayList;
import java.util.List;

import jk.domain.EllipseCurve;
import jk.domain.Point;

public class AboutCurve {

	private EllipseCurve ec;
	private boolean babel = false;
	Point max;
	Point min;

	public AboutCurve(EllipseCurve ec) {
		this.ec = ec;
		calculate();
	}

	private void calculate() {
		double a = ec.getA();
		double b = ec.getB();

		List<Double> miejscaZerowe = new ArrayList<>();


		System.out.println("y = x^3 + " + a + "x");
		if (a>=0){
			miejscaZerowe.add(0d);
			babel = false;
		}else{
			double root = Math.sqrt(-a);
			miejscaZerowe.add(-root);
			miejscaZerowe.add(0d);
			miejscaZerowe.add(root);

//			System.out.println("Pochodna:");
//			System.out.println("y = 3x^2 + " + a);
			double delta = -12 * a; //-12 = -4 * 3;
			double pierw = Math.sqrt(delta)/6;//(2*a);
			System.out.println("Pierwiastki: x = " + pierw);
			System.out.println("             x = " + (-pierw));
			System.out.println();

			double locMinVal = pierw*pierw*pierw + a * pierw;
			double locMaxVal = -locMinVal;
//			System.out.println("P_max=(" + pierw + ", " + max + ")");
//			System.out.println("P_min=(" + (-pierw) + ", " + min + ")");

			max = new Point( pierw, locMaxVal);
			min = new Point(-pierw, locMinVal);


			babel = (b<=locMaxVal) && (b>=locMinVal);
		}
		System.out.println();

	}

	public void show() {
		System.out.println("Local minimu value:  " + min);
		System.out.println("Local maximum value: " + max);
		System.out.println("Bubble: " + (babel ? "YES" : "NO"));
	}
}
