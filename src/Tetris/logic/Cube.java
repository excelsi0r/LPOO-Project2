package Tetris.logic;

public class Cube {
	private char elem;

	Cube() {
		this.elem = 178;
	}

	Cube(char c) {
		super();
		this.elem = c;

	}

	char getCubeChar() {
		return elem;
	}
}
