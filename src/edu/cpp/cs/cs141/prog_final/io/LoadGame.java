/**
 * CS 141: Intro to Programming and Problem Solving Professor: Edwin
 * Rodríguez
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

import java.util.Scanner;

/**
 * This class will be responsible for restoring a previously saved game state.
 * The class contains methods that will read an old game state from a file, then
 * parse that information, and generate a board and game state that is identical
 * to the one that is saved in the file.
 */
public class LoadGame {

	/**
	 * This field represents the two dimensional array of integers that
	 * represent the old state of the game that was stored in the file. The int
	 * values within this array correspond to different objects within the game.
	 */
	private int[][] boardState;

	/**
	 * This field represents a {@link java.util.Scanner} object that will read
	 * the file line by line.
	 */
	private Scanner reader;

	/**
	 * This method will initialize the necessary fields that will be required to
	 * restore the game to the previous state that was stored in the file.
	 * 
	 * @param fileName
	 *            the name of the file the game will be loaded from
	 */
	public LoadGame(String fileName) {

	}

	/**
	 * This method will read in the state of the game from the file and parse it
	 * into the two dimensional array represented by {@link #boardState}.
	 * 
	 * @return the old board state that was saved in the file, now as a two
	 *         dimensional array
	 */
	public int[][] readBoardState() {
		return boardState;
	}

	/**
	 * This method takes in the two dimensional array holding the old state of
	 * the board and assigns the values in the array that represent various
	 * objects to actual objects in the game.
	 * 
	 * @param saveState
	 *            the old state of the game that will be used to assign objects
	 *            to the new game board
	 */
	public void restoreActualGrid(int[][] saveState) {

	}

}