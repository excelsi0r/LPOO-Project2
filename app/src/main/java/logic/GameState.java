package logic;

/**
 * GameState Class Controlling the diferent states of the game
 */
public class GameState 
{
	public enum State { PLAYING, LOST };
	
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
