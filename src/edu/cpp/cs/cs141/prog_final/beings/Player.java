package edu.cpp.cs.cs141.prog_final.beings;

public class Player extends LivingBeing{
	
	
	private static int lives = 3;
	private static int bullet = 1;	

	public Player(int[][] position) {
		super(position);
	}
	
	public void shoot(){
		
	}

	public void look(){
		
	}
	
	public int getBullets(){
		
		return bullet;
	}
	
	public int getLives(){
		
		return lives;
	}
	
	public boolean alive(){
		if(lives > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
