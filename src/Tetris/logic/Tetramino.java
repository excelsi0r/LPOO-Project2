package Tetris.logic;

import java.util.ArrayList;

public abstract class Tetramino {

	ArrayList<Cube> cubesTetra;

	public Tetramino() {}

	public abstract void drawTetra();
	
	public ArrayList<Cube> getCubes()
	{
		return cubesTetra;
	}
	
}
