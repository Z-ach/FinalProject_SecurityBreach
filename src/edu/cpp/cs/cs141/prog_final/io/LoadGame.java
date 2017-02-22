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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import edu.cpp.cs.cs141.prog_final.GameEngine;
import edu.cpp.cs.cs141.prog_final.Grid;
import edu.cpp.cs.cs141.prog_final.beings.Ninja;
import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Briefcase;
import edu.cpp.cs.cs141.prog_final.items.Bullet;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;
import edu.cpp.cs.cs141.prog_final.items.Radar;

/**
 * This class will be responsible for restoring a previously saved game state.
 * The class contains methods that will read an old game state from a file, then
 * parse that information, and generate a board and game state that is identical
 * to the one that is saved in the file.
 */
public class LoadGame {

	/**
	 * This method will initialize the necessary fields that will be required to
	 * restore the game to the previous state that was stored in the file.
	 * 
	 * @param fileName
	 *            the name of the file the game will be loaded from
	 */
	public LoadGame(String fileName) {

	}

	private FileInputStream fileStream;
	private ObjectInputStream objStream;
	private File file;

	/**
	 * Constructor for {@link SaveGame}. This will make the necessary
	 * initializations that will be required to save the state of the game.
	 * 
	 * @param fileName
	 *            the name of the file that the game will be saved to
	 */
	public LoadGame(String fileName, GameEngine ge) {
		try {
			file = new File(fileName);
			fileStream = new FileInputStream(file);
			objStream = new ObjectInputStream(fileStream);
		}
		// CHANGE EXCEPTION
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Ninja[] getNinjas() throws ClassNotFoundException, IOException {
		return (Ninja[]) objStream.readObject();
	}

	public Player getPlayer() throws ClassNotFoundException, IOException {
		return (Player) objStream.readObject();
	}

	public Radar getRadar() throws ClassNotFoundException, IOException {
		return (Radar) objStream.readObject();
	}

	public Invincibility getInv() throws ClassNotFoundException, IOException {
		return (Invincibility) objStream.readObject();
	}

	public Briefcase getBrief() throws ClassNotFoundException, IOException {
		return (Briefcase) objStream.readObject();
	}

	public Bullet getBullet() throws ClassNotFoundException, IOException {
		return (Bullet) objStream.readObject();
	}

	public Grid getGrid() throws ClassNotFoundException, IOException {
		return (Grid) objStream.readObject();
	}
}