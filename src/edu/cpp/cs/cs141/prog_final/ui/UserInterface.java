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
