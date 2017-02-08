package edu.cpp.cs.cs141.prog_final.beings;

/**
 * This is the ninja subclass. It is charge of all the attributes that a 
 * ninja would need. It has methods that deal with different attributes
 * and a constructor that spawns and creates a ninja based on a location 
 * on the grid. It inherits properties from the living being super class.
 */
public class Ninja extends LivingBeing{

	/**
	 * This is the constructor for the ninja subclass. Its parameter is
	 * is a position on the grid. When the constructor is called, it will
	 * take in the parameter of the position and created the ninja on that
	 * position on the grid. The constructor essentially spawns the ninja 
	 * when it is called on.
	 */
	public Ninja(int[] position) {
		super(position);
	}

}
