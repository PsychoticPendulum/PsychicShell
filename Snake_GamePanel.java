import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Snake_GamePanel extends JPanel implements ActionListener {
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 75;
	
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int body_parts = 6;
	int apples_eaten;
	int apple_x;
	int apple_y;
	char direction = 'R';
	
	boolean running = false;
	boolean paused = false;

	Timer timer;
	Random random;

	// Constructor method to initialize
	Snake_GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	public void startGame() {
		createApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		if (running) {
			// draw grid
			for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}

			// draw apple
			g.setColor(new Color(255,0,0));
			g.fillRect(apple_x, apple_y, UNIT_SIZE, UNIT_SIZE);

			// draw snek
			for (int i = 0; i < body_parts; i++) {
				// draw head in a different color
				if (i == 0) {
					g.setColor(new Color(0,255,0));
				} else {
					g.setColor(new Color(0,128,0));
				}
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}

			// draw score
			g.setColor(new Color(255,255,255));
			g.setFont(new Font("monospace", Font.BOLD, 20));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + apples_eaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + apples_eaten)) / 2, 50);
		
		if (paused) {
			paused(g);
		}
		} else {
			gameOver(g);
		}
	}

	public void createApple() {
		apple_x = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
		apple_y = random.nextInt((int)SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
	}

	public void move() {
		// move every body part to position of body_part[i-1]
		for (int i = body_parts; i > 0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}

		// set move direction
		switch (direction) {
			case 'U':
				y[0] = y[0] - UNIT_SIZE;
				break;
			case 'D':
				y[0] = y[0] + UNIT_SIZE;
				break;
			case 'L':
				x[0] = x[0] - UNIT_SIZE;
				break;
			case 'R':
				x[0] = x[0] + UNIT_SIZE;
				break;
		}
	}

	public void checkApple() {
		if ((x[0] == apple_x) && (y[0] == apple_y)) {
			body_parts++;
			apples_eaten++;
			createApple();
		}
	}

	public void checkCollisions() {
		// check if snek collides with itself
		for (int i = body_parts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}

		// check if snek out of boundries
		if (x[0] < 0 || x[0] > SCREEN_WIDTH || y[0] < 0 || y[0] > SCREEN_HEIGHT) {
			running = false;
		}
	
		// end game if collision
		if (!running) {
			timer.stop();
		}
	}

	public void gameOver(Graphics g) {
		g.setColor(new Color(255,0,0));
		g.setFont(new Font("monospace", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
	}

	public void paused(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.fillRect(SCREEN_WIDTH / 2 - 20, SCREEN_HEIGHT / 2 - 25, 15, 50);
		g.fillRect(SCREEN_WIDTH / 2 + 5, SCREEN_HEIGHT / 2 - 25, 15, 50);
	}

	public void actionPerformed(ActionEvent e) {
		if (running && !paused) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (direction != 'R') {
						direction = 'L';
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (direction != 'L') {
						direction = 'R';
					}
					break;
				case KeyEvent.VK_UP:
					if (direction != 'D') {
						direction = 'U';
					}
					break;
				case KeyEvent.VK_DOWN:
					if (direction != 'U') {
						direction = 'D';
					}
					break;
				case KeyEvent.VK_Q:
					running = false;
					break;
				case KeyEvent.VK_R:
					for (int i = body_parts; i > 0; i--) {
						if (i == 0) {
							x[i] = 0;
							y[i] = 0;
						} else {
							x[i] = x[0]-UNIT_SIZE;
							y[i] = 0;
						}
					}
					body_parts = 6;
					apples_eaten = 0;
					direction = 'R';
					running = true;
					break;
				case KeyEvent.VK_SPACE:
					paused = !paused;
			}
		}
	}
}
