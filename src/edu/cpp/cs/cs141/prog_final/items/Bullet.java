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
 * This class will represent the bullet used in the game. This class will also
 * inherit all attributes from the {@link Item} superclass. The bullet will go
 * in the direction the player commands it to. The bullet will travel in
 * throughout one column or row. If the bullet strikes a ninja-assassin(s), it
 * will die.
 * 
 * @author We Showed Up
 */
public class Bullet extends Item implements Serializable{

	private static final long serialVersionUID = -5352146141460746161L;

	public Bullet(int x, int y) {
		super(x, y);
	}

}
