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

import edu.cpp.cs.cs141.prog_final.Grid;
import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;

/**
 * The UserInterface is an interface that will be implemented by every class
 * that will directly interact with the player. It contains all the methods that
 * are needed and that will be used. Because the GameEngine specifies this type
 * rather than a specific type of UserInterface, the only methods it will be
 * allowed to use are in here. Therefore everything useful must be in here, and
 * anything outside of it will not be able to be called directly from the game
 * engine.
 */
public interface UserInterface {

	/**
	 * This method will display how to play the game to the user. The field will
	 * explain to the user what keys to use to play the game, what the powerups
	 * do, and the end objective to find the hidden briefcase through describing
	 * the setting.
	 */
	public void instruction();

	/**
	 * This method displays the prompts that will give the player three options
	 * of starting a game, loading a game, or exiting the game.
	 * 
	 * @return the int value representing the player's choice
	 */
	public int gameStartPrompt();

	/**
	 * This method prints out the player's options of looking, shooting, and
	 * debugging. These options will be displayed
	 * 
	 * @param looking
	 *            whether the player is looking on this turn, {@code true} for
	 *            yes, {@code false} for no
	 * @return the int value representing the player's choice
	 * 
	 */
	public int playerOptions(boolean looking);

	/**
	 * This method handles directions, which is used in the movement option and
	 * the look option. The user will press the corresponding number (1,2,3,4)
	 * to specify direction.
	 * 
	 * @return the direction specified by the player. {@code 1} for up,
	 *         {@code 2} for down, {@code 3} for left, {@code 4} for right
	 */
	public int direction();

	/**
	 * This method will display the exit options that will allow the player to
	 * either save the game or exit. These options will be available to the
	 * player throughout the game.
	 * 
	 * @return the int value representing the player's choice
	 */
	public int exitOptions();

	/**
	 * This method is called in the beginning of the game right after the
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine#run(boolean)} is called. It
	 * allows the player to choose which mode the player wishes to play in. When
	 * returning hard mode, it will call a method which moves the ninjas
	 * differently compared to easy mode.
	 * 
	 * @return the int value that represents the player's choice. {@code 1} for
	 *         easy, {@code 2} for hard
	 */
	public int hardAI();

	/**
	 * This method will take input from the player. It will ask the player to
	 * enter their input for a specified prompt, and will keep running until a
	 * valid answer is provided.
	 * 
	 * @param lowBound
	 *            the lowest number the player can pick
	 * @param highBound
	 *            the highest number the player can pick
	 * @return the int value of the player's choice
	 */
	public int takeInput(int lowBound, int highBound);

	/**
	 * This method prints the grid, which serves as the base view of the game.
	 * The player must navigate through the grid in order to play.
	 * 
	 * @param grid
	 *            the {@link edu.cpp.cs.cs141.prog_final.Grid} object
	 * @param player
	 *            the {@link edu.cpp.cs.cs141.prog_final.beings.Player} object
	 * @param shield
	 *            the {@link edu.cpp.cs.cs141.prog_final.items.Invincibility}
	 *            object
	 * @param hardMode
	 *            whether or not the game is in hard mode. {@code true} for hard
	 *            mode, {@code false} for easy mode
	 */
	public void printGrid(Grid grid, Player player, Invincibility shield, boolean hardMode);

	/**
	 * This method displays an error message when the user attempts to move in
	 * directions that are outside the grid space, or when the player tries to
	 * move into a room from the wrong direction
	 * 
	 * @param room
	 *            whether or not the movement is into a room.
	 */
	public void errorCheck(boolean room);

	/**
	 * This method displays a message letting the player know that the player
	 * has looked into the empty room and used up their turn. The purpose of
	 * this method is to notify the player that there is nothing in the room and
	 * the turn has been used up.
	 */
	public void noCase();

	/**
	 * This method notifies the player if the character has found the briefcase
	 * or has died, and prints a corresponding message.
	 * 
	 * @param win
	 *            whether or not the player has won
	 */
	public void endMessage(boolean win);

	/**
	 * The method notifies the player when they are stabbed by a ninja. The
	 * system will tell the character that they have lost a life and have
	 * respawned to their initial placement on the grid.
	 */
	public void loseLife();

	/**
	 * This method will display a kill message to the user when the user shoots
	 * the bullet and kills the ninja. This method will be called from the Game
	 * Engine
	 */
	public void killedNinja();

	/**
	 * This method is called whenever the player tries to shoot and has no
	 * bullets. It will display a message telling the player to try again; which
	 * means the player cannot fire and is required to do something else.
	 */
	public void noBullet();

	/**
	 * This method prompts the user with the information that they have not
	 * saved any file, and there can therefore be nothing to load from
	 */
	public void noSaveFile();

}
