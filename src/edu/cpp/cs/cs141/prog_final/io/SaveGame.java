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
import java.io.IOException;
import java.io.ObjectOutputStream;

import edu.cpp.cs.cs141.prog_final.GameEngine;

/**
 * This class is designed to save the state of the game to a file. It uses
 * Serialization to achieve this goal. The
 * {@link edu.cpp.cs.cs141.prog_final.GameEngine} object is passed in as a
 * parameter of the constructor, and then a FileOutputStream and a
 * ObjectOutputStream are used to store the data.
 */
public class SaveGame {

	/**
	 * This field represents the file that the game will save to. It is used to
	 * interact with the file, and is passed in as a parameter for {@link #fos},
	 * the FileOutputStream.
	 */
	private File saveFile;

	/**
	 * This field represents the FileOutputStream object, and is used to store
	 * data to the file that is specified in the field's instantiation. In this
	 * case, it is interacting with {@link #saveFile}.
	 */
	private FileOutputStream fos;

	/**
	 * This field represents the ObjectOutputStream that is used to store
	 * specified objects. In this instance, it will store the
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine} object.
	 */
	private ObjectOutputStream oos;

	/**
	 * Constructor for {@link SaveGame}. This will make the necessary
	 * initializations that will be required to save the state of the game. This
	 * attempts to save the current game to a file. If the File does not exist,
	 * the exception will be caught and handled with a try catch. After the game
	 * has been saved, the FileOutputStream {@link #fos} and the
	 * ObjectOutputStream {@link #oos} are both closed to prevent memory leaks.
	 * 
	 * @param fileName
	 *            the name of the file that the game will be saved to
	 * @param game
	 *            the {@link edu.cpp.cs.cs141.prog_final.GameEngine} object to
	 *            save
	 */
	public SaveGame(String fileName, GameEngine game) {
		try {
			saveFile = new File(fileName);

			fos = new FileOutputStream(saveFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(game);

			fos.close();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}