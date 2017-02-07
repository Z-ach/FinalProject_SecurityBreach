package edu.cpp.cs.cs141.prog_final.beings;

public class Player {
	
	
	public static int Lives = 3;
	
	public static int Bullet = 1;
	
	

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
		
		return Lives;
	}
	
	public boolean alive(){
		if(Lives > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
