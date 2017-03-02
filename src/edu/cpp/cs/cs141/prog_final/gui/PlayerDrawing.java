package edu.cpp.cs.cs141.prog_final.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import edu.cpp.cs.cs141.prog_final.beings.Player;

public class PlayerDrawing extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6543377579465839127L;
	private Player player;
	private int HEIGHT = 60, WIDTH = 60;
	private int rowSpacer = 5, colSpacer = 160;
	
	public PlayerDrawing(Player player){
		this.player = player;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		g.fillOval(colSpacer + (player.getPositionX() * 70), rowSpacer + (player.getPositionY() * 70), WIDTH, HEIGHT);
	}
	
}
