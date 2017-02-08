package edu.cpp.cs.cs141.prog_final.beings;

/**
 * This is the LivingBeing class. This class is a super class 
 * and an abstract class. It passes on attributes to the player
 * and ninja subclasses. No instances can be made from this class,
 * therefore the subclasses inherit this classes methods.
 */
public abstract class LivingBeing {

	private int[][] position;
	/**
	 * This is the constructor for the LivingBeing astract class. Its parameter is
	 * is a postion on the grid. When the constructor is called, it will
	 * take in the parameter of the postion and create the living being.
	 * The living being can either be a ninja or player.
	 *
	 */
	public LivingBeing(int[][] position) {
		
	}
	
	/**
	 * This is the getPostion method. Its job is to return the position of
	 * the living being back to the User Interface class so that it can
	 * display the information to the user
	 */
	public int[][] getPosition(){
		return position;
	}
	
	/**
	 * This is the move class. It recieves a pramater, direction, and passes 
	 * it on to the subclasses and tells them when to move.`
	 */
	public void move(int direction){
		
	}
}
