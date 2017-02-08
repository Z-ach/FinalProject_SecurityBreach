package edu.cpp.cs.cs141.prog_final.beings;


/**
 * This is the player subclass. It is charge of all the attributes that a 
 * player would need. It has methods that deal with different attributes
 * and a constructor that spawns and creates a player based on a location 
 * on the grid. It inherites properties from the living being super class.
 */
public class Player extends LivingBeing{
	
	/**
	 * This field represents the amount of lives that the player has. 
	 * The player starts off with three lives.
	 */
	private static int lives = 3;
	/**
	 * This field represents the amount of bullets that the player has
	 * in their gun. The max amount of bullets a gun can carry is one.
	 */
	private static int bullet = 1;	
	
	
	/**
	 * This is the constructor for the player subclass. Its parameter is
	 * is a postion on the grid. When the constructor is called, it will
	 * take in the parameter of the postion and created the player on that
	 * position on the grid. The constructor essentially spawns the player 
	 * when it is called on.
	 */
	public Player(int[][] position) {
		super(position);
	}
	/**
	 * This is the shoot method. Whenever this method is called the player
	 * where shoot a bullet in whichever direction the player chooses.
	 * Once the bullet makes contact with an enemy, the enemy will die.
	 */
	public void shoot(){
		
	}
/**
 * This is look method. Whenever this method is called the plaeyr will look in 
 * whichever direction the player chooses. Once the player chooses where to look,
 * the next two steps will be lit.
 */
	public void look(){
		
	}
	/**
	 * This is the getBullets method. It returns the number of bullets left
	 * in the players gun back to the User Interface class and displays it 
	 * for the player
	 */
	public int getBullets(){
		
		return bullet;
	}
	
	/**
	 * This is the getLives method. It returns the number of lives left
	 * that the player has back to the User Interface class and displays it 
	 * for the player
	 */
	public int getLives(){
		
		return lives;
	}
	
	/**
	 * This is the alive class. Its main purpose is to check if the player
	 * has over 0 lives left. If the player has over 0 lives, the method will
	 * return true meaning the player is alive. If the player is dead, the method
	 * will return false
	 */
	public boolean alive(){
		if(lives > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
