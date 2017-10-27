package jk.console.tasks;

import java.util.Scanner;

import jk.console.Task;
import jk.domain.EllipseCurve;

public class ComputeECYTask implements Task {
	private double x;
	private String xStr;
	private Scanner scanner;
	private EllipseCurve ellipseCurve;

	public void setEllipseCurve(EllipseCurve ellipseCurve) {
		this.ellipseCurve = ellipseCurve;
	}

	public EllipseCurve getEllipseCurve() {
		return ellipseCurve;
	}

	@Override
	public boolean inMyName(String name) {
		return name.toLowerCase().equals("comy");
	}

	@Override
	public void go(Scanner scanner, String[] args) {
		this.scanner = scanner;

		if (args.length < 2)
			getArgs();
		verifyArgs();

		if (verifyArgs()) {
			success();
		} else
			faliure();
	}

	private void success() {
		System.out.println("P = (" + x + ", " + ellipseCurve.getY(x) + ")");
		System.out.println("    or");
		System.out.println("P = (" + x + ", " + -ellipseCurve.getY(x) + ")");
	}

	private void faliure() {
		System.out.println("nieprawidlowe dane");
	}

	private boolean verifyArgs() {
		try {
			x = Double.parseDouble(xStr);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private void getArgs() {
		System.out.print("\nSpecify X, please: ");
		xStr = scanner.next();
	}

}
