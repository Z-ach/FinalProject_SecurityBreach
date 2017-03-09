/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Final Group Project (Security Breach)
 *
 * Description of assignment: Our group is making a text-based game called Security Breach. The player
 * starts out with at the bottom left of a 9x9 grid room. 9 out of 81 rooms will contain a briefcase
 * with classified information that the player needs to retrieve. The 9 rooms with the briefcase will be 
 * evenly distributed throughout the 9x9 grid room. However, all the rooms in the building are dark. 
 * The player is equipped with night-vision goggles which allows him or her to see two squares ahead of him. 
 * It will not be easy for the player to advance through the map because there are 6 ninja-assassins 
 * patrolling the building. If a ninja-assassin ends up in the same room as the player, the player will be
 * stabbed loses a life. The player start out with 3 lives. Everytime a life is lost, the player is sent back 
 * to the beginning where he or she first started off. The player can protect himself by shooting his gun in 
 * any direction. If the bullet hits a ninja-assassin(s), it will die and be eliminated from game. To help the player, 
 * there are three power-up items that are randomly placed throughout the grid. This includes a invicibility shield
 * (protects player from stabbing for 5 turns), radar (display location of the briefcase), and bullet drop (player
 * can only have one bullet on him. If this item is picked up with the character still having a bullet, the effect
 * will be negated).  
 * 
 * Team: We showed up
 * 
 * Team members: Bryan Ayala, Annalyn Edulag, Kelvin Huang, 
 * Zachary Kaufman, Michael Jason Yan
 * 
 */
package edu.cpp.cs.cs141.prog_final.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.cpp.cs.cs141.prog_final.Grid;
import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;

public class GUI extends JPanel implements UserInterface, Serializable {

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
	
	boolean isShooting = false;
	
	boolean saveKeyInput = false;
	boolean keys = false;
	int savedInput = 0;
	boolean saveRegInput = false;
	int regInput = 0;
	
	static CountDownLatch latch = null;

	JTextArea textArea, stats;

	JEditorPane instructions;

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
		stats.setBounds(10, 200, 245, 65);
		stats.setLineWrap(true);
		stats.setVisible(true);
		stats.setEditable(false);
		add(stats);

