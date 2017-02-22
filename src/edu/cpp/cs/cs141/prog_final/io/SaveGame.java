/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Final Group Project (Security Breach)
 *
 * Description of assignment: Our group is making a text-based game called
 * Security Breach. The player starts out with at the bottom left of a 9x9
 * grid room. 9 out of 81 rooms will contain a briefcase with classified
 * information that the player needs to retrieve. The 9 rooms with the
 * briefcase will be evenly distributed throughout the 9x9 grid room.
 * However, all the rooms in the building are dark. The player is equipped
 * with night-vision goggles which allows him or her to see two squares
 * ahead of him. It will not be easy for the player to advance through the
 * map because there are 6 ninja-assassins patrolling the building. If a
 * ninja-assassin ends up in the same room as the player, the player will be
 * stabbed loses a life. The player start out with 3 lives. Everytime a life
 * is lost, the player is sent back to the beginning where he or she first
 * started off. The player can protect himself by shooting his gun in any
 * direction. If the bullet hits a ninja-assassin(s), it will die and be
 * eliminated from game. To help the player, there are three power-up items
 * that are randomly placed throughout the grid. This includes a
 * invicibility shield (protects player from stabbing for 5 turns), radar
 * (display location of the briefcase), and bullet drop (player can only
 * have one bullet on him. If this item is picked up with the character
 * still having a bullet, the effect will be negated).
 * 
 * Team: We showed up
 * 
 * Team members: Bryan Ayala, Annalyn Edulag, Kelvin Huang, Zachary Kaufman,
 * Michael Jason Yan
 * 
 */
package edu.cpp.cs.cs141.prog_final.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import edu.cpp.cs.cs141.prog_final.Grid;
import edu.cpp.cs.cs141.prog_final.beings.Ninja;
import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Briefcase;
import edu.cpp.cs.cs141.prog_final.items.Bullet;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;
import edu.cpp.cs.cs141.prog_final.items.Radar;

/**
 * This class is designed to save the state of the game to a file. The state of
 * the game will first be parsed so that it can be recorded to a file. The text
 * will then be written to a file in a specific manner so that the file can be
 * loaded and played at a later date.
 */
public class SaveGame {

	/**
	 * This field represents an object of type {@link java.io.PrintWriter} This
	 * is used to print the state of the game into a file.
	 */
	private FileOutputStream fileStream;
	private ObjectOutputStream objStream;
	private File file;

	/**
	 * Constructor for {@link SaveGame}. This will make the necessary
	 * initializations that will be required to save the state of the game.
	 * 
	 * @param fileName
	 *            the name of the file that the game will be saved to
	 */
	public SaveGame(String fileName, Ninja[] n, Player p, Radar r, Invincibility inv, Briefcase b, Bullet bul,
			Grid grid) {
		try {
			file = new File(fileName);
			fileStream = new FileOutputStream(file);
			objStream = new ObjectOutputStream(fileStream);
			
			objStream.writeObject(n);
			objStream.writeObject(p);
			objStream.writeObject(r);
			objStream.writeObject(inv);
			objStream.writeObject(b);
			objStream.writeObject(bul);
			objStream.writeObject(grid);
			System.out.println("saved to " + fileName);
		}
		// CHANGE EXCEPTION
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will do the physical writing to the file. The grid will be
	 * passed in as an argument, which will be used in the method call to
	 * {@link #parseState(Grid)}. The method will then print all data into a
	 * file.
	 * 
	 * @param grid
	 *            the game's grid
	 */
	public void writeToFile() {

	}

}