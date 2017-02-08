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
package edu.cpp.cs.cs141.prog_final.ui;

import java.util.Scanner;

/**
 * The UserInterface class represents the game interactions with the player
 * throughout the game. The user is greeted with instructions, the grid is
 * printed for the game to begin which then shows the options for the player to
 * move, shoot, or debug, save or exit the game, status of powerups and bullets,
 * and the end result of the game is displayed.
 */
public class UserInterface {

	/**
	 * This field represents the {@link java.util.Scanner} object that creates
	 * the scanner that will take the user input to play the game and to print
	 * each of the objects within the game to the user.
	 */
	private Scanner input;

	/**
	 * The default constructor for the class {@link UserInterface}. This
	 * constructor will allow for the
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine} to display the game
	 * outputs to the user. Necessary things will be initialized here, such as
	 * {@link #input}
	 * 
	 */
	public UserInterface() {

	}

	/**
	 * This method represents the {@link #instruction()} of how to play the game to
	 * the user. The field will explain to the user what keys to use to play the
	 * game, what the powerups do, and the end objective to find the hidden
	 * briefcase through describing the setting.
	 */
	public void instruction() {

	}

	/**
	 * This method represents the {@link #playerOptions()} prints out the player's
	 * options of looking, shooting, and debugging. These options will be
	 * displayed
	 */
	public void playerOptions() {

	}

	/**
	 * This method represents the {@link #exitOptions()} that will allow for the
	 * player to either save the game or exit. These options will be available
	 * to the player throughout the game.
	 */
	public void exitOptions() {

	}

	/**
	 * This method will {@link takeInput()} from the player through asking the
	 * player to enter their desired options of looking, shooting, debugging,
	 * saving the game, loading a game, or exiting.
	 */
	public void takeInput() {

	}

	/**
	 * This method represents the {@link #printGrid()} which serves as the base
	 * view of the game that will hold each of the objects. The player must
	 * navigate through the grid in order to play.
	 */
	public void printGrid() {

	}

	/**
	 * This method {@link #displayInfo()} represents the status of lives that the
	 * user has and notifies the user if any power ups are being used during the
	 * player's turn.
	 */
	public void displayInfo() {

	}

	/**
	 * The method of {@link #saveGame()} represents what the system will ask after
	 * they choose the option to save the game. The input for a file name will
	 * be asked from the player in order to successfully save it.
	 */
	public void saveGame() {

	}

	/**
	 * This method represents the {@link #debug()} option that allows for the all
	 * components of the grid to be visible. Debug mode option will be available
	 * for the player throughout the game.
	 */
	public void debug() {

	}

	/**
	 * This method represents the {@link #errorCheck()} to display an error message
	 * when the user attempts to move in directions that are outside the grid
	 * space.
	 */
	public void errorCheck() {

	}

	/**
	 * This method is {@code true} if the character has found the briefcase and
	 * the message telling the character has won. If {@code false}, the system
	 * tells the user that the game is over.
	 */
	public void endMessage(boolean win) {

	}

	/**
	 * The method represents when the character will {@link #loseLife()} when they
	 * are stabbed by a ninja. The system will tell the character that they have
	 * lost a life and have respawned to their initial placement on the grid.
	 */
	public void loseLife() {

	}

	/**
	 * This method represents the {@link #briefCase(boolean)} that needs to be found by
	 * the player in order to win the game. If {@code true} then the message
	 * tells the player that they have successfully found the briefcase.
	 */
	public void briefCase(boolean hasCase) {

	}
}
