package Tetris.logic;

public class Tetris 
{
	private Tetramino first;
	private Tetramino second;
	static private int score = 0;
	static private int level = 0;



	/**
	 * @param table
	 * @param first
	 * @param second
	 * @param score
	 * @param level
	 */
	public Tetris(Tetramino first, Tetramino second) {
		super();
		this.first = first;
		this.second = second;
	}

	/**
	 * @return the level
	 */
	public static int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public static void setLevel(int level) {
		Tetris.level = level;
	}

	/**
	 * @return the score
	 */
	public static int getScore() {
		return score;
	}

	public static void startGame(){
		System.out.println(new Table());
	}
	
	
	
}
