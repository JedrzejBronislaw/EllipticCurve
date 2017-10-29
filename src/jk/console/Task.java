package jk.console;

import java.util.Scanner;

public interface Task {

	Task setRegister(Register register);
	boolean isMyName(String name);
	void go(Scanner scanner, String[] args);
	String getName();
	String getHelpShortText();
	String getHelpText();
}
