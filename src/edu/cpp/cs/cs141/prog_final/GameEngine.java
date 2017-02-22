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

import edu.cpp.cs.cs141.prog_final.beings.LivingBeing;
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
	 * {@link edu.cs.cs141.prog_final.items.Radar} that will grant the player
	 * with the location of the briefcase.
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
	 * {@link edu.cpp.cs.cs141.prog_final.items.Bullet} that will give the
	 * player a bullet if he or she does not have one.
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

	private boolean debugMode, radarFound;

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

	public void startPrompt() {

		int answer = ui.gameStartPrompt();

		if (answer == 1) {

			run();
		}
		if (answer == 2)

			if (answer == 3)
				System.exit(0);

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

		debugMode = true;
		boolean move = false;
		radarFound = false;
		int tempDirection = 0;

		while (player.alive()) {
			refreshGrid();
			grid.debugMode(debugMode, briefcase, player);
			if (radarFound)
				grid.enableCaseLighting(briefcase);
			ui.printGrid(grid.getBoard(), grid.getLight());
			move = false;
			switch (ui.playerOptions(true)) {
			case 1:
				grid.look(player.getPositionX(), player.getPositionY(), ui.direction() - 1);
				refreshGrid();
				ui.printGrid(grid.getBoard(), grid.getLight());
				switch (ui.playerOptions(false)) {
				case 1:
					while (!move) {
						tempDirection = ui.direction() - 1;
						if (tempDirection == 1 && roomCheckRequirement(tempDirection) && roomCheck())
							winGame();
						move = movementCheck(tempDirection, player, true);
						checkForNinja();
						if (!move)
							ui.errorCheck(false);
					}
					checkForItem();
					moveNinja();
					break;
				case 2:
					// shoot goes here
					shoot(1);
					moveNinja();
					break;
				}
				break;
			case 2:
				// shoot goes here
				shoot(1);
				moveNinja();
				break;
			case 3:
				// exit menu goes here
				break;
			case 4:
				debugMode = true;
			}
			checkForNinja();
		}
	}

	public void winGame() {
		ui.endMessage(true);
		System.exit(0);
	}

	/**
	 * This method resets the player's position and will place them back into
	 * the spot where the player began. Which is the 9th row and the first
	 * column. This method will be called when the player dies or when a new
	 * game is desired. If a saved game is not loaded, clicking start in the
	 * start menu will also call this method.
	 */
	public void restartPlayer(boolean loseLife) {
		if (player == null)
			player = new Player(8, 0);
		player.setPlayer();
		grid.assign(player.getPositionX(), player.getPositionY(), 'P');
		if (loseLife) {
			player.loseLive();
		}
	}

	/**
	 * This method moves the ninja but this movement is not based off of the
	 * player's input. This method is used to move all 6 of the ninjas right
	 * after the player is settled in a spot. It will incorporate the random
	 * number generator that will randomize the movement of each ninja.
	 */
	public void moveNinja() {
		boolean move;
		int direction;
		for (Ninja n : ninjas) {
			if (n != null) {
				move = false;
				while (!move) {
					direction = rand.nextInt(4);
					move = movementCheck(direction, n, false);
				}
			}
		}
	}

	public boolean checkForNinja() {
		for (int i = 0; i < ninjas.length; i++) {
			if (ninjas[i] != null && (!player.getShield())) {
				if (ninjas[i].getPositionX() == player.getPositionX()
						&& ninjas[i].getPositionY() == player.getPositionY()) {
					ui.loseLife();
					restartPlayer(true);
					return true;
				}
			}
		}
		return false;
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
	public void checkForItem() {
		switch (grid.getBoard()[player.getPositionX()][player.getPositionY()]) {
		case 'i':
			pickupInvinc();
			break;
		case 'r':
			pickupRadar();
			break;
		case 'b':
			pickupBullet();
			break;
		}
	}

	/**
	 * This method runs through all the necessary calls in order to create
	 * objects and assign them to the board. It also designates whether or not
	 * the initial debug mode is activated, then prints the grid using the UI.
	 * 
	 * @see #assignBriefcase()
	 * @see #assignBullet()
	 * @see #assignRadar()
	 * @see #assignNinja()
	 * @see #assignInvincibility()
	 */
	public void createBoard() {
		assignBriefcase();
		assignRadar();
		assignBullet();
		assignInvincibility();
		assignNinja();
		restartPlayer(false);
	}

	/**
	 * This method assigns a briefcase to a room at random. The briefcase is
	 * denoted as a 'B' in debug mode. The randomization is based on
	 * {@link java.util.Random}.
	 */
	public void assignBriefcase() {
		int check = rand.nextInt(9);
		check = 6;
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

	/**
	 * This method assigns a total of six ninjas to the board. It starts by
	 * initializing an array of ninjas, stored in {@link #ninjas}. Then, one by
	 * one, the ninjas are assigned using {@link java.util.Random}. If the spot
	 * is already occupied, the method will try again until all ninjas occupy a
	 * spot that was not previously occupied. The ninjas must also spawn 3 away
	 * from the player's initial position.
	 */
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
	 * This method will place the Radar item drop on a random position on the
	 * grid. Before the item is placed there, this method checks if there is an
	 * existing item(s), player or room before it places the Radar item down. If
	 * it is an empty space, it will place the item on that specific (x,y)
	 * coordinate.
	 */
	public void assignRadar() {
		boolean valid = false;

		while (!valid) {

			/*
			 * int row = rand.nextInt(9); int col = rand.nextInt(9);
			 */

			int row = 7;
			int col = 0;

			if (grid.getBoard()[row][col] == ' ' && (!(row == 8 && col == 0))) {
				grid.assign(row, col, 'r');
				radar = new Radar(row, col);
				valid = true;
			}
		}
	}

	public void refreshGrid() {
		grid.eraseGrid();
		if (radarFound)
			grid.enableCaseLighting(briefcase);
		if (!bullet.isUsed())
			grid.assign(bullet.getX(), bullet.getY(), 'b');
		if (!radar.isUsed())
			grid.assign(radar.getX(), radar.getY(), 'r');
		if (!invinc.isUsed())
			grid.assign(invinc.getX(), invinc.getY(), 'i');
		for (int i = 0; i < ninjas.length; i++) {
			if (ninjas[i] != null)
				grid.assign(ninjas[i].getPositionX(), ninjas[i].getPositionY(), 'N');
		}
		grid.assign(player.getPositionX(), player.getPositionY(), 'P');
	}

	/**
	 * This method will place the Bullet item drop on a random position on the
	 * grid. Before the item is placed on the spot, it will check if there is
	 * another item(s), player or room that exist on the spot. If it is an empty
	 * space on the grid, it will place the item there.
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
	 * on the grid. It will check to see if any existing item(s), player, or
	 * room is on the selected coordinate. If it is an empty space, it will
	 * place it there.
	 */
	public void assignInvincibility() {

		boolean valid = false;

		while (!valid) {

			int row = rand.nextInt(9);
			int col = rand.nextInt(9);

			if (grid.getBoard()[row][col] == ' ' && (!(row == 8 && col == 0))) {
				grid.assign(row, col, 'i');
				invinc = new Invincibility(row, col);
				valid = true;
			}
		}
	}

	public boolean roomCheck() {
		int x = player.getPositionX() + 1;
		int y = player.getPositionY();
		if (briefcase.getX() == x && briefcase.getY() == y) {
			return true;
		}
		return false;
	}

	public boolean roomCheckRequirement(int direction) {
		int x = player.getPositionX();
		int y = player.getPositionY();

		if ((x % 3 == 0) && (y % 3 == 1)) {
			return true;
		}

		ui.errorCheck(true);
		return false;
	}

	/**
	 * /** This method returns a boolean value and checks if the move the player
	 * wants is a valid move. For example, when the player is in the first
	 * column, this method would prevent the player from moving further left.
	 * Also, this method is called after every other method of movePlayer to
	 * check if the move is valid.
	 *
	 * @param direction
	 *            the direction the being wants to move
	 * @param being
	 *            the being trying to move to check conditions on
	 * @return {@code true} if the move is valid, {@code false} if invalid
	 */
	public boolean movementCheck(int direction, LivingBeing being, boolean isPlayer) {

		int x = being.getPositionX();
		int y = being.getPositionY();

		switch (direction) {
		case 0:
			x--;
			break;
		case 1:
			x++;
			break;
		case 2:
			y--;
			break;
		case 3:
			y++;
			break;
		}

		if (player.getShield() && (!isPlayer)) {
			return false;
		}

		if (x < 0 || x > 8 || y < 0 || y > 8) {
			return false;
		}

		if (grid.getBoard()[x][y] == 'R' || (x == briefcase.getX() && y == briefcase.getY())) {
			return false;
		}

		being.move(direction);
		return true;
	}

	public void pickupBullet() {
		if (player.getBullets() == 0) {
			player.findBullet();
			bullet.isUsed();
		} else if (player.getBullets() != 0) {
			bullet.isUsed();
		}

	}

	public void shoot(int direction) {
		int x = player.getPositionX();
		int y = player.getPositionY();
		boolean continueCheck = true;
		System.out.println("has bullet");
		if (player.getBullets() != 0) {
			System.out.println("No bullet");
			switch (direction) {

			case 1:
				while (x > 0 && x < 8 && continueCheck == true) {
					--x;
					continueCheck = shootCheck(x, y, continueCheck);
				}
				break;

			case 2:
				while (x > 0 && x < 8 && continueCheck == true) {
					++x;
					continueCheck = shootCheck(x, y, continueCheck);
				}
				break;
			case 3:
				while (y > 0 && y < 8 && continueCheck == true) {
					--y;
					continueCheck = shootCheck(x, y, continueCheck);
				}
				break;

			case 4:
				while (y > 0 && y < 8 && continueCheck == true) {
					++y;
					continueCheck = shootCheck(x, y, continueCheck);
				}
				break;
			}
		}

	}

	private boolean shootCheck(int x, int y, boolean check) {
		if (grid.getBoard()[x][y] == 'B') {
			System.out.println("Bullet stopped");
			check = false;
		} else if (grid.getBoard()[x][y] == 'R') {
			System.out.println("Bullet stopped");
			check = false;
		} else if (grid.getBoard()[x][y] == 'N') {
			check = false;
			for (int i = 0; i < ninjas.length; i++) {
				System.out.println("Bullet at" + x);
				if (ninjas[i] != null) {
					if (ninjas[i].getPositionX() == x && ninjas[i].getPositionY() == y) {
						ninjas[i] = null;
						System.out.println("ninja shot");
					}
				}
			}
		}
		return check;
	}

	private void pickupRadar() {
		radarFound = true;
		radar.isUsed();
		System.out.println("radar found");
	}

	private void pickupInvinc() {
		player.findShield();
	}
}
