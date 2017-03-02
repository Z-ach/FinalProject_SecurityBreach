package edu.cpp.cs.cs141.prog_final.gui;

import java.awt.Color;
import java.awt.Graphics;

import edu.cpp.cs.cs141.prog_final.beings.Ninja;

public class NinjaDrawing extends Drawing{

	private static final long serialVersionUID = 1L;
	
	private static int HEIGHT = 60, WIDTH = 60;
	private int rowSpacer = 5, colSpacer = 160;
	
	public NinjaDrawing(Ninja ninja) {
		super(ninja, WIDTH, HEIGHT);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillOval(colSpacer + (being.getPositionX() * 70), rowSpacer + (being.getPositionY() * 70), WIDTH, HEIGHT);
	}


}
