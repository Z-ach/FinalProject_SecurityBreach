package edu.cpp.cs.cs141.prog_final;

import edu.cpp.cs.cs141.prog_final.beings.Player;
import edu.cpp.cs.cs141.prog_final.items.Invincibility;

public interface UserInterface {
	
	public void	instruction();
	public int gameStartPrompt();
	public int playerOptions(boolean looking);
	public int direction();
	public int exitOptions();
	public int hardAI();
	public int takeInput(int lowBound, int highBound);
	public void	printGrid(char[][] grid, boolean[][] lighting, Player player, Invincibility shield, boolean hardMode);
	public void	saveGame();
	public void	saveSuccessful();
	public void	loadGame();
	public void	errorCheck(boolean room);
	public void	noCase();
	public void	endMessage(boolean win);
	public void	loseLife();
	public void	briefCase(boolean hasCase);
	public void	killedNinja();
	
}
