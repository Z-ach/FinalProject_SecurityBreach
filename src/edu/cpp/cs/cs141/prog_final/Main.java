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
package edu.cpp.cs.cs141.prog_final;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

import edu.cpp.cs.cs141.prog_final.ui.GUI;
import edu.cpp.cs.cs141.prog_final.ui.TextUserInterface;
import edu.cpp.cs.cs141.prog_final.ui.UserInterface;

/**
 * This is the main class. The job of this class is to determine which type of
 * {@link edu.cpp.cs.cs141.prog_final.ui.UserInterface} to create. It will
 * create a {@link edu.cpp.cs.cs141.prog_final.ui.TextUserInterface} if there
 * are no command line arguments, and will create a
 * {@link edu.cpp.cs.cs141.prog_final.ui.GUI} if the arguments in the command
 * line are correct
 */
public class Main {

	/**
	 * This method creates an instance of the
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine} object and uses it to
	 * start the program by calling the method
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine#run(boolean)}. The
	 * UserInterface that is created will be passed into the constructor of the
	 * GameEngine.
	 * 
	 * @param args
	 *            the command line arguments to pass in. Will determine whether
	 *            a GUI is created, or a Text UI.
	 */
	public static void main(String[] args) {
		UserInterface ui = null;
		GameEngine game = null;

		if (args.length > 0 && args[0].equals("-g")) {
			JFrame frame = new JFrame("Security Breach");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(GUI.WIDTH, GUI.HEIGHT);
			frame.setMinimumSize(new Dimension(GUI.WIDTH, GUI.HEIGHT));
			frame.setLocationRelativeTo(null);
			ui = new GUI();
			frame.setResizable(false);
			frame.add((Component) ui);
			frame.pack();
			frame.setVisible(true);

			game = new GameEngine(ui);
			game.run(false);
		}

		game = new GameEngine(new TextUserInterface());
		game.run(false);

	}

}
