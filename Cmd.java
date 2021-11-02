import java.util.Scanner;

public class Cmd {
	public static void help() {
		System.out.println("Available Commands: ");
		
		System.out.println("\nSYSTEM COMMANDS:");
		System.out.println("-> help");
		System.out.println("-> exit");

		System.out.println("\nMATHEMATICAL FUNCTIONS");
		System.out.println("-> listprime");
		System.out.println("-> leap");
		System.out.println("-> fibonacci");
		System.out.println("-> fizzbuzz");
		System.out.println("-> bmi");
		System.out.println("-> pyramid");

		System.out.println("\nMATHEMATICAL CONSTANTS");
		System.out.println("-> phi");
		System.out.println("-> e");
		System.out.println("-> r2");
		System.out.println("-> pi");

		System.out.println("\nGAMES");
		System.out.println("-> Snake");

		System.out.println("\nMEMES");
		System.out.println("-> idiot");

		System.out.print("\n");
	}

	public static void list_prime() {
		int max;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter max: ");
		try {
			max = scan.nextInt();
			for (int i = 2; i <= max; i++) {
				if (Maths.is_prime(i)) {
					System.out.println(i);
				}
			}
		} catch (Exception e) {
			Msg.invalidInput();
			return;
		}
	}

	public static void leap_year() {
		int year;
		String result = "No";
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter year: ");
		
		try {
			year = scan.nextInt();
		} catch (Exception e) {
			Msg.invalidInput();
			return;
		}
	
		if (year < 1582) {
			if (year % 4 == 0) {
				result = "Yes";
			}
		} else {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				result = "Yes";
			}
		}

		System.out.println(year + " -> " + result);
	}

	public static void fib() {
		int n1, n2, res;
		Scanner scan = new Scanner(System.in);
		try {
			String input = scan.nextLine();
			String[] input_array = input.split(",");
			n1 = Integer.parseInt(input_array[0]);
			n2 = Integer.parseInt(input_array[1]);
			res = Integer.parseInt(input_array[2]);
		} catch (Exception e) {
			Msg.invalidInput();
			return;
		}
		Maths.fibonacci(n1,n2,res);
	}

	public static void fizzbuzz() {
		String output;
		System.out.print("Enter max: ");
		int itr;
		Scanner scan = new Scanner(System.in);

		try {
			itr = scan.nextInt();
		} catch (Exception e) {
			Msg.invalidInput();
			return;
		}

		for (int i = 0; i < itr; i++) {
			output = "";
			if (i % 3 == 0) {
				output += "Fizz";
			}
			if (i % 5 == 0) {
				output += "Buzz";
			}
			if (i % 7 == 0) {
				output += "Fuzz";
			}
			if (i % 11 == 0) {
				output += "Bizz";
			}
			if (output.contains("zz")) {
				System.out.println(output);
			} else {
				System.out.println(i);
			}
		}
	}

	public static void bmi() {
		Scanner scan = new Scanner(System.in);
		double weight, height;
		String gender;
		try {
			System.out.print("Enter your weight (in kg): ");
			weight = Double.parseDouble(scan.nextLine());
			System.out.print("Enter your height (in cm): ");
			height = Double.parseDouble(scan.nextLine());
			System.out.print("Enter your gender (m/f): ");
			gender = scan.nextLine();
		} catch (Exception e) {
			Msg.invalidInput();
			return;
		}
		
		int thin = 19;
		int fat = 24;
		if (gender.equals("m")) {
			thin = 19;
			fat = 25;
		}
		
		height /= 100;
		double bmi = weight / Maths.pow(height, 2);
		System.out.println("Your BMI is: " + bmi);
		
		if (bmi < thin) {
			System.out.println("You are too thin");
		} else if (bmi > fat) {
			System.out.println("You are too fat");
		} else {
			System.out.println("You are healthy");
		}
	}

	public static void pyramid() {
		int base;
		int result = 0;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.print("Enter base size (in blocks): ");
			base = scan.nextInt();
		} catch (Exception e) {
			Msg.invalidInput();
			return;
		}

		for (int i = 0; i <= base; i++) {
			result += Maths.pow(i, 2);
		}

		System.out.println("The Pyramid contains " + result + " blocks.");
	}

	//	------------------------------	\\
	//	--- MATHEMATICAL CONSTANTS ---	\\
	//	------------------------------	\\

	public static void golden_ratio() {
		System.out.println(Maths.phi());
	}

	public static void square_two() {
		System.out.println(Maths.r2());
	}

	public static void euler() {
		System.out.println(Maths.e());
	}

	public static void pi() {
		System.out.println(Maths.pi());
	}

	//	---------------	\\
	//	--- GAMES ---	\\
	//	---------------	\\

	public static void Snake() {
		Snake.init();
	}
	
	//	------------- \\
	//	--- MEMES --- \\
	//	------------- \\
	
	public static void idiot() {
		for (int i = 0; i < 13; i++) {
			Msg.Box("You are an idiot x " + i, "Muhahahaha");
		}
	}

}
