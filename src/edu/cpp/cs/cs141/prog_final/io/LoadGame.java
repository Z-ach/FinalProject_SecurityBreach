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

/**
 * This class is responsible for restoring a previously saved game state. The
 * class contains methods that will read an old game state from a file, then
 * retrieve it, and then the game will be restored.
 */
public class LoadGame {

	/**
	 * This field represents the file that the game will load from. It is used
	 * to interact with the file, and is passed in as a parameter for
	 * {@link #fis}, the FileInputStream.
	 */
	private File saveFile;

	/**
	 * This field represents the FileInputStream object, and is used to retrieve
	 * data from the file that is specified in the field's instantiation. In
	 * this case, it is interacting with {@link #saveFile}.
	 */
	private FileInputStream fis;

	/**
	 * This field represents the ObjectInputStream that is used to retrieve the
	 * serialized objects stored in the save file. In this instance, it will
	 * retrieve the {@link edu.cpp.cs.cs141.prog_final.GameEngine} object.
	 */
	private ObjectInputStream ois;

	/**
	 * This field represents the {@link edu.cpp.cs.cs141.prog_final.GameEngine}
	 * object that is trying to be deserialized. It is initially {@code null},
	 * and will be set to the retrieved game state when it has been read in.
	 */
	private GameEngine game = null;

	/**
	 * This is the constructor for {@link LoadGame}. It takes in the name of a
	 * file, and creates a {@link java.io.File} with the name specified by the
	 * parameter. It then calls the {@link #restoreGame()} method.
	 * 
	 * @param fileName
	 *            the name of the file to restore the game from
	 */
	public LoadGame(String fileName) {
		saveFile = new File(fileName);
	}

	/**
	 * This method checks to ensure that the file trying to be loaded from
	 * exists.
	 * 
	 * @return whether or not the file to load from exists
	 */
	public boolean fileFound() {
		return saveFile.exists();
	}

	/**
	 * This method attempts to load a saved game state from a file. If the
	 * object trying to be loaded isn't found, or the File does not exist, the
	 * exception will be caught and handled with a try catch. After the game has
	 * been restored, it is stored temporarily in {@link #game}, and then the
	 * FileInputStream {@link #fis} and the ObjectInputStream {@link #ois} are
	 * both closed to prevent memory leaks.
	 * 
	 * @return the retrieved {@link edu.cpp.cs.cs141.prog_final.GameEngine}
	 *         object
	 */
	public GameEngine restoreGame() {

		try {
			fis = new FileInputStream(saveFile);
			ois = new ObjectInputStream(fis);

			game = (GameEngine) ois.readObject();

			fis.close();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return game;
	}

}