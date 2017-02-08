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
package edu.cpp.cs.cs141.prog_final.grid;

import java.util.ArrayList;

/**
 * This class represents the building in which the game is played. The building
 * is represented as a two dimensional array which is stored in {@link #board}.
 * The grid holds all the objects and position of those objects within the game.
 */
public class Grid {

	/**
	 * This field represents the building that the player starts in. This is a
	 * two dimensional array that holds objects, and will hold
	 * {@link edu.cpp.cs.cs141.prog_final.beings.LivingBeing}s and
	 * {@link edu.cpp.cs.cs141.prog_final.items.Item}s. The board will hold the
	 * position of all entities in the game.
	 */
	private Object[][] board;

	/**
	 * This field represents the location of the rooms in the building. This
	 * field will be used when generating the board to obtain the locations that
	 * will be initialized to prevent the player from entering. One of these
	 * rooms will contain the briefcase.
	 */
	private ArrayList<int[][]> rooms;

	/**
	 * Constructor for the {@link Grid} class. This will generate the board by
	 * calling {@link Grid#generateBoard()}. The board will then be accessed by
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine}.
	 */
	public Grid() {

	}

	/**
	 * This method will generate the board using a nested for loop. It will make
	 * the board full of null at first. The board will then be modified by other
	 * methods in this class.
	 */
	private void generateBoard() {

	}

	/**
	 * This method takes the object passed in as an argument and places them in
	 * the location in the board based on what position is passed in as an
	 * argument.
	 * 
	 * @param position
	 *            the location to insert the object
	 * @param obj
	 *            the object to insert into the board
	 */
	private void assign(int[][] position, Object obj) {

	}

	/**
	 * Gets the current game board and returns it so the
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine} can use it.
	 * 
	 * @return the board
	 */
	public Object[][] getBoard() {
		return board;
	}

}
