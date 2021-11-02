import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Msg {

	public static void Welcome() {
		String version = "0.7 Alpha";
		
		System.out.print("Welcome to the PsychicShell\n");
		System.out.print("Version " + version + "\n");
		System.out.print("Licence: GPL 3.0 - PsychicPenguin\n\n");
	}

	public static void Goodbye() {
		System.out.println("\nThank you for using the PsychicShell");
	}

	public static void invalidInput() {
		System.out.println("Invalid input");
	}

	public static void Box(String text, String title) {
		JOptionPane.showMessageDialog(null, text, title, JOptionPane.YES_NO_OPTION);
	}
}

