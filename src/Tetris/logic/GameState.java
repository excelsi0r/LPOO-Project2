package Tetris.logic;

public class GameState 
{
	public static enum State { PLAYING, WIN, LOST };
	
	private State state;
	
	public GameState(){}

	public State getState() 
	{
		return state;
	}

	public void setState(State state) 
	{
		this.state = state;
	}
	
}
