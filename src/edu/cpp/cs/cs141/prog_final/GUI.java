package edu.cpp.cs.cs141.prog_final;

import java.awt.Graphics;

import javax.swing.JPanel;

import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.gui.GridDrawing;
import edu.cpp.cs.cs141.prog_final.gui.NinjaDrawing;
import edu.cpp.cs.cs141.prog_final.gui.PlayerDrawing;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;

public class GUI extends JPanel implements UserInterface {

	private static final long serialVersionUID = -1901275594602421699L;
	
	public static final int WIDTH = 800, HEIGHT = 670;
	
	private PlayerDrawing playerD;
	private NinjaDrawing ninjaD;
	private GridDrawing gridD;
	
	public GUI(){
		this.requestFocus();
		gridD = new GridDrawing();
		update();
	}
	
	public void update(){
		repaint();
	}

	protected void paintComponent(Graphics g) {
/*		super.paintComponent(g);
		for (int i = 1; i <= 10; i++) {
			g.drawLine(85 + 70 * i, 0, 85 + 70 * i, HEIGHT);
			g.drawLine(155, 70 * i, WIDTH, 70 * i);
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				g.drawString((165 + 70 * j) + ", " + (40 + 70*i), (165 + 70 * j), (40 + 70*i));
				//System.out.println("ran " + (120 + 70 * j) + ", " + (35 + 70*i));
			}
		}*/
		
		super.paintComponent(g);
		gridD.paint(g);

		
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

	@Override
	public int playerOptions(boolean looking) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int direction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int exitOptions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hardAI() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int takeInput(int lowerBound, int upperBound) {
		int validInput = -1;
		boolean valid = false;
		while (validInput == -1) {
/*			if (input.hasNextInt()) {
				validInput = input.nextInt();
				valid = true;
			}*/
			if (validInput < lowerBound || validInput > upperBound) {
				System.out.println("Input is not a valid number!");
				if (!valid)
					//input.next();
				validInput = -1;
			}
		}
		return validInput;
	}

	@Override
	public void printGrid(char[][] grid, boolean[][] lighting, Player player, Invincibility shield, boolean hardMode) {
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void briefCase(boolean hasCase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killedNinja() {
		// TODO Auto-generated method stub
		
	}
	
}
