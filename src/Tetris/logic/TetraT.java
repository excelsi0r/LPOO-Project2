package Tetris.logic;

import java.util.ArrayList;

public class TetraT extends Tetramino
{
	
	public TetraT()
	{
		super();
		
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 0;
		
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos, xPos-1));
		cubesTetra.add(new Cube(yPos+1, xPos));	
	}
}
