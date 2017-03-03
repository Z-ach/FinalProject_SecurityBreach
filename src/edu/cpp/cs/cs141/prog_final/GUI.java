package edu.cpp.cs.cs141.prog_final;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CountDownLatch;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.cpp.cs.cs141.prog_final.beings.Ninja;
import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Briefcase;
import edu.cpp.cs.cs141.prog_final.items.Bullet;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;
import edu.cpp.cs.cs141.prog_final.items.Radar;

public class GUI extends JPanel implements UserInterface, ActionListener {

	private static final long serialVersionUID = -1901275594602421699L;

	public static final int WIDTH = 900, HEIGHT = 660;

	private Grid grid;

	private int darknessRadius = 70, darknessRowSpacer = 0, darknessColSpacer = 265;

	private int beingRadius = 60, beingRowSpacer = 5, beingColSpacer = 270;

	private int powerupRadius = 40, powerupRowSpacer = 15, powerupColSpacer = 280;

	private Color playerColor = Color.BLUE;
	private Color ninjaColor = Color.RED;
	private Color roomColor = Color.GREEN;
	private Color briefcaseColor = Color.BLUE;

	private Color shieldColor = Color.ORANGE;
	private Color radarColor = Color.MAGENTA;
	private Color bulletColor = Color.PINK;

	CountDownLatch latch = null;

	JTextArea textArea;

	int input = -1;

