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
		tasks.add(new CreateECFromConsoleParameterTask());
		tasks.add(new ComputeECYTask());
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		String line, taskName;
		String[] splitLine;
		boolean exit = false;

		showHead();

		while (!exit){
			line = scanner.nextLine();
			splitLine = line.split(" ");
			taskName = splitLine[0];
			if (taskName.equals("exit")) exit = true;

			for(Task t : tasks)
				if (t.inMyName(taskName)){
					t.go(scanner, splitLine);
					break;
				}
		}


//		formula();

//		aboutEllipseCurve();

//		for (int i=0; i<3; i++)
//			calculateY();
		scanner.close();

		System.out.println("\n\tTHE END.");
	}

	private void showHead() {
		System.out.println("\tElliptic Curve\n");
	}

//	private void aboutEllipseCurve()
//	{
//		AboutCurve aboutEC;
//		aboutEC = new AboutCurve(currentEC);
//
//		aboutEC.show();
//	}


}
