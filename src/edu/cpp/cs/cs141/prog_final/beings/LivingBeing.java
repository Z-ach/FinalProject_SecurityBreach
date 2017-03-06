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
 * This is the LivingBeing class. This class is a super class and an abstract
 * class. It passes on attributes to the {@link Player} and {@link Ninja}
 * subclasses. No instances can be made from this class, therefore the
 * subclasses inherit this classes methods.
 */
public abstract class LivingBeing implements Serializable {

	private static final long serialVersionUID = 8087892258705652646L;
	
	/**
	 * This field represents an array of integers that represent the spy's
	 * location in the building. The 0th index in the array represents the row,
	 * and the 1st index in the array represents the column. This will be
	 * initially set by the constructors of the subclasses, and then will be
	 * managed in this class.
	 */
	protected int x, y;
	

	/**
	 * This is the constructor for the {@link LivingBeing} abstract class. It's
	 * parameter is a position on the grid. When the constructor is called, it
	 * will take in the parameter of the position and created the living being
	 * on that position on the grid. The constructor essentially spawns the
	 * living being when it is called on.
	 * 
	 * @param position
	 *            the position on the grid to create the {@link LivingBeing}
	 */
	public LivingBeing(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This is the getPostion method. Its job is to return the position of the
	 * living being back to the User Interface class so that it can display the
	 * information to the user
	 * 
	 * @return the position of the {@link LivingBeing}
	 */
	public int getPositionX() {
		return x;
	}

	
	public int getPositionY() {
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	/**
	 * This is the move class. It receives a parameter, direction, and passes it
	 * on to the subclasses and tells them when to move.
	 * 
	 * @param direction
	 *            the direction to move the {@link LivingBeing}. If it is
	 *            {@code 0}, the being moves up. If {@code 1}, the being moves
	 *            down. If {@code 2}, the being moves left. If {@code 3}, the
	 *            being moves right
	 */
	public void move(int direction) {
		switch(direction){
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
	}
}
