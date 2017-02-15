package edu.cpp.cs.cs141.prog_final;

public abstract class Square {

	private int x, y;
	
	private String type;
	
	private boolean light;
	
	public Square(String type) {
		this.type = type;
	}
	
	public String getType(){
		return type;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}

}
