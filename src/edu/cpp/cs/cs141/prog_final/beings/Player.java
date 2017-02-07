package edu.cpp.cs.cs141.prog_final.beings;

public class Player {
	
	
	public static int lives = 3;
	
	public static int bullet = 1;
	
	

	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public void shoot(){
		
	}

	public void look(){
		
	}
	
	public void walk(){
		
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
