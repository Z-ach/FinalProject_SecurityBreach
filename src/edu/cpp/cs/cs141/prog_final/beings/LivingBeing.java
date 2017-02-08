package edu.cpp.cs.cs141.prog_final.beings;

/**
 * This is the LivingBeing class. This class is a super class and an abstract
 * class. It passes on attributes to the {@link Player} and {@link Ninja}
 * subclasses. No instances can be made from this class, therefore the
 * subclasses inherit this classes methods.
 */
public abstract class LivingBeing {

	/**
	 * This field represents an array of integers that represent the spy's
	 * location in the building. The 0th index in the array represents the row,
	 * and the 1st index in the array represents the column. This will be
	 * initially set by the constructors of the subclasses, and then will be
	 * managed in this class.
	 */
	private int[] position;

	/**
	 * This is the constructor for the {@link LivingBeing} abstract class. It's
	 * parameter is a position on the grid. When the constructor is called, it
	 * will take in the parameter of the position and created the living being
	 * on that position on the grid. The constructor essentially spawns the
	 * living being when it is called on.
	 * 
	 * @param position the position on the grid to create the {@link LivingBeing}
	 */
	public LivingBeing(int[] position) {

	}

	/**
	 * This is the getPostion method. Its job is to return the position of the
	 * living being back to the User Interface class so that it can display the
	 * information to the user
	 * 
	 * @return the position of the {@link LivingBeing}
	 */
	public int[] getPosition() {
		return position;
	}

	/**
	 * This is the move class. It receives a parameter, direction, and passes it
	 * on to the subclasses and tells them when to move.
	 * 
	 * @param direction the direction to move the {@link LivingBeing}
	 */
	public void move(int direction) {

	}
}
