package jk.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jk.console.tasks.ComputeECYTask;
import jk.console.tasks.CreateECFromConsoleParameterTask;
import jk.domain.EllipseCurve;

public class Console {
	EllipseCurve currentEC = null;
	List<Task> tasks = new ArrayList<>();


	public Console() {
		Register register = new Register();
		tasks.add(new CreateECFromConsoleParameterTask().setRegister(register));
		tasks.add(new ComputeECYTask().setRegister(register));
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		String line, taskName;
		String[] splitLine;
		boolean exit = false;

		showHead();

		while (!exit){
			System.out.print(">: ");
			line = scanner.nextLine();
			splitLine = line.split(" ");
			taskName = splitLine[0];
			if (taskName.equals("exit")) exit = true;
			if (taskName.equals("help")) help();

			for(Task t : tasks)
				if (t.isMyName(taskName)){
					t.go(scanner, splitLine);
					break;
				}
		}

		scanner.close();

		System.out.println("\n\tTHE END.");
	}

	private void help() {
		for (Task t : tasks){
			System.out.println(t.getName() + " - " + t.getHelpShortText());
		}
	}

	private void showHead() {
		System.out.println("\tElliptic Curve\n");
	}

}
