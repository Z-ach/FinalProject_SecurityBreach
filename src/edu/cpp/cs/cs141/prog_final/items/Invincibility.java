/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodr�guez
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
 * Team: We Showed Up
 * 
 * Team members: Bryan Ayala, Annalyn Edulag, Kelvin Huang, 
 * Zachary Kaufman, Michael Jason Yan
 * 
 */

package edu.cpp.cs.cs141.prog_final.items;

import java.io.Serializable;

/**
 * This class represents the Invincibilty item in the game. This class will also
 * inherit all attributes from the {@link Item} superclass. The Invicibility
 * item will grant the player a shield that will protect him or herself from the
 * ninja-assassin's stabbing for five turns.
 * 
 * @author We Showed Up
 */
public class Invincibility extends Item implements Serializable {

	private static final long serialVersionUID = 4659229807082088829L;
	
	/**
	 * This field is used to keep track of how many turns the shield has left.
	 * It will only start decrementing when the shield power up is used.
	 * Otherwise, it will start at 5.
	 */
	private int turns = 5;

	public Invincibility(int x, int y) {
		super(x, y);
	}

	/**
	 * This method is used to print out the turns the shield has left. It will
	 * only be printed when the shield is used. Other than that, a message will
	 * tell the player that the shield has not been found yet.
	 * 
	 * @return the number of turns left for the power up
	 */
	public int getTurns() {
		return turns;
	}

	/**
	 * This method is to decrement the turns from 5. When the integer turns goes
	 * to 0, it will stop decrementing and it will allow the player to lose a
	 * life when touching a ninja.
	 */
	public void useTurn() {
		turns--;
	}

}
