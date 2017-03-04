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

import java.io.Serializable;
import java.util.Scanner;

import edu.cpp.cs.cs141.prog_final.GameEngine;
import edu.cpp.cs.cs141.prog_final.Grid;
import edu.cpp.cs.cs141.prog_final.beings.Ninja;
import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Briefcase;
import edu.cpp.cs.cs141.prog_final.items.Bullet;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;
import edu.cpp.cs.cs141.prog_final.items.Radar;

/**
 * The TextUserInterface class represents the game interactions with the player
 * throughout the game. The user is greeted with instructions, the grid is
 * printed for the game to begin which then shows the options for the player to
 * move, shoot, or debug, save or exit the game, status of powerups and bullets,
 * and the end result of the game is displayed.
 */
public class TextUserInterface implements Serializable, UserInterface {

	private static final long serialVersionUID = -5408848313550426100L;
	
	/**
	 * This field represents the {@link java.util.Scanner} object that creates
	 * the scanner that will take the user input to play the game and to print
	 * each of the objects within the game to the user.
	 */
	private static Scanner input;

	/**
	 * The default constructor for the class {@link TextUserInterface}. This
	 * constructor will allow for the
	 * {@link edu.cpp.cs.cs141.prog_final.GameEngine} to display the game
	 * outputs to the user. Necessary things will be initialized here, such as
	 * {@link #input}
	 * 
	 */
	public TextUserInterface() {
		input = new Scanner(System.in);
	}


	public void instruction() {
		System.out.print("This game is called Security Breach.\n");
		System.out.print("-----------------OBJECTIVE-----------------\n");
		System.out.print("You are a spy that is given a job to retrieve a briefcase located in one\n"
				+ "of nine rooms. There are 6 ninjas in a dark building, but you only have 1 bullet\n"
				+ "in your gun. This is a turn-based game. You have a flash light that can see 2 spaces\n"
				+ "in a desired direction and must be used before movement. Three items exist within\n "
				+ "the grid to assist you with your mission. Invincibility allows you to be invulnerable\n"
				+ "to begin stabbed by a ninja. Radar allows you to know the exact location of the briefcase.\n"
				+ "An extra bullet may be found to shoot after the first bullet has been used. A door to a room\n"
				+ "is located on the north side and must be faced to open. If you are stabbed by a ninja, you lose\n"
				+ "one life. You are given three lives to obtain the briefcase. Goodluck!");
	}

				
	


	public int gameStartPrompt() {
		System.out.println("Welcome to Security Breach!!!");
		System.out.println("Please choose what you would like to do");
		System.out.println("1. Start Game");
		System.out.println("2. Load Game");
		System.out.println("3. Exit \n");

		int answer = input.nextInt();

		if (answer == 1)
			answer = 1;
		else if (answer == 2)
			answer = 2;
		else if (answer == 3)
			answer = 3;

		return answer;

	}

	public int playerOptions(boolean look) {
		System.out.println("Choose one of the following options:");
		if (!look) {
			System.out.println("1: MOVE");
			System.out.println("2: SHOOT");
			return takeInput(1, 2);
		} else {
			System.out.println("1: LOOK");
			System.out.println("2: SHOOT");
			System.out.println("3: EXIT MENU");
			System.out.println("4: DEBUG MODE");
			return takeInput(1, 4);
		}
	}

	public int direction() {
		System.out.println("1: UP");
		System.out.println("2: DOWN");
		System.out.println("3: LEFT");
		System.out.println("4: RIGHT");
		return takeInput(1, 4);
	}

	public int exitOptions() {
		System.out.println("1: SAVE GAME");
		System.out.println("2. LOAD GAME");
		System.out.println("3: EXIT");
		return takeInput(1, 3);
	}


	public int hardAI() {
		System.out.println("Please select the difficulty:");
		System.out.println("1: EASY MODE");
		System.out.println("2: HARD MODE");
		return takeInput(1, 2);
	}
	
	public void update(){
		
	}


	public int takeInput(int lowerBound, int upperBound, boolean keys) {
		int validInput = -1;
		boolean valid = false;
		while (validInput == -1) {
			if (input.hasNextInt()) {
				validInput = input.nextInt();
				valid = true;
			}
			if (validInput < lowerBound || validInput > upperBound) {
				System.out.println("Input is not a valid number!");
				if (!valid)
					input.next();
				validInput = -1;
			}
		}
		return validInput;
	}
	
	public int takeInput(int lowerBound, int upperBound) {
		int validInput = -1;
		boolean valid = false;
		while (validInput == -1) {
			if (input.hasNextInt()) {
				validInput = input.nextInt();
				valid = true;
			}
			if (validInput < lowerBound || validInput > upperBound) {
				System.out.println("Input is not a valid number!");
				if (!valid)
					input.next();
				validInput = -1;
			}
		}
		return validInput;
	}


	public void printGrid(Grid grid, Player player, Invincibility shield, boolean hardMode) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid.getLight()[i][j])
					System.out.print("[ " + grid.getBoard()[i][j] + " ]");
				else
					System.out.print("[ X ]");
			}
			if (i == 1) {
				System.out.print("\tGame Difficulty: ");
				if (hardMode)
					System.out.print("HARD");
				else
					System.out.print("EASY");
			}
			if (i == 2) {
				System.out.print("\tLives: " + player.getLives());
			} else if (i == 3) {
				System.out.print("\tBullets: " + player.getBullets());
			} else if (i == 4) {
				System.out.print("\tShield: ");
				if (!player.getShield())
					System.out.print("not in use");
				else if (player.getShield() && shield != null) {
					System.out.print(shield.getTurns());
				}
			}
			System.out.println("\n");
		}
	}

	public void errorCheck(boolean room) {
		if (room == false) {
			System.out
					.println("The direction you want to move is blocked. \n" + "Please select a different direction.");
		} else if (room == true) {
			System.out.println("Sorry you cannot enter from this side of the room"
					+ "\nPlease enter from the north side of the room");
		}
	}

	public void noCase() {
		System.out.println("There is no briefcase in this room. Keep checking.");
	}

	public void endMessage(boolean win) {
		if (win == true) {
			System.out.println("You have found the briefcase and escaped the 6 deadly ninjas.\n"
					+ "Congratulations on beating the game.");
		} else if (win == false) {
			System.out.println("You have not found the briefcase. You have no lives left."
					+ "\nPlease choose what you want to do.");
		}
	}


	public void loseLife() {
		System.out.println("You have lost a life.\n" + "Better luck next time.");
	}


	public void killedNinja() {
		System.out.println("You have succesfully killed a ninja!");
	}

	@Override
	public void noBullet() {
		System.out.println("No bullet. Try again.");
	}
}
