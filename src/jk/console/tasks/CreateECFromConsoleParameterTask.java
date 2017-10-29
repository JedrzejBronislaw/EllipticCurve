package jk.console.tasks;

import java.util.Scanner;

import jk.console.Register;
import jk.console.Task;
import jk.domain.EllipseCurve;
import jk.domain.tool.AboutCurve;

public class CreateECFromConsoleParameterTask implements Task {

	private Register register;

	private String name = "formula";

	public String getHelpShortText() {
		//todo
		return "new EC createing";
	};

	@Override
	public String getHelpText() {
		return getHelpShortText();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
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

			register.setCurrentEC(ec);
	}


}
