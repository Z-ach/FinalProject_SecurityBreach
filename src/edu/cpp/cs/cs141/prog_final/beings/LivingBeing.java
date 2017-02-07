package edu.cpp.cs.cs141.prog_final.beings;

/**
 * This class is an abstract class that extends to the two "live" beings on the
 * grid. It was the most conventional method because this abstract class would
 * just hold the super constructor. 
 */
public abstract class LivingBeing {
	/** 
	 * 
	 */
	private int[][] position;

	public LivingBeing(int[][] position) {

	}

	public int[][] getPosition() {
		return position;
	}
}
