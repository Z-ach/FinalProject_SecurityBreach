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
package edu.cpp.cs.cs141.prog_final.beings;

import java.io.Serializable;

/**
 * This is the player subclass. It is charge of all the attributes that a player
 * would need. It has methods that deal with different attributes and a
 * constructor that spawns and creates a player based on a location on the grid.
 * It inherits properties from the living being super class.
 */
public class Player extends LivingBeing implements Serializable {

	private static final long serialVersionUID = 1944010931443879594L;

	/**
	 * This field represents the amount of lives that the player has. The player
	 * starts off with three lives, so this value is initially {@code 3}. If the
	 * player loses all 3 lives, the game is over, and the player has lost the
	 * game.
	 */
	private int lives = 3;

	/**
	 * This field is used to show if the player has the invincibility power up
	 * used. It will also have an initial value of false so that the turn does
	 * not start counting down.
	 */
	private boolean shield = false;

	/**
	 * This field represents the amount of bullets that the player has in their
	 * gun. The max amount of bullets a gun can carry is one. Initially
	 * {@code 1}, will decrease by {@code 1} whenever a shot is taken. If the
	 * player has no bullets, then no shot can be taken.
	 */
	private int bullet = 1;

	/**
	 * This is the constructor for the player subclass. Its parameter is is a
	 * position on the grid. When the constructor is called, it will take in the
	 * parameter of the position and created the player on that position on the
	 * grid. The constructor essentially spawns the player when it is called on.
	 * 
	 * @param x
	 *            the x position on the grid to create the {@link LivingBeing}
	 * @param y
	 *            the y position on the grid to create the {@link LivingBeing}
	 */
	public Player(int x, int y) {
		super(x, y);
	}

	/**
	 * This method is used to reset the player's position to the spawn point of
	 * column 1 row 9. It will be called in the beginning of the game and when
	 * the player dies. It will be called at most 3 times.
	 */
	public void setPlayer() {
		x = 8;
		y = 0;
	}

	/**
	 * This is the shoot method. Whenever this method is called the player will
	 * shoot a bullet in whichever direction the player chooses. Once the bullet
	 * makes contact with an enemy, the enemy will die. Will decrease the
	 * {@link #bullet} amount by {@code 1}.
	 */
	public void shoot() {
		bullet--;
	}

	/**
	 * This is the getBullets method. It returns the number of bullets left in
	 * the players gun back to the User Interface class and displays it for the
	 * player. Also used to determine whether or not the player can take a shot,
	 * if there are no bullets a shot cannot be taken.
	 * 
	 * @return the number of bullets the player has
	 */
	public int getBullets() {
		return bullet;
	}

	/**
	 * This method is called when the player makes contacts with a ninja. It
	 * will be called in the engine first then the method of setPlayer() will be
	 * called to reset the position. When the amount of lives reaches 0, the
	 * game will stop and display an end game message for losing.
	 */
	public void loseLive() {
		lives--;
	}

	/**
	 * This is the getLives method. It returns the number of lives left that the
	 * player has back to the User Interface class and displays it for the
	 * player. Also used in {@link edu.cpp.cs.cs141.prog_final.GameEngine}.
	 * 
	 * @return the number of lives the player has
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * This is the alive class. Its main purpose is to check if the player has
	 * over {@code 0} lives left. If there are no lives left, the game is over
	 * and the player has lost.
	 * 
	 * @return {@code true} if the player is alive. If the player is dead, the
	 *         method will return {@code false}
	 */
	public boolean alive() {
		if (lives > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method adds a bullet to the player. It will be called when the
	 * player picks up the bullet power up.
	 */
	public void findBullet() {
		bullet++;
	}

	/**
	 * This method sets the shield the whatever the parameter being passed in
	 * is. Used when the power up is picked up, and when it expires.
	 * 
	 * @param hasShield
	 *            whether or not the player should have a shield
	 */
	public void setShield(boolean hasShield) {
		shield = hasShield;
	}

	/**
	 * Gets whether or not the player currently has a shield
	 * 
	 * @return {@code true} if the shield is active, {@code false} if not
	 */
	public boolean getShield() {
		return shield;
	}
}
