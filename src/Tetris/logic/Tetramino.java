package Tetris.logic;

import java.util.ArrayList;

public class Tetramino 
{
	protected ArrayList<Cube> cubesTetra;
	public Tetramino()
	{
		cubesTetra = new ArrayList<Cube>();
	};

	public ArrayList<Cube> drawTetra()
	{
		return cubesTetra;
	}
}
