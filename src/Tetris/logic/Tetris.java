package Tetris.logic;

public class Tetris 
{
	
	static private int score = 0;
	static private int level = 0;

	/**
	 * @param table
	 * @param first
	 * @param second
	 * @param score
	 * @param level
	 */
	public Tetris() {}

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

	public void startGame(){
		Cube cube1, cube2, cube3, cube4;
		cube1 = new Cube();
		cube2 = new Cube();
		cube3 = new Cube();
		cube4 = new Cube();
		cube1.setPosition(2, 2);
		cube2.setPosition(2, 3);
		cube3.setPosition(3, 3);
		cube4.setPosition(3, 4);

		Tetramino first = new TetraS(cube1,cube2,cube3,cube4);
		
		System.out.println(new Table());
	}
	
	
	
}
