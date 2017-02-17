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
import java.util.Random;

import edu.cpp.cs.cs141.prog_final.beings.Ninja;
import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Briefcase;
import edu.cpp.cs.cs141.prog_final.items.Bullet;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;
import edu.cpp.cs.cs141.prog_final.items.Item;
import edu.cpp.cs.cs141.prog_final.items.Radar;

/**
 * This class runs the game based on what the player inputs. It incorporates the
 * Random generator utility to randomize the movement of the six ninjas. It
 * keeps track of the instances of the game with methods to check for items,
 * run, or restart the game.
 */
public class GameEngine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 98574817743469133L;

	/**
	 * This field of Random allows the object "rand" created from the imported
	 * java utility {@link java.util.Random} to randomize and move the positions
	 * of objects within the grid. The object "rand" will move the ninja with
	 * equal chance of moving in each direction.
	 */
	private Random rand;

	/**
	 * This field creates a radar item from the Radar class
	 * the player with the location of the briefcase.
	 */
	private Radar radar;

	/**
	 * This field creates an invincibility item from the Invincibility class
	 * {@link edu.cpp.cs.cs141.prog_final.items.Invincibility} that will grant
	 * the player a shield for five turns.
	 */
	private Invincibility invinc;

	/**
	 * This field creates a bullet from the Bullet class 
	 * {@link edu.cpp.cs.cs141.prog_final.items.Bullet} that will
	 * give the player a bullet if he or she does not have one. 
	 */
	private Bullet bullet;

	/**
	 * This field initializes a grid from the Grid.java class
	 * {@link edu.cpp.cs.cs141.prog_final.Grid} and calls the new object grid.
	 * This is used to call create the board from calling the method that makes
	 * the 9 by 9 grid of objects.
	 */
	private Grid grid;

	/**
	 * This field ninjas which will hold the ninjas and randomly distribute them
	 * onto the grid from here. It would make more sense for the engine to have
	 * this field because it would use the random generator to distribute the
	 * ninjas instead of distributing them in the grid and calling it.
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
	 * {@link edu.cpp.cs.cs141.Player} class. This means the player is being
	 * held in the grid, moves based on the input from the User interface but is
	 * operated in the engine. Just like the ninja class, the player class is
	 * moved in the engine but the movement is based on what is inputted in the
	 * user interface when the method movePlayer is called.
	 */
	private Player player;

	private Briefcase briefcase;

	/**
	 * This is the constructor for the game engine class and it instantiates all
	 * the fields, which are the objects from other class. It only creates the
	 * instances of the new objects but does not use them. Therefore, when the
	 * Main method calls this, it creates a new object to represent the engine,
	 * the game would be able to run based on the user input taken from
	 * {@link edu.cpp.cs.cs141.prog_final.UserInterface}
	 */
	public GameEngine(UserInterface ui) {
		this.ui = ui;
		grid = new Grid();
		rand = new Random();
	}

	/**
	 * This method runs the game. It will have a loop with a condition of a
	 * boolean value to check if the game is able to continue. It will be in a
	 * while loop, and in the beginning of the game, the boolean value from the
	 * method {@link #continueGame()} will be set at {@code false} and return
	 * {@code false}. While the condition will be set here for the loop, it will
	 * be checked in the later method.
	 */
	public void run() {
		createBoard();
	}

	/**
	 * This method is used to move the player. It will be called from the game
	 * loop, and the arguments will be based on input from the UI
	 * {@link edu.cpp.cs.cs141.prog_final.UserInterface} and will move the
	 * player object in the direction the player desires. This method can be
	 * used to move an integer of spaces in the array, but will be set to 1 as
	 * the game is further developed.
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
	 * 
	 * @return the {@link edu.cpp.cs.cs141.prog_final.items.Item} on the grid
	 *         space where the player is. {@code null} if none.
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
	 * 
	 * @return {@code true} if the move is valid, {@code false} if invalid
	 */
	public boolean isValidMove() {
		return false;
	}

	/**
	 * This method is used in the run method to check the condition for the game
	 * to continue. The things that will be in here will return the a boolean
	 * value. As of right now, it will return a value of false, but as the game
	 * is more developed there will be conditions that are checked.
	 * 
	 * @return {@code true} if the game should continue, {@code false} if the
	 *         game should end.
	 */
	public boolean continueGame() {
		return false;
	}

	public void createBoard() {
		assignBriefcase();
		assignRadar();
		assignBullet();
		assignInvincibility();
		assignNinja();
		grid.debugMode(true, briefcase);
		ui.printGrid(grid.getBoard(), grid.getLight());
	}

	public void assignBriefcase() {
		int check = rand.nextInt(9);
		switch (check) {
		case 0:
			grid.assign(1, 1, 'B');
			briefcase = new Briefcase(1, 1);
			break;
		case 1:
			grid.assign(1, 4, 'B');
			briefcase = new Briefcase(1, 4);
			break;
		case 2:
			grid.assign(1, 7, 'B');
			briefcase = new Briefcase(1, 7);
			break;
		case 3:
			grid.assign(4, 1, 'B');
			briefcase = new Briefcase(4, 1);
			break;
		case 4:
			grid.assign(4, 4, 'B');
			briefcase = new Briefcase(4, 4);
			break;
		case 5:
			grid.assign(4, 7, 'B');
			briefcase = new Briefcase(4, 7);
			break;
		case 6:
			grid.assign(7, 1, 'B');
			briefcase = new Briefcase(7, 1);
			break;
		case 7:
			grid.assign(7, 4, 'B');
			briefcase = new Briefcase(7, 4);
			break;
		case 8:
			grid.assign(7, 7, 'B');
			briefcase = new Briefcase(7, 7);
			break;
		}
	}

	public void assignNinja() {
		ninjas = new Ninja[6];
		for (int c = 0; c < 6; c++) {
			while (ninjas[c] == null) {
				int row = rand.nextInt(9);
				int col = rand.nextInt(9);
				if (!((row - 3 > 2) && (col < 3)) && (row % 3 != 1 && col % 3 != 1)
						&& (grid.getBoard()[row][col] == ' ')) {
					grid.assign(row, col, 'N');
					ninjas[c] = new Ninja(row, col);
				}
			}
		}
	}
	
	

	/**
	 * This method will place the Radar item drop on a random position on the grid.
	 * Before the item is placed there, this method checks if there is an existing item(s),
	 * player or room before it places the Radar item down. If it is an empty space, it will place 
	 * the item on that specific (x,y) coordinate. 
	 */
	
	public void assignRadar() {
		boolean valid = false;

		while (!valid) {

			int row = rand.nextInt(9);
			int col = rand.nextInt(9);

			if (grid.getBoard()[row][col] == ' ' && (!(row == 8 && col == 0))) {
				grid.assign(row, col, 'r');
				radar = new Radar(row, col);
				valid = true;
			}
		}
	}
	
	/**
	 * This method will place the Bullet item drop on a random position on the grid.
	 * Before the item is placed on the spot, it will check if there is another item(s),
	 * player or room that exist on the spot. If it is an empty space on the grid, it will
	 * place the item there.  
	 */

	public void assignBullet() {

		boolean valid = false;

		while (!valid) {

			int row = rand.nextInt(9);
			int col = rand.nextInt(9);

			if (grid.getBoard()[row][col] == ' ' && (!(row == 8 && col == 0))) {
				grid.assign(row, col, 'b');
				bullet = new Bullet(row, col);
				valid = true;
			}
		}
	}

	
	/**
	 * This method will place the Invincibility item drop on a random position
	 * on the grid. It will check to see if any existing item(s), player, or room
	 * is on the selected coordinate. If it is an empty space, it will place it there.
	 */
	
	public void assignInvincibility() {

		boolean valid = false;

		while (!valid) {

			int row = rand.nextInt(9);
			int col = rand.nextInt(9);

			if (grid.getBoard()[row][col] == ' ' && (!(row == 8 && col == 0))) {
				grid.assign(row, col, 'I');
				invinc = new Invincibility(row, col);
				valid = true;
			}
		}
	}
}
