import java.util.Scanner;

public class Main {
	public static void prompt() {
		String command = "";
		String last_command = "";
		Scanner scan = new Scanner(System.in);
		while (true) {
			// Flush contents of cmd
			last_command = command;
			command = "";
			// Get user input
			System.out.print(">_ ");
			command = scan.nextLine();

			switch(command) {
				case "help":
					Cmd.help();
					break;
				case "listprime":
					Cmd.list_prime();
					break;
				case "leap":
					Cmd.leap_year();
					break;
				case "fibonacci":
					Cmd.fib();
					break;
				case "fizzbuzz":
					Cmd.fizzbuzz();
					break;
				case "bmi":
					Cmd.bmi();
					break;
				case "pyramid":
					Cmd.pyramid();
					break;
				case "r2":
					Cmd.square_two();
					break;
				case "phi":
					Cmd.golden_ratio();
					break;
				case "e":
					Cmd.euler();
					break;
				case "pi":
					Cmd.pi();
					break;
				case "Snake":
					Cmd.Snake();
					break;
				case "idiot":
					Cmd.idiot();
					break;
				case "exit":
			    	return;
			  default:
			    	System.out.println("Invalid command: " + command);
			}
		}
	}

	public static void main(String args[]) {
		Msg.Welcome();

		prompt();

		Msg.Goodbye();
	}
}
