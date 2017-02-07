/**
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