		setLegendText();

	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	public void update() {
		this.repaint();
		this.revalidate();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintLegend(g);
		if (grid != null) {
			if (this.getComponentCount() == 10)
				this.remove(instructions);
			g.setColor(Color.BLACK);
			for (int i = 0; i < 10; i++) {
				g.drawLine(darknessColSpacer + 70 * i, 0, darknessColSpacer + 70 * i, GUI.HEIGHT);
				g.drawLine(darknessColSpacer, 70 * i, GUI.WIDTH, 70 * i);
			}

			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
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
						break;
					case 'P':
						g.setColor(playerColor);
						g.fillOval(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
						break;
					case 'R':
						g.setColor(roomColor);
						g.fillRect(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
						break;
					case 'i':
						g.setColor(shieldColor);
						g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius,
								powerupRadius);
						break;
					case 'b':
						g.setColor(bulletColor);
						g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius,
								powerupRadius);
						break;
					case 'r':
						g.setColor(radarColor);
						g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius,
								powerupRadius);
						break;
					case 'N':
						g.setColor(ninjaColor);
						g.fillOval(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
						break;
					}

				}
			}
		}

	}

	private void paintLegend(Graphics g) {
		super.paintComponent(g);

		int legendBeing = (beingRadius * 4) / 5;
		int legendPowerup = (powerupRadius * 4) / 5;

		int initSpace = 280;
		int xDist = 40;
		int spacing = 0;

		g.setColor(playerColor);
		g.fillOval(xDist, (initSpace + (spacing * (legendBeing + 5))), legendBeing, legendBeing);
		spacing++;

		g.setColor(ninjaColor);
		g.fillOval(xDist, (initSpace + (spacing * (legendBeing + 5))), legendBeing, legendBeing);
		spacing++;

		g.setColor(roomColor);
		g.fillRect(xDist, (initSpace + (spacing * (legendBeing + 5))), legendBeing, legendBeing);
		spacing++;

		g.setColor(briefcaseColor);
		g.fillRect(xDist, (initSpace + (spacing * (legendBeing + 5))), legendBeing, legendBeing);
		spacing += 2;

		g.setColor(shieldColor);
		g.fillRect(xDist + 8, (initSpace + (spacing * (legendPowerup + 11))), legendPowerup, legendPowerup);
		spacing++;

		g.setColor(bulletColor);
		g.fillRect(xDist + 8, (initSpace + (spacing * (legendPowerup + 11))), legendPowerup, legendPowerup);
		spacing++;

		g.setColor(radarColor);
		g.fillRect(xDist + 8, (initSpace + (spacing * (legendPowerup + 11))), legendPowerup, legendPowerup);
		spacing++;
	}

	private void setLegendText() {

		JTextArea legendPlayer, legendNinja, legendRoom, legendBriefcase, legendShield, legendBullet, legendRadar;

		int legendBeing = (beingRadius * 4) / 5;
		legendBeing += 4;
		int legendPowerup = (powerupRadius * 4) / 5;
		legendPowerup += 8;

		int x = 120;
		int y = 292;
		int w = 135;
		int h = 25;

		legendPlayer = new JTextArea();
		legendNinja = new JTextArea();
		legendRoom = new JTextArea();
		legendBriefcase = new JTextArea();
		legendShield = new JTextArea();
		legendBullet = new JTextArea();
		legendRadar = new JTextArea();

		legendPlayer.setText("");
		legendPlayer.setBounds(x, y, w, h);
		legendPlayer.setLineWrap(true);
		legendPlayer.setVisible(true);
		legendPlayer.setEditable(false);
		add(legendPlayer);

		legendNinja.setText("");
		legendNinja.setBounds(x, y + (1 * (legendBeing)), w, h);
		legendNinja.setLineWrap(true);
		legendNinja.setVisible(true);
		legendNinja.setEditable(false);
		add(legendNinja);

		legendRoom.setText("");
		legendRoom.setBounds(x, y + (2 * (legendBeing + 2)), w, h);
		legendRoom.setLineWrap(true);
		legendRoom.setVisible(true);
		legendRoom.setEditable(false);
		add(legendRoom);

		legendBriefcase.setText("");
		legendBriefcase.setBounds(x, y + (3 * (legendBeing + 2)), w, h);
		legendBriefcase.setLineWrap(true);
		legendBriefcase.setVisible(true);
		legendBriefcase.setEditable(false);
		add(legendBriefcase);

		legendShield.setText("");
		legendShield.setBounds(x, y + (5 * (legendPowerup + 2)), w, h);
		legendShield.setLineWrap(true);
		legendShield.setVisible(true);
		legendShield.setEditable(false);
		add(legendShield);

		legendBullet.setText("");
		legendBullet.setBounds(x, y + (6 * (legendPowerup + 2)), w, h);
		legendBullet.setLineWrap(true);
		legendBullet.setVisible(true);
		legendBullet.setEditable(false);
		add(legendBullet);

		legendRadar.setText("");
		legendRadar.setBounds(x, y + (7 * (legendPowerup + 2)), w, h);
		legendRadar.setLineWrap(true);
		legendRadar.setVisible(true);
		legendRadar.setEditable(false);
		add(legendRadar);

		Font font = new Font(legendPlayer.getFont().getFontName(), Font.BOLD, 18);

		legendPlayer.setFont(font);
		legendNinja.setFont(font);
		legendRoom.setFont(font);
		legendBriefcase.setFont(font);
		legendShield.setFont(font);
		legendBullet.setFont(font);
		legendRadar.setFont(font);

		legendPlayer.setText("Player");
		legendNinja.setText("Ninja");
		legendRoom.setText("Room");
		legendBriefcase.setText("Briefcase");
		legendShield.setText("Invincibility");
		legendBullet.setText("Bullet");
		legendRadar.setText("Radar");

	}

	@Override
	public void instruction() {

		instructions = new JEditorPane();

		instructions.setText("");
		instructions.setBounds(280, 10, 600, 602);
		instructions.setVisible(true);
		instructions.setEditable(false);
		add(instructions);
		
		
		Font title = new Font("Arial", Font.TRUETYPE_FONT, 16);
		
		instructions.setFont(title);
		instructions.setText(instructions.getText() + "Welcome to Security Breach.\n\n");
		
		instructions.setText(instructions.getText() + "\nThis is a turn-based game."
				+ "\n\nYou are a spy tasked with retrieving a briefcase from one of nine rooms."
				+ "\n\nThe building is pitch black, only the location of rooms are visible."
				+ "\n\nThere are 6 ninjas searching for you, but you only have 1 bullet."
				+ "\n\nYou have a flash light that can see 2 spaces in a desired direction."
				+ "\nIt must be used before movement."
				+ "\n\nThree items exist within the grid to assist you with your mission."
				+ "\nInvincibility allows you to be invulnerable to being stabbed by a ninja."
				+ "\nRadar allows you to know the exact location of the briefcase."
				+ "\nAn extra bullet may be found after the first bullet has been used."
				+ "\n\nRoom entrances are located on the north side of the room."
				+ "\n\nIf you are stabbed by a ninja, you lose a life." + "\nIf you retrieve the briefcase, you win."
				+ "\nIf you lose all three lives before obtaining the briefcase, you lose.");
		instructions.setText(instructions.getText() + "\n\n\nGood Luck!");
	}

	@Override
	public int gameStartPrompt() {
		if(textArea.getText().equals("")){
			textArea.setText("Please choose what you would like to do");
		}else{
			textArea.setText(textArea.getText() + "\n\nPlease choose what you would like to do");
		}

		textArea.setText(textArea.getText() + "\n1. Start Game");
		textArea.setText(textArea.getText() + "\n2. Load Game");
		textArea.setText(textArea.getText() + "\n3. Exit \n");

		keys = false;
		return takeInput(1, 3);
	}

	public void inputHandle(KeyEvent e) {
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
		saveKeyInput = true;
		keys = false;
		saveRegInput = true;
		return takeInput(1, 4);
	}

	@Override
	public int direction() {
		if (textArea.getText().length() > 0 && textArea.getText().charAt(0) != '1')
			textArea.setText(textArea.getText() + "\n1: UP");
		else
			textArea.setText("1: UP");
		textArea.setText(textArea.getText() + "\n2: DOWN");
		textArea.setText(textArea.getText() + "\n3: LEFT");
		textArea.setText(textArea.getText() + "\n4: RIGHT");
		textStats();
		keys = true;
		return takeInput(1, 4);
	}

	@Override
	public int exitOptions() {
		textArea.setText("1: SAVE GAME");
		textArea.setText(textArea.getText() + "\n2. LOAD GAME");
		textArea.setText(textArea.getText() + "\n3: EXIT");
		keys = false;
		return takeInput(1, 3);
	}

	@Override
	public int hardAI() {
		textArea.setText("Please select the difficulty:");
		textArea.setText(textArea.getText() + "\n1: EASY MODE");
		textArea.setText(textArea.getText() + "\n2: HARD MODE");
		keys = false;
		return takeInput(1, 2);
	}

	public int takeInput(int lowerBound, int upperBound) {
		if(savedInput != 0  && regInput != 2){
			input = savedInput;
			savedInput = 0;
			saveKeyInput = false;
			return input;
		}
		
		input = -1;
		while (input < lowerBound || input > upperBound) {
			latch = new CountDownLatch(1);
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			

			if(saveKeyInput){
				switch (input) {
				case KeyEvent.VK_UP:
					savedInput = 1;
					break;
				case KeyEvent.VK_DOWN:
					savedInput = 2;
					break;
				case KeyEvent.VK_LEFT:
					savedInput = 3;
					break;
				case KeyEvent.VK_RIGHT:
					savedInput = 4;
					break;
				}
			}
			
			if (lowerBound == 0 && upperBound == 0) {
				return 0;
			}
			
			
			if (keys) {
				switch (input) {
				case KeyEvent.VK_UP:
					input = 1;
					break;
				case KeyEvent.VK_DOWN:
					input = 2;
					break;
				case KeyEvent.VK_LEFT:
					input = 3;
					break;
				case KeyEvent.VK_RIGHT:
					input = 4;
					break;
				}
			}

			if (!keys && saveKeyInput && (input >= 37 && input <= 40))
				input = 1;

			if (input > 40)
				input -= 48;
			
			
			if(saveRegInput){
				regInput = input;
				saveRegInput = false;
			}
			
		}
		
		
		textArea.setText("");
		return input;
	}

	Player player;
	Invincibility shield;
	boolean hardMode;

	@Override
	public void printGrid(Grid grid, Player player, Invincibility shield, boolean hardMode) {
		this.player = player;
		this.shield = shield;
		this.hardMode = hardMode;
		this.grid = grid;
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
	public void errorCheck(boolean room) {
		if (room == false) {
			textArea.setText("The direction you want to move is\nblocked.\n" + "Please select a different direction.");
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
		if (win) {
			textArea.setText("Congratulations!\nYou have won the game!\nPress any key to exit.");
		} else {
			textArea.setText("You have lost the game.\nPress any key to exit.");
		}
		keys = true;
		takeInput(0, 0);
	}

	@Override
	public void loseLife() {
		textArea.setText("You have lost a life.");
	}

	@Override
	public void killedNinja() {
		textArea.setText("You have killed a ninja!");
	}

	public void noBullet() {
		textArea.setText("You have no bullet to fire.\nPlease select another option.");
	}

	@Override
	public void noSaveFile() {
		textArea.setText("There was no save file found.\nPlease save a game first.");
	}

}
