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

public interface UserInterface {

	/**
	 * This method represents the {@link #instruction()} of how to play the game
	 * to the user. The field will explain to the user what keys to use to play
	 * the game, what the powerups do, and the end objective to find the hidden
	 * briefcase through describing the setting.
	 */
	public void instruction();

	/**
	 * This method represents the {link {@link #gameStartPrompt()} that will
	 * give the player three options of starting a game, loading a game, or
	 * exiting the game.
	 */
	public int gameStartPrompt();

	/**
	 * This method represents the {@link #playerOptions()} prints out the
	 * player's options of looking, shooting, and debugging. These options will
	 * be displayed
	 */
	public int playerOptions(boolean looking);

	/**
	 * This method represents {@link #direction()}, which is the movement option
	 * for the player. The user will press the corresponding number (1,2,3,4) to
	 * move the player around the grid.
	 */
	public int direction();

	/**
	 * This method represents the {@link #exitOptions()} that will allow for the
	 * player to either save the game or exit. These options will be available
	 * to the player throughout the game.
	 */
	public int exitOptions();

	/**
	 * This method is called in the beginning of the game right after the "start
	 * game" option is chosen. It allows the player to choose which mode the
	 * player wishes to play in. When returning hard mode, it will call a method
	 * which moves the ninjas differently compared to easy mode. It will return
	 * only 1 or 2. @return
	 */
	public int hardAI();

	/**
	 * This method will {@link takeInput()} from the player through asking the
	 * player to enter their desired options of looking, shooting, debugging,
	 * saving the game, loading a game, or exiting.
	 */
	public int takeInput(int lowBound, int highBound, boolean keys);

	/**
	 * This method represents the {@link #printGrid()} which serves as the base
	 * view of the game that will hold each of the objects. The player must
	 * navigate through the grid in order to play.
	 * 
	 * This method {@link #displayInfo()} represents the status of lives that
	 * the user has and notifies the user if any power ups are being used during
	 * the player's turn.
	 */
	public void printGrid(Grid grid, Player player, Invincibility shield, boolean hardMode);

	/**
	 * This method represents the {@link #errorCheck()} to display an error
	 * message when the user attempts to move in directions that are outside the
	 * grid space, or when the player tries to move into a room from the wrong
	 * direction
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
	 * This method is {@code true} if the character has found the briefcase and
	 * the message telling the character has won. If {@code false}, the system
	 * tells the user that the game is over.
	 */
	public void endMessage(boolean win);

	/**
	 * The method represents when the character will {@link #loseLife()} when
	 * they are stabbed by a ninja. The system will tell the character that they
	 * have lost a life and have respawned to their initial placement on the
	 * grid.
	 */
	public void loseLife();

	/**
	 * This method will display a kill message to the user when the user shoots
	 * the bullet and kills the ninja. This method will be passed into the Game
	 * Engine under {@link #shootCheck()}
	 */
	public void killedNinja();

	/**
	 * This method is called whenever the player tries to shoot and has no
	 * bullets. It will display a message telling the player to try again; which
	 * means the player cannot fire and is required to do something else.
	 */
	public void noBullet();

}
