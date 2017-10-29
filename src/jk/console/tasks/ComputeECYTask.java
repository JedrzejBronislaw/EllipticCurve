package jk.console.tasks;

import java.util.Scanner;

import jk.console.Register;
import jk.console.Task;
import jk.domain.EllipseCurve;

public class ComputeECYTask implements Task {
	enum FailureReason{xFailure, ecFailure}

	private Register register;

	private String name = "comy";

	private double x;
	private String xStr;
	private Scanner scanner;

	@Override
	public String getHelpShortText() {
		return "Y computation";
	}

	@Override
	public String getHelpText() {
		//todo
		return getHelpShortText();
	}

	@Override
	public String getName() {
		return name;
	}

	public Task setRegister(Register register) {
		this.register = register;
		return this;
	}

	@Override
	public boolean isMyName(String name) {
		return name.toLowerCase().equals(this.name);
	}

	@Override
	public void go(Scanner scanner, String[] args) {
		this.scanner = scanner;
		EllipseCurve ec = register.getCurrentEC();

		if (args.length < 2)
			getArgs();
		verifyArgs();

		if (ec == null) {
			failure(FailureReason.ecFailure);
		} else
		if (!verifyArgs()) {
			failure(FailureReason.xFailure);
		} else
			success(ec);
	}
	private void success(EllipseCurve ec) {
		System.out.println("P = (" + x + ", " + ec.getY(x) + ")");
		System.out.println("    or");
		System.out.println("P = (" + x + ", " + -ec.getY(x) + ")");
	}

	private void failure(FailureReason reason) {
		System.out.println("Erron: " + reason);
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
