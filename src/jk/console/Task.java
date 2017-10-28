package jk.console;

import java.util.Scanner;

public interface Task {

	void setRegister(Register register);
	boolean inMyName(String name);
	void go(Scanner scanner, String[] args);
}
