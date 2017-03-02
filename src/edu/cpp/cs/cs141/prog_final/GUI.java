package edu.cpp.cs.cs141.prog_final;

import javax.swing.JFrame;

public class GUI extends JFrame {
	
	private final int WIDTH = 600, HEIGHT = 600;
	
	public GUI(UserInterface ui){
		JFrame frame = new JFrame("Security Breach");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
