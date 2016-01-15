package main.java.com.application.calculator;

/**
 * Written by Wil Hoskins on 1/4/2016
 * Some code was taken from Driver.java (written by Eric Miller), and will be marked
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

	public static ArrayList<Operation> history = new ArrayList<Operation>();
	
	static ArrayList<String> operations = new ArrayList<String>(Arrays.asList("add", "sub", "mul", "div", "fac", "hist", "clear"));

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		boolean cont = true;
		//Inform user calculator is running
		System.err.println("STARTING Xx_~Calcul8r~_xX");
		try {
			while (cont) {
				String command = in.nextLine();
				parseCommandAndRun(command);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		in.close();
	}

	/**
	 * Written by Eric Miller
	 * @param command		String of entire command (name, base, parameters)
	 * @throws Exception
	 */
	
	public static void parseCommandAndRun(String command) throws Exception {
		// Store command and parameters
		// get pieces separated by whitespace
		String[] pieces = command.split("\\s");
		int[] parameters = new int[0];
		if(pieces.length >= 2){
			parameters = new int[pieces.length - 2];
		}
		// Parse the command
		String name = pieces[0];
		if(operations.contains(name)){
		// parse the base
		//if command uses a number (not history or clear), set base
			try{
				int base = 0;
				if(pieces.length > 1){
					base = parseInt(pieces[1]);
				}
				// parse the parameters.
				for (int i = 2; i < pieces.length; i++) {
					parameters[i-2] = parseInt(pieces[i]);
				}

				runCommand(name, base, parameters);
				
			}catch(NumberFormatException nfe){
				System.out.println("An invalid value has been entered");
			}
		}else{
			System.out.println(name + " is not a valid operation");
		}
	}

	/**
	 * End section
	 */
	
	/**
	 * Written by Wil Hoskins, modified by Eric Miller
	 * @param command		name of operation
	 * @param base			first integer
	 * @param parameters	all other integers
	 */
	
	public static void runCommand(String command, int base, int... parameters) {
		switch (command) {
			case "add":
				Addition a = new Addition(base, parameters);
				System.out.println(a.getResult());
				history.add(a);
				break;
			case "sub":
				Subtraction s = new Subtraction(base, parameters);
				System.out.println(s.getResult());
				history.add(s);
				break;
			case "mul":
				Multiplication m = new Multiplication(base, parameters);
				System.out.println(m.getResult());
				history.add(m);
				break;
			case "div":
				Division d = new Division(base, parameters);
				System.out.println(d.getResult());
				history.add(d);
				break;
			case "hist":
				printHistory();
				break;
			case "clear":
				history.clear();
				break;
			case "fac":
				Factorialization f = new Factorialization(base, parameters);
				System.out.println(f.getResult());
				history.add(f);
				break;
			default:
				System.out.println("Invalid Operation!");
				break;
		}
	}

	public static void printHistory() {
		for (Operation o : history) {
			System.out.println(o.toString());
		}
	}

	/**
	 * Written by Eric Miller
	 * @param toParse		String to parse into int
	 * @return				integer representation of toParse
	 * @throws Exception
	 */
	
	public static int parseInt(String toParse) throws Exception {
		if (toParse.startsWith("!")) {
			// It's a result from history.
			// Parse the result #
			int index = Integer.parseInt(toParse.substring(1));
			
			// Check that it's within bounds
			int retval = 0;
			if (index > history.size()) {
				System.out.println("No history matching index " + index + ", returning 0.");
			}else{
			// Get the value.
			retval = history.get(index - 1).getResult();
			}
			return retval;
		} else {
			// It's not a result from history, just parse it.
			return Integer.parseInt(toParse);
		}
	}

}