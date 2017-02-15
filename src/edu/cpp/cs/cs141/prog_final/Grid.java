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
import java.util.ArrayList;

/**
 * This class represents the building in which the game is played. The building
 * is represented as a two dimensional array which is stored in {@link #board}.
 * The grid holds all the objects and position of those objects within the game.
 */
public class Grid implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7922732579776384853L;

	public final int DIMENSION = 9;

	private boolean[][] light;
	/**
	 * This field represents the building that the player starts in. This is a
	 * two dimensional array that holds objects, and will hold
	 * {@link edu.cpp.cs.cs141.prog_final.beings.LivingBeing}s and
	 * {@link edu.cpp.cs.cs141.prog_final.items.Item}s. The board will hold the
	 * position of all entities in the game.
	 */

	private char[][] board;

	/**
	 * Constructor for the {@link Grid} class. This will generate the board by
	 * calling {@link Grid#generateBoard()}. The board will then be accessed by
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
		for (int row1 = 0; row1 < DIMENSION; row1++) {
			for (int col1 = 0; col1 < DIMENSION; col1++) {
				if (board[row1][col1] == board[1][1]) {
					board[row1][col1] = 'R';
				} else if (board[row1][col1] == board[1][4]) {
					board[row1][col1] = 'R';
				} else if (board[row1][col1] == board[1][7]) {
					board[row1][col1] = 'R';
				} else if (board[row1][col1] == board[4][1]) {
					board[row1][col1] = 'R';
				} else if (board[row1][col1] == board[4][4]) {
					board[row1][col1] = 'R';
				} else if (board[row1][col1] == board[4][7]) {
					board[row1][col1] = 'R';
				} else if (board[row1][col1] == board[7][1]) {
					board[row1][col1] = 'R';
				} else if (board[row1][col1] == board[7][4]) {
					board[row1][col1] = 'R';
				} else if (board[row1][col1] == board[7][7]) {
					board[row1][col1] = 'R';
				} else {
					board[row1][col1] = ' ';
				}
			}
		}
		for (int row2 = 0; row2 < DIMENSION; row2++) {
			for (int col2 = 0; col2 < DIMENSION; col2++) {
				light[row2][col2] = false;
			}
		}
	}

	public void debugMode(boolean enable) {
		for (int row = 0; row < DIMENSION; row++) {
			for (int column = 0; column < DIMENSION; column++) {
				light[row][column] = enable;
			}
		}
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
	public void assign(int x, int y, char object){
		board[x][y] = object;
	}
}
