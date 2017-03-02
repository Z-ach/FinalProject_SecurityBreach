package edu.cpp.cs.cs141.prog_final.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import edu.cpp.cs.cs141.prog_final.GUI;

public class GridDrawing extends JPanel {

	public GridDrawing() {

	}

	int x = 85;

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 1; i <= 10; i++) {
			g.drawLine(x + 70 * i, 0, x + 70 * i, GUI.HEIGHT);
			g.drawLine(155, 70 * i, GUI.WIDTH, 70 * i);
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				g.drawString((165 + 70 * j) + ", " + (40 + 70*i), (165 + 70 * j), (40 + 70*i));
				//System.out.println("ran " + (120 + 70 * j) + ", " + (35 + 70*i));
			}
		}
		
	}
}
