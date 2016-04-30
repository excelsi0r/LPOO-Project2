package Tetris.logic;

public class GameState {
	public enum State { PLAYING, WIN, LOST };
	
	private static State state;

	public static State getState() {
		return state;
	}

	public static void setState(State state) {
		GameState.state = state;
	}
	
}
