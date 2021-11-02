import javax.swing.JFrame;

public class Snake_GameFrame extends JFrame {
	Snake_GameFrame() {
		this.add(new Snake_GamePanel());
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