	public GUI() {
		this.requestFocus();
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				inputHandle(e);
			}
		});
		textInit();
		update();
	}

	private void textInit() {
		setLayout(null);
		textArea = new JTextArea(5, 5);
		textArea.setText("");
		textArea.setBounds(10, 10, 245, 610);
		textArea.setLineWrap(true);
		textArea.setVisible(true);
		textArea.setEditable(false);
		add(textArea);
	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	public void setObjects(Player player, Briefcase briefcase, Ninja[] ninjas, Grid grid, Radar radar, Bullet bullet,
			Invincibility shield) {
		this.grid = grid;
	}
	/*
	 * playerD = new PlayerDrawing(player); ninjaD = new NinjaDrawing[6];
	 * for(int i = 0; i < 6; i++){ ninjaD[i] = new NinjaDrawing(ninjas[i]); }
	 */

	public void update() {
		this.repaint();
		this.revalidate();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 10; i++) {
			g.drawLine(darknessColSpacer + 70 * i, 0, darknessColSpacer + 70 * i, GUI.HEIGHT);
			g.drawLine(darknessColSpacer, 70 * i, GUI.WIDTH, 70 * i);
		}

		/*
		 * for (int i = 0; i < 9; i++) { for (int j = 0; j < 9; j++) {
		 * g.drawString((165 + 70 * j) + ", " + (40 + 70 * i), (165 + 70 * j),
		 * (40 + 70 * i)); // System.out.println("ran " + (120 + 70 * j) + ", "
		 * + (35 + // 70*i)); } }
		 */
		boolean printHere = false;
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				printHere = false;
				if (!grid.getLight()[row][col]) {
					g.setColor(Color.BLACK);
					g.fillRect(darknessColSpacer + (col * 70), darknessRowSpacer + (row * 70), darknessRadius,
							darknessRadius);
					continue;
				}
				switch (grid.getBoard()[row][col]) {
				case 'B':
					g.setColor(briefcaseColor);
					g.fillOval(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
					// System.out.println("bcase at " + row + ", " + col);
					printHere = true;
					break;
				case 'P':
					g.setColor(playerColor);
					g.fillOval(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
					// System.out.println("player at " + row + ", " + col);
					printHere = true;
					break;
				case 'R':
					g.setColor(roomColor);
					g.fillRect(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
					// System.out.println("room at " + row + ", " + col);
					printHere = true;
					break;
				case 'i':
					g.setColor(shieldColor);
					g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius,
							powerupRadius);
					// System.out.println("shield at " + row + ", " + col);
					printHere = true;
					break;
				case 'b':
					g.setColor(bulletColor);
					g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius,
							powerupRadius);
					// System.out.println("bullet at " + row + ", " + col);
					printHere = true;
					break;
				case 'r':
					g.setColor(radarColor);
					g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius,
							powerupRadius);
					// System.out.println("radar at " + row + ", " + col);
					printHere = true;
					break;
				case 'N':
					g.setColor(ninjaColor);
					g.fillOval(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
					// System.out.println("ninja at " + row + ", " + col);
					printHere = true;
					break;
				}
				// System.out.println("Just checked row: " + row + ", col: " +
				// col + "\tValue at this location is: " +
				// grid.getBoard()[row][col]);
				// System.out.println();
				// System.out.println("Printed here? " + printHere);
			}
		}

	}

	@Override
	public void instruction() {
		// TODO Auto-generated method stub

	}

	@Override
	public int gameStartPrompt() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void inputHandle(KeyEvent e) {

		System.out.println("keypress detected: " + e.getKeyCode());
		input = e.getKeyCode();
		latch.countDown();

	}

	@Override
	public int playerOptions(boolean looking) {
		if (textArea.getText().charAt(0) != '1')
			textArea.setText(textArea.getText() + "\n\nChoose one of the following options:\n");
		else
			textArea.setText("Choose one of the following options:\n");
		if (!looking) {
			textArea.setText(textArea.getText() + "\n1: MOVE");
			textArea.setText(textArea.getText() + "\n2: SHOOT");
		} else {
			textArea.setText(textArea.getText() + "\n1: LOOK");
			textArea.setText(textArea.getText() + "\n2: SHOOT");
			textArea.setText(textArea.getText() + "\n3: EXIT MENU");
			textArea.setText(textArea.getText() + "\n4: DEBUG MODE");
		}
		return takeInput(1, 4, !looking);
	}

	@Override
	public int direction() {
		textArea.setText("1: UP");
		textArea.setText(textArea.getText() + "\n2: DOWN");
		textArea.setText(textArea.getText() + "\n3: LEFT");
		textArea.setText(textArea.getText() + "\n4: RIGHT");
		System.out.println("direction");
		return takeInput(1, 4, false);
	}

	@Override
	public int exitOptions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hardAI() {
		// TODO Auto-generated method stub
		return 1;
	}

	public int takeInput(int lowerBound, int upperBound, boolean keys) {
		input = -1;
		System.out.println("waiting for key input");
		while (input < lowerBound || input > upperBound) {
			System.out.println("input currently " + input);
			latch = new CountDownLatch(1);
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (keys) {
				switch (input) {
				case KeyEvent.VK_UP:
					System.out.println("up entered");
					return 1;
				case KeyEvent.VK_DOWN:
					System.out.println("down entered");
					return 2;
				case KeyEvent.VK_LEFT:
					System.out.println("left entered");
					return 3;
				case KeyEvent.VK_RIGHT:
					System.out.println("right entered");
					return 4;
				}
			}
			System.out.println("input " + input);
			if (input > 40)
				input -= 48;

			System.out.println("input was: " + input);
		}
		System.out.println("input returned as " + input);
		return input;
	}

	@Override
	public void printGrid(char[][] grid, boolean[][] lighting, Player player, Invincibility shield, boolean hardMode) {

		update();
		textArea.setText(textArea.getText() + "\n\n\n\n\n\n");
		textArea.setText(textArea.getText() + "Game Difficulty: ");
		if(hardMode)
			textArea.setText(textArea.getText() + "HARD");
		else
			textArea.setText(textArea.getText() + "EASY");
		textArea.setText(textArea.getText() + "\nLives: " + player.getLives());
		textArea.setText(textArea.getText() + "\nBullets: " + player.getBullets());
		textArea.setText(textArea.getText() + "\nShield: ");
		if (!player.getShield())
			textArea.setText(textArea.getText() + "not in use");
		else if (player.getShield() && shield != null) {
			textArea.setText(textArea.getText() + shield.getTurns());
		}
	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveSuccessful() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void errorCheck(boolean room) {
		// TODO Auto-generated method stub

	}

	@Override
	public void noCase() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endMessage(boolean win) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loseLife() {
		textArea.setText("You have lost a life.");
	}

	@Override
	public void briefCase(boolean hasCase) {
		// TODO Auto-generated method stub

	}

	@Override
	public void killedNinja() {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent action) {
		if (action.getID() == KeyEvent.KEY_TYPED) {
			System.out.println("key typed ");
		}
	}

}
