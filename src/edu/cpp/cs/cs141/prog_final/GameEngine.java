package edu.cpp.cs.cs141.prog_final;

import java.util.Random;

import edu.cpp.cs.cs141.prog_final.beings.Ninja;
import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.grid.Grid;
import edu.cpp.cs.cs141.prog_final.items.Item;
import edu.cpp.cs.cs141.prog_final.ui.UserInterface;

/**
 * This class runs the game based on what the player inputs. It incorporates the
 * Random generator utility to randomize the movement of the six ninjas. It
 * keeps track of the instances of the game with methods to check for items,
 * run, or restart the game.
 */
public class GameEngine {
	/**
	 * This field of Random allows the object "rand" created from the imported
	 * java utility {@link java.util.Random} to randomize and move the positions
	 * of objects within the grid. The object "rand" will move the ninja with
	 * equal chance of moving in each direction.
	 */
	private Random rand;
	/**
	 * This field initiallizes a grid from the Grid.java class
	 * {@link edu.cpp.cs.cs141.Grid} and calls the new object grid. This is used
	 * to call create the board from calling the method that makes the 9 by 9
	 * grid of objects.
	 */
	private Grid grid;
	/**
	 * This field is an array of ninjas which will hold the ninjas and randomly
	 * distribute them onto the grid from here. It would make more sense for the
	 * engine to have this field because it would use the random generator to
	 * distribute the ninjas instead of distributing them in the grid and
	 * calling it.
	 */
	private Ninja[] ninjas;
	/**
	 * This is the field will be instantiated in the constructor of the game
	 * engine. It is an array of the class ninja. {@link edu.cpp.cs.cs141.Ninja}
	 * The purpose of this is to allow the engine and user interface to
	 * communicate. Communicating in this case means passing methods back and
	 * forth. Therefore, it would allow the player to make decisions and game to
	 * run at the same time.
	 */
	private UserInterface ui;
	/**
	 * This field is the player object from the player
	 * {@link edu.cpp.cs.cs141.Player} class. This mean the player is being held
	 * in the grid, moves based on the User inteface but is operated in the
	 * engine. Just like the ninja class, the player class is moved in the
	 * engine but the movement is based on what is inputted in the user
	 * interface when the method movePlayer is called.
	 */
	private Player player;

	/**
	 * This is the constructor for the game engine class and it instantiates all
	 * the fields, which are the objects from other class. It only creates the
	 * instances of the new objects but does not use them. Therefore, when the
	 * UI calls creates a new object to represent the engine, the game would be
	 * able to run based on the user input.
	 */
	public GameEngine() {

	}

	/**
	 * This method runs the game. It will have a loop with a condition of a
	 * boolean value to check if the game is able to continue. It will be in a
	 * while loop, and in the beginning of the game, the boolean value from the
	 * method continueGame() will be set at false and return false. While the
	 * condition will be set here for the loop, it will be checked in the later
	 * method.
	 */
	public void run() {

	}

	/**
	 * This method is used to move the player. It will be called from the UI
	 * {@link edu.cpp.cs.cs141.UserInterface} and will move the player object in
	 * the direction the player desires. This method can be used to move an
	 * integer of spaces in the array, but will be set to 1 as the game is
	 * further developed.
	 */
	public void movePlayer(int direction) {

	}

	/**
	 * This method resets the player's position and will place them back into
	 * the spot where the player began. Which is the 9th row and the first
	 * column. This method will be called when the player dies or when a new
	 * game is desired. If a saved game is not loaded, clicking start in the
	 * start menu will also call this method.
	 */
	public void restartPlayer() {

	}

	/**
	 * This method moves the ninja but this movement is not based off of the
	 * player's input. This method is used to move all 6 of the ninjas right
	 * after the player is settled in a spot. It will incorporate the random
	 * number generator that will randomize the movement of each ninja.
	 */
	public void moveNinja(Ninja n) {

	}

	/**
	 * This method works similarly to the isValidMove method because it is used
	 * to check if that spot that the player is standing on is occupied with an
	 * item. It will either return a null value if the that spot in the array is
	 * occupied with something other than an item. However, if the spot is
	 * filled with an item, it will return the item name and apply to the
	 * player.
	 */
	public Item checkForItem() {
		return null;
	}

	/**
	 * This method returns a boolean value and checks if the move the player
	 * wants is a valid move. For example, when the player is in the first
	 * column, this method would prevent the player from moving further left.
	 * Also, this method is called after every other method of movePlayer to
	 * check if the move is valid.
	 */
	public boolean isValidMove() {
		return false;
	}

	/**
	 * This method is used in the run method to check the condition for the game
	 * to continue. The things that will be in here will return the a boolean
	 * value. As of right now, it will return a value of false, but as the game
	 * is more developed there will be conditions that are checked.
	 */
	public boolean continueGame() {
		return false;
	}

}
