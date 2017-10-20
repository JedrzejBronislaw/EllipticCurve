package jk.console;

import java.util.Scanner;

import jk.domain.EllipseCurve;

public class Console {
	Scanner scanner;
	EllipseCurve currentEC = null;

	public void start() {
		scanner = new Scanner(System.in);
		formula();
		for (int i=0; i<3; i++)
			calculateY();
		scanner.close();

		System.out.println("\n\tTHE END.");
	}

	public void formula(){
		double a,b;
		EllipseCurve ec;

		System.out.print("Specify a, please: ");
		a = scanner.nextDouble();
		System.out.print("Specify b, please: ");
		b = scanner.nextDouble();
		System.out.println("\nYour ellipse curve formula:");

		ec = new EllipseCurve(a,b);

		System.out.println(ec.getFormula());

		currentEC = ec;
	}

	public void calculateY()
	{
		double x;

		System.out.print("\nSpecify X, please: ");
		x = scanner.nextDouble();
		System.out.println("P = (" + x + ", " + currentEC.getY(x) + ")");
		System.out.println("    or");
		System.out.println("P = (" + x + ", " + -currentEC.getY(x) + ")");
	}
}
