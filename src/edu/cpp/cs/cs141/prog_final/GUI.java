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

	JTextArea textArea, stats;

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
		textArea.setBounds(10, 10, 245, 180);
		textArea.setLineWrap(true);
		textArea.setVisible(true);
		textArea.setEditable(false);
		add(textArea);
		
		stats = new JTextArea();
		stats.setText("");
		stats.setBounds(10, 210, 245, 65);
		stats.setLineWrap(true);
		stats.setVisible(true);
		stats.setEditable(false);
		add(stats);
		
/*		textInit(textArea, "", 10, 10, 245, 400);
		textInit(stats, "", 10, 300, 245, 300);*/
		
	}
	
	private void textInit(JTextArea text, String defaultText, int x, int y, int width, int height){
		text = new JTextArea();
		text.setText(defaultText);
		text.setBounds(x, y, width, height);
		text.setLineWrap(true);
		text.setVisible(true);
		text.setEditable(false);
		add(text);
	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	boolean gridTaken = false;
	
	public void setObjects(Player player, Briefcase briefcase, Ninja[] ninjas, Grid grid, Radar radar, Bullet bullet,
			Invincibility shield) {
		this.grid = grid;
		gridTaken = true;
		
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


		/*
		 * for (int i = 0; i < 9; i++) { for (int j = 0; j < 9; j++) {
		 * g.drawString((165 + 70 * j) + ", " + (40 + 70 * i), (165 + 70 * j),
		 * (40 + 70 * i)); // System.out.println("ran " + (120 + 70 * j) + ", "
		 * + (35 + // 70*i)); } }
		 */
		if (grid != null) {
			
			
			
			for (int i = 0; i < 10; i++) {
				g.drawLine(darknessColSpacer + 70 * i, 0, darknessColSpacer + 70 * i, GUI.HEIGHT);
				g.drawLine(darknessColSpacer, 70 * i, GUI.WIDTH, 70 * i);
			}
			
			
			System.out.println("printing");
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
						g.fillRect(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
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
					// System.out.println("Just checked row: " + row + ", col: "
					// +
					// col + "\tValue at this location is: " +
					// grid.getBoard()[row][col]);
					// System.out.println();
					// System.out.println("Printed here? " + printHere);
				}
			}
		}

	}

	@Override
	public void instruction() {
		// TODO Auto-generated method stub

	}

	@Override
	public int gameStartPrompt() {
		return 0;

	}

	public void inputHandle(KeyEvent e) {

		System.out.println("keypress detected: " + e.getKeyCode());
		input = e.getKeyCode();
		latch.countDown();

	}

	@Override
	public int playerOptions(boolean looking) {
		if (textArea.getText().length() > 0 && textArea.getText().charAt(0) != '1')
			textArea.setText(textArea.getText() + "\n\nChoose one of the following options:\n");
		else
			textArea.setText("Choose one of the following options:\n");
		if (!looking) {
			textArea.setText(textArea.getText() + "\n1: MOVE");
			textArea.setText(textArea.getText() + "\n2: SHOOT");
			textArea.setText(textArea.getText() + "\n\nPress any arrow key to select move.");
		} else {
			textArea.setText(textArea.getText() + "\n1: LOOK");
			textArea.setText(textArea.getText() + "\n2: SHOOT");
			textArea.setText(textArea.getText() + "\n3: EXIT MENU");
			textArea.setText(textArea.getText() + "\n4: DEBUG MODE");
			textArea.setText(textArea.getText() + "\n\nPress any arrow key to select look.");
		}
		textStats();
		return takeInput(1, 4, false);
	}

	@Override
	public int direction() {
		textArea.setText("1: UP");
		textArea.setText(textArea.getText() + "\n2: DOWN");
		textArea.setText(textArea.getText() + "\n3: LEFT");
		textArea.setText(textArea.getText() + "\n4: RIGHT");
		System.out.println("direction");
		textStats();
		return takeInput(1, 4, true);
	}

	@Override
	public int exitOptions() {
		textArea.setText("1: SAVE GAME");
		textArea.setText(textArea.getText() + "\n2. LOAD GAME");
		textArea.setText(textArea.getText() + "\n3: EXIT");
		return takeInput(1, 3, false);
	}

	@Override
	public int hardAI() {
		textArea.setText("Please select the difficulty:");
		textArea.setText(textArea.getText() + "\n1: EASY MODE");
		textArea.setText(textArea.getText() + "\n2: HARD MODE");
		return takeInput(1, 2, false);
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
			if(lowerBound == 0 && upperBound == 0){
				return 0;
			}
			if (keys) {
				switch (input) {
				case KeyEvent.VK_UP:
					System.out.println("up entered");
					input = 1;
					break;
				case KeyEvent.VK_DOWN:
					System.out.println("down entered");
					input = 2;
					break;
				case KeyEvent.VK_LEFT:
					System.out.println("left entered");
					input = 3;
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println("right entered");
					input = 4;
					break;
				}
			}

			if (!keys && (input >= 37 && input <= 40))
				input = 1;

			System.out.println("input " + input);
			if (input > 40)
				input -= 48;

			System.out.println("input was: " + input);
		}
		System.out.println("input returned as " + input);
		textArea.setText("");
		return input;
	}

	Player player;
	Invincibility shield;
	boolean hardMode;

	@Override
	public void printGrid(char[][] grid, boolean[][] lighting, Player player, Invincibility shield, boolean hardMode) {
		this.player = player;
		this.shield = shield;
		this.hardMode = hardMode;
		update();

	}

	private void textStats() {
		stats.setText("Game Difficulty: ");
		if (hardMode)
			stats.setText(stats.getText() + "HARD");
		else
			stats.setText(stats.getText() + "EASY");
		stats.setText(stats.getText() + "\nLives: " + player.getLives());
		stats.setText(stats.getText() + "\nBullets: " + player.getBullets());
		stats.setText(stats.getText() + "\nShield: ");
		if (!player.getShield())
			stats.setText(stats.getText() + "not in use");
		else if (player.getShield() && shield != null) {
			stats.setText(stats.getText() + shield.getTurns());
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
		if (room == false) {
			textArea.setText("The direction you want to move is blocked. \n" + "Please select a different direction.");
		} else if (room == true) {
			textArea.setText("Sorry you cannot enter from this side of the room"
					+ "\nPlease enter from the north side of the room");
		}
	}

	@Override
	public void noCase() {
		textArea.setText("There is no briefcase in this room.\nKeep checking.");
	}

	@Override
	public void endMessage(boolean win) {
		if(win){
			textArea.setText("Congratulations!\nYou have won the game!\nPress any key to exit.");
		}else{
			textArea.setText("You have lost the game.\nPress any key to exit.");
		}
		System.out.println("endmessage");
		//takeInput(0, 0, true);
		System.out.println("endmessage done" + takeInput(0,0,true));
	}

	@Override
	public void loseLife() {
		textArea.setText("You have lost a life.");
	}

	@Override
	public void briefCase(boolean hasCase) {

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
