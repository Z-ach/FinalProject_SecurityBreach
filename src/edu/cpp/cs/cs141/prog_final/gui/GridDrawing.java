package edu.cpp.cs.cs141.prog_final.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import edu.cpp.cs.cs141.prog_final.GUI;
import edu.cpp.cs.cs141.prog_final.Grid;

public class GridDrawing extends JPanel {

	private Grid grid;
	
	
	private int beingRadius = 60, beingRowSpacer = 5, beingColSpacer = 160;
	
	private int powerupRadius = 40, powerupRowSpacer = 15, powerupColSpacer = 170;
	
	private Color playerColor = Color.BLUE;
	private Color ninjaColor = Color.RED;
	private Color roomColor = Color.GREEN;
	private Color briefcaseColor = Color.BLUE;
	
	private Color shieldColor = Color.ORANGE;
	private Color radarColor = Color.MAGENTA;
	private Color bulletColor = Color.PINK;


	public GridDrawing(Grid grid) {
		this.grid = grid;
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < 10; i++) {
			g.drawLine(155 + 70 * i, 0, 155 + 70 * i, GUI.HEIGHT);
			g.drawLine(155, 70 * i, GUI.WIDTH, 70 * i);
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				g.drawString((165 + 70 * j) + ", " + (40 + 70*i), (165 + 70 * j), (40 + 70*i));
				//System.out.println("ran " + (120 + 70 * j) + ", " + (35 + 70*i));
			}
		}
		boolean printHere = false;
		for(int row = 0; row < 9; row++){
			for(int col = 0; col < 9; col++){
				printHere = false;
				switch(grid.getBoard()[row][col]){
				case 'B':
					g.setColor(briefcaseColor);
					g.fillOval(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
					System.out.println("bcase at " + row + ", " + col);
					printHere = true;
					break;
				case 'P':
					g.setColor(playerColor);
					g.fillOval(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
					System.out.println("player at " + row + ", " + col);
					printHere = true;
					break;
				case 'R':
					g.setColor(roomColor);
					g.fillRect(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
					System.out.println("room at " + row + ", " + col);
					printHere = true;
					break;
				case 'i':
					g.setColor(shieldColor);
					g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius, powerupRadius);
					System.out.println("shield at " + row + ", " + col);
					printHere = true;
					break;
				case 'b':
					g.setColor(bulletColor);
					g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius, powerupRadius);
					System.out.println("bullet at " + row + ", " + col);
					printHere = true;
					break;
				case 'r':
					g.setColor(radarColor);
					g.fillRect(powerupColSpacer + (col * 70), powerupRowSpacer + (row * 70), powerupRadius, powerupRadius);
					System.out.println("radar at " + row + ", " + col);
					printHere = true;
					break;
				case 'N':
					g.setColor(ninjaColor);
					g.fillOval(beingColSpacer + (col * 70), beingRowSpacer + (row * 70), beingRadius, beingRadius);
					System.out.println("ninja at " + row + ", " + col);
					printHere = true;
					break;
				}
				System.out.println("Just checked row: " + row + ", col: " + col + "\tValue at this location is: " + grid.getBoard()[row][col]);
				System.out.println();
				System.out.println("Printed here? " + printHere);
			}
		}
		
	}
}
