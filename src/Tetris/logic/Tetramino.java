package Tetris.logic;

public abstract class Tetramino {

	Cube[] cube = new Cube[4];

	public Tetramino() {}

	public Cube[] getCube() {
		return cube;
	}

	public abstract void drawTetra();
	
}
