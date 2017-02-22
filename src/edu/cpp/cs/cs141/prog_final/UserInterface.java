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
import java.util.Scanner;

import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;

/**
 * The UserInterface class represents the game interactions with the player
 * throughout the game. The user is greeted with instructions, the grid is
 * printed for the game to begin which then shows the options for the player to
 * move, shoot, or debug, save or exit the game, status of powerups and bullets,
 * and the end result of the game is displayed.
 */
public class UserInterface implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7625972601335457659L;

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
		input = new Scanner(System.in);
	}

	/**
	 * This method represents the {@link #instruction()} of how to play the game
	 * to the user. The field will explain to the user what keys to use to play
	 * the game, what the powerups do, and the end objective to find the hidden
	 * briefcase through describing the setting.
	 */
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
	

	/**
	 *  This method represents the {link {@link #gameStartPrompt()} that will give
	 *  the player three options of starting a game, loading a game, or exiting the game.
	 */

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

	/**
	 * This method represents the {@link #playerOptions()} prints out the
	 * player's options of looking, shooting, and debugging. These options will
	 * be displayed
	 */
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

	/**
	 * This method represents the {@link #exitOptions()} that will allow for the
	 * player to either save the game or exit. These options will be available
	 * to the player throughout the game.
	 */
	public int exitOptions() {
		System.out.println("1: LOAD GAME");
		System.out.println("2. SAVE GAME");
		System.out.println("3: EXIT");
		return takeInput(1, 3);
	}

	/**
	 * This method will {@link takeInput()} from the player through asking the
	 * player to enter their desired options of looking, shooting, debugging,
	 * saving the game, loading a game, or exiting.
	 */
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

	/**
	 * This method represents the {@link #printGrid()} which serves as the base
	 * view of the game that will hold each of the objects. The player must
	 * navigate through the grid in order to play.
	 */
	public void printGrid(char[][] board, boolean[][] light, Player player, Invincibility shield) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (light[i][j])
					System.out.print("[ " + board[i][j] + " ]");
				else
					System.out.print("[ X ]");
			}
			if(i == 2){
				System.out.print("\tLives: " + player.getLives());
			}else if(i == 3){
				System.out.print("\tBullets: " + player.getBullets());
			}else if(i == 4){
				System.out.print("\tShield: ");
				if(!player.getShield())
					System.out.print("not in use");
				else if(player.getShield() && shield != null){
					System.out.print(shield.getTurns());
				}
			}
			System.out.println("\n");
		}
	}

	/**
	 * This method {@link #displayInfo()} represents the status of lives that
	 * the user has and notifies the user if any power ups are being used during
	 * the player's turn.
	 */
	public void displayInfo() {
		System.out.println("Lives:\t ");
		System.out.println("Bullet:\t ");
	}

	/**
	 * The method of {@link #saveGame()} represents what the system will ask
	 * after they choose the option to save the game. The input for a file name
	 * will be asked from the player in order to successfully save it.
	 */
	public void saveGame() {
		System.out.println("The Save Game option has been selected.\n"
				+ "Please enter a file name to save the game as: ");
	}
	
	
	/**
	 * The method of {@link #saveSuccessful()} is displayed after the user
	 * has successfully saved the game into a a proper file type.
	 */
	public void saveSuccessful() {
		System.out.println("The game has successfully been saved under the file: ");
		//enter the user input file 
	}
	
	/**
	 * The method of {@link #loadGame()} represents the system asking the user
	 * to enter the file name of the previous game that has been saved. If the
	 * file name entered does not exist, the system will display to the user that
	 * it is an invalid file. 
	 */
	public static void loadGame() {
		System.out.println("Please enter the file name where the game is saved: ");
		
	}


	/**
	 * This method represents the {@link #debug()} option that allows for the
	 * all components of the grid to be visible. Debug mode option will be
	 * available for the player throughout the game.
	 */
	public void debug() {

	}

	/**
	 * This method represents the {@link #errorCheck()} to display an error
	 * message when the user attempts to move in directions that are outside the
	 * grid space, or when the player tries to move into a room from the wrong
	 * direction
	 */
	public void errorCheck(boolean room) {
		if (room == false) {
			System.out
					.println("The direction you want to move is blocked. \n" + "Please select a different direction.");
		} else if (room == true) {
			System.out.println("Sorry you cannot enter from this side of the room"
					+ "Please enter from the north side of the room");

		}

	}

	/**
	 * This method is {@code true} if the character has found the briefcase and
	 * the message telling the character has won. If {@code false}, the system
	 * tells the user that the game is over.
	 */
	public void endMessage(boolean win) {
		if (win == true) {
			System.out.println("You have found the briefcase and escaped the 6 deadly ninjas.\n"
					+ "Congratulations on beating the game.");
		} else if (win == false) {
			System.out.println(
					"You have not found the briefcase. You have no lives left." 
							+ "Please choose what you want to do.");
		}
	}

	/**
	 * The method represents when the character will {@link #loseLife()} when
	 * they are stabbed by a ninja. The system will tell the character that they
	 * have lost a life and have respawned to their initial placement on the
	 * grid.
	 */
	public void loseLife() {
		System.out.println("You have lost a live.\n"
				+ "You will respawn in your original spot.\n"
				+ "Better luck next time.");
	}

	/**
	 * This method represents the {@link #briefCase(boolean)} that needs to be
	 * found by the player in order to win the game. If {@code true} then the
	 * message tells the player that they have successfully found the briefcase.
	 */
	public void briefCase(boolean hasCase) {
		if(hasCase == true){
			System.out.println("There is a briefcase in the room. \nCongratulations!");
		} else if(hasCase == false){
			System.out.println("This room does not have the briefcase.\n"
					+ "Only a few more rooms to go!");
		}
	}
}
