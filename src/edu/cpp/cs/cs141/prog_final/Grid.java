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

import java.io.Serializable;

import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Briefcase;

/**
 * This class represents the building in which the game is played. The building
 * is represented as a two dimensional array which is stored in {@link #board}.
 * The grid holds all the positions of all objects within the game, as well as
 * the lighting.
 */
public class Grid implements Serializable {

	private static final long serialVersionUID = 2229073517795270773L;

	/**
	 * The dimension of the board. Useful so that if this needs to change, each
	 * individual value will not have to be changed
	 */
	public final int DIMENSION = 9;

	/**
	 * This is the 2D array that represents the lighting of the grid. The grid
	 * is filled with boolean values, either {@code true}, which represents an
	 * illuminated spot, or {@code false}, which represents a dark spot.
	 */
	private boolean[][] light;

	/**
	 * This is the 2D array that represents the current positions of everything
	 * in the game. These positions are represented through characters, hence
	 * the 2D char array.
	 */
	private char[][] board;

	/**
	 * Constructor for the {@link Grid} class. This will generate the board by
	 * calling {@link #generateBoards()}. The board will then be accessed by
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine}.
	 */
	public Grid() {
		generateBoards();
	}

	/**
	 * This method will generate two boards using a nested for loop. It will
	 * make the first board full of boolean light with the values of false. The
	 * second board will be created to hold empty spaces and also the permanent
	 * locations of the rooms. The letter 'R' represents the rooms that are in
	 * the middle of every 9 squares.
	 */
	private void generateBoards() {
		board = new char[DIMENSION][DIMENSION];
		light = new boolean[DIMENSION][DIMENSION];
		for (int row1 = 0; row1 < DIMENSION; row1++) {
			for (int col1 = 0; col1 < DIMENSION; col1++) {
				board[row1][col1] = ' ';
			}
		}
		for (int row2 = 0; row2 < DIMENSION; row2++) {
			for (int col2 = 0; col2 < DIMENSION; col2++) {
				light[row2][col2] = false;
			}
		}

		board[1][1] = 'R';
		board[1][4] = 'R';
		board[1][7] = 'R';
		board[4][1] = 'R';
		board[4][4] = 'R';
		board[4][7] = 'R';
		board[7][1] = 'R';
		board[7][4] = 'R';
		board[7][7] = 'R';
		roomLighting();
	}

	/**
	 * This method looks in a specified direction to reveal the spaces that are
	 * two ahead of the player.
	 * 
	 * @param x
	 *            the x coord of the player
	 * @param y
	 *            the y coord of the player
	 * @param direction
	 *            the direction to look
	 */
	public void look(int x, int y, int direction) {

		switch (direction) {
		case 0:
			if (x - 1 >= 0 && (board[x - 1][y] == 'R' || board[x - 1][y] == 'B')) {
				return;
			}
			if (x - 2 >= 0) {
				light[x - 2][y] = true;
				light[x - 1][y] = true;
			} else if (x - 1 >= 0)
				light[x - 1][y] = true;
			break;
		case 1:
			if (x + 1 <= 8 && (board[x + 1][y] == 'R' || board[x + 1][y] == 'B')) {
				return;
			}
			if (x + 2 <= 8) {
				light[x + 2][y] = true;
				light[x + 1][y] = true;
			} else if (x + 1 <= 8)
				light[x + 1][y] = true;
			break;
		case 2:
			if (y - 1 >= 0 && (board[x][y - 1] == 'R' || board[x][y - 1] == 'B')) {
				return;
			}
			if (y - 2 >= 0) {
				light[x][y - 2] = true;
				light[x][y - 1] = true;
			} else if (y - 1 >= 0)
				light[x][y - 1] = true;
			break;
		case 3:
			if (y + 1 <= 8 && (board[x][y + 1] == 'R' || board[x][y + 1] == 'B')) {
				return;
			}
			if (y + 2 <= 8) {
				light[x][y + 2] = true;
				light[x][y + 1] = true;
			} else if (y + 1 <= 8)
				light[x][y + 1] = true;
			break;
		}
	}

	/**
	 * This is the debug method. It is an option given to the player that will
	 * turn on all the lights in the grid and allow the player to to see
	 * everything that is happening in the grid. This method was included so
	 * that the player can assure that the game is working as expected
	 * 
	 * @param enable
	 *            {@code true} if debug mode should be on, {@code false} if it
	 *            should be off
	 * @param bCase
	 *            the briefcase object
	 * @param player
	 *            the player object
	 */
	public void debugMode(boolean enable, Briefcase bCase, Player player) {
		for (int row = 0; row < DIMENSION; row++) {
			for (int column = 0; column < DIMENSION; column++) {
				if (player.getPositionX() == row && player.getPositionY() == column)
					light[row][column] = true;
				else
					light[row][column] = enable;
			}
		}
		if (enable)
			assign(bCase.getX(), bCase.getY(), 'B');
		else {
			assign(bCase.getX(), bCase.getY(), 'R');
			roomLighting();
		}
	}

	/**
	 * This method is used to update the grid. It erases everything currently on
	 * the grid with the exception of the rooms.
	 */
	public void eraseGrid() {
		for (int row = 0; row < DIMENSION; row++) {
			for (int col = 0; col < DIMENSION; col++) {
				if (row % 3 == 1 && col % 3 == 1) {
				} else {
					board[row][col] = ' ';
				}
			}
		}
	}

	/**
	 * This method is used for the radar, and makes it so that the grid prints
	 * out the location of the briefcase.
	 * 
	 * @param briefcase
	 *            the briefcase object
	 */
	public void enableCaseLighting(Briefcase briefcase) {
		light[briefcase.getX()][briefcase.getY()] = true;
		board[briefcase.getX()][briefcase.getY()] = 'B';
	}

	/**
	 * This method is in charge of the lighting of the rooms where the rooms are
	 * located. It allows the player to see where the rooms are and make their
	 * way over to them while avoiding enemies
	 */
	public void roomLighting() {
		light[1][1] = true;
		light[1][4] = true;
		light[1][7] = true;
		light[4][1] = true;
		light[4][4] = true;
		light[4][7] = true;
		light[7][1] = true;
		light[7][4] = true;
		light[7][7] = true;
	}

	/**
	 * Gets the current game board and returns it so the
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine} can use it.
	 * 
	 * @return the board
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * This method assigns chars to certain locations on the grid
	 * 
	 * @param x
	 *            the row to assign it to
	 * @param y
	 *            the column to assign it to
	 * @param character
	 *            the character representation of the object being assigned
	 */
	public void assign(int x, int y, char character) {
		board[x][y] = character;
	}

	/**
	 * gets the current state of the grid with regards to lighting
	 * 
	 * @return the board state with regards to lighting
	 */
	public boolean[][] getLight() {
		return light;
	}
}
