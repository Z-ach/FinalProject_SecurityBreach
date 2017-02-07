package edu.cpp.cs.cs141.prog_final.beings;

public class Player {
	
	
	private static int lives = 3;
	
	private static int bullet = 1;
	
	

	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public void shoot(){
		
	}

	public void look(){
		
	}
	
	public void walk(){
		
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
