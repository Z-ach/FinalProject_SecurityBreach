package edu.cpp.cs.cs141.prog_final.beings;

import java.io.Serializable;

/**
 * This is the player subclass. It is charge of all the attributes that a player
 * would need. It has methods that deal with different attributes and a
 * constructor that spawns and creates a player based on a location on the grid.
 * It inherits properties from the living being super class.
 */
public class Player extends LivingBeing implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8275985798947223662L;

	/**
	 * This field represents the amount of lives that the player has. The player
	 * starts off with three lives, so this value is initially {@code 3}. If the
	 * player loses all 3 lives, the game is over, and the player has lost the
	 * game.
	 */
	private static int lives = 3;
	
	private boolean shield = false;
	
	/**
	 * This field represents the amount of bullets that the player has in their
	 * gun. The max amount of bullets a gun can carry is one. Initially
	 * {@code 1}, will decrease by {@code 1} whenever a shot is taken. If the
	 * player has no bullets, then no shot can be taken.
	 */
	private static int bullet = 1;

	/**
	 * This is the constructor for the player subclass. Its parameter is is a
	 * position on the grid. When the constructor is called, it will take in the
	 * parameter of the position and created the player on that position on the
	 * grid. The constructor essentially spawns the player when it is called on.
	 * 
	 * @param position
	 *            the location of where to spawn the player
	 */
	public Player(int x, int y) {
		super(x, y);
	}
	public void setPlayer(){
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
	 */
	public int getBullets() {
		return bullet;
	}
	public void loseLive(){
		lives--; 
	}
	/**
	 * This is the getLives method. It returns the number of lives left that the
	 * player has back to the User Interface class and displays it for the
	 * player. Also used in {@link edu.cpp.cs.cs141.prog_final.GameEngine}.
	 */
	public int getLives() {
		return lives;
	}
	/**
	 * This is the alive class. Its main purpose is to check if the player has
	 * over {@code 0} lives left. If there are no lives left, the game is over and the
	 * player has lost.
	 * 
	 * @return {@code true} if the playefr is alive. If the player is dead, the
	 *         method will return {@code false}
	 */
	public boolean alive() {
		if (lives > 0) {
			return true;
		} else {
			return false;
		}
	}
	public void findBullet(){
		bullet++;
	}
	public void setShield(boolean hasShield){
		shield = hasShield;
	}
	public boolean getShield(){
		return shield;
	}
}
