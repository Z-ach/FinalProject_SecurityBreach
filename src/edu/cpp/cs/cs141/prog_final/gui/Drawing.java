package edu.cpp.cs.cs141.prog_final.gui;

import javax.swing.JPanel;

import edu.cpp.cs.cs141.prog_final.beings.LivingBeing;

public abstract class Drawing extends JPanel {

	private static final long serialVersionUID = -1587816016027281520L;

	protected int xPos, yPos;

	protected int width, height;

	protected LivingBeing being;

	public Drawing(int x, int y, int width, int height) {
		xPos = x;
		yPos = y;
	}

	public Drawing(LivingBeing being, int width, int height) {
		this.being = being;
	}

	public void update(int x, int y) {
		if (being == null) {
			xPos = x;
			yPos = y;
		} else {
			xPos = being.getPositionX();
			yPos = being.getPositionY();
		}
	}

}
