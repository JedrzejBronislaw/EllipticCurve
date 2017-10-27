package jk.console.tasks;

import java.util.Scanner;

import jk.console.Task;
import jk.domain.EllipseCurve;
import jk.domain.tool.AboutCurve;

public class CreateECFromConsoleParameterTask implements Task {

	private EllipseCurve currentEC;

	@Override
	public boolean inMyName(String name) {
		return name.equals("formula");
	}

	public EllipseCurve getCurrentEC() {
		return currentEC;
	}

	@Override
	public void go(Scanner scanner, String[] args) {
			double a,b;
			EllipseCurve ec;
			AboutCurve aboutCurve;

			System.out.print("Specify a, please: ");
			a = scanner.nextDouble();
			System.out.print("Specify b, please: ");
			b = scanner.nextDouble();
			System.out.println("\nYour ellipse curve formula:");

			ec = new EllipseCurve(a,b);
			aboutCurve = new AboutCurve(ec);

			System.out.println(ec.getFormula());
			aboutCurve.show();


			currentEC = ec;
	}


}
