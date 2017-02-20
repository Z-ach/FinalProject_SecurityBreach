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

import edu.cpp.cs.cs141.prog_final.items.Briefcase;

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

	}

	
	
	
	
	public void gameStartPrompt(){
		System.out.println("Welcome to Escape from Ninja Island!!!");
		System.out.println("Please choose what you would like to do");
		System.out.println("1. Start Game");
		System.out.println("2. Load Game");
		System.out.println("3. Exit");
		
	}
	
	
	public void instructions(){
		System.out.println("Your name is John Carter");
		System.out.println("You are from the year 2165.");
		System.out.println("You were sent back to the year 1944 in the wake of the second world war.");
		System.out.println("Your mission was to prevent the start of the antartic civil war.");
		System.out.println("The mission has changed. Your new mission is...");
		System.out.println("Survive.");
		System.out.println("You are being held hostage by a tribe of angry nijnas.");
		System.out.println("The name of the island your on is Lian Yu. Its madarin, for purgatory.");
		System.out.println("One of the ninjas has seen the good in you and gives you a key to the door.");
		System.out.println("You have opened the door to your cell and this is your chance to escape");
		System.out.println("You took out the ninja keeping watch of you and took his gun.");
		System.out.println("Unfortunatly the ninja keeping track was showing off his gun skills to the lady ninjas.");
		System.out.println("His gun has one bullet left. Use it wisley.");
		System.out.println("You have also taken the ninjas night vision goggles. You will need them to see in the dark.");
		System.out.println("The bunker is dark and cold but you can use the goggles to see two steps in whichever direction you use.");
		System.out.println("You must choose which direction you would like to look in, then choose what way you want to step.");
		System.out.println("But be carful, the ninjas are very deadly. One hit from them means instant death.");
		System.out.println("Fortunalty, one hit from the bullet kills them instantly.");
		System.out.println("You have one job. Survive the ninjas and find the briefcase hidden in one of 9 rooms.");
		System.out.println("This briefcase has a satellite phone that will let the Canadian Army know your location.");
		System.out.println("Once the call is made. The Canadian army will rescue you.");
		System.out.println("There are three items in the bunker.");
		System.out.println("Finding the bullet powerup will reload your gun if you are out of ammunition.");
		System.out.println("There is a walking talkie radar that the ninjas use to comunicate. This will allow you to see their position.");
		System.out.println("Finally, There is a invincibilty artifact from the lost religion of the ninjas. It will protect you from 5 ninjas stabs.");
		System.out.println("Now is your time to escape. You only have once chance. Live long and prosper.");
		System.out.println("Let it begin");
		
		
	
	
	
	}
	/**
	 * This method represents the {@link #playerOptions()} prints out the
	 * player's options of looking, shooting, and debugging. These options will
	 * be displayed
	 */
	public int playerOptions() {
		System.out.println("Choose one of the following options:");
		System.out.println("1: LOOK");
		System.out.println("2: SHOOT");
		System.out.println("3: EXIT MENU");
		System.out.println("4: DEBUG MODE");
		return takeInput(1, 4);
	}

	public int lookDirection() {
		System.out.println("1: LOOK UP");
		System.out.println("2: LOOK DOWN");
		System.out.println("3: LOOK LEFT");
		System.out.println("4: LOOK RIGHT");
		return takeInput(1, 4);
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
	public void printGrid(char[][] board, boolean[][] light) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (light[i][j])
					System.out.print("[ " + board[i][j] + " ]");
				else
					System.out.print("[ X ]");
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

	}

	/**
	 * The method of {@link #saveGame()} represents what the system will ask
	 * after they choose the option to save the game. The input for a file name
	 * will be asked from the player in order to successfully save it.
	 */
	public void saveGame() {

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
	 * grid space.
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
	 * The method represents when the character will {@link #loseLife()} when
	 * they are stabbed by a ninja. The system will tell the character that they
	 * have lost a life and have respawned to their initial placement on the
	 * grid.
	 */
	public void loseLife() {

	}

	/**
	 * This method represents the {@link #briefCase(boolean)} that needs to be
	 * found by the player in order to win the game. If {@code true} then the
	 * message tells the player that they have successfully found the briefcase.
	 */
	public void briefCase(boolean hasCase) {

	}
}
