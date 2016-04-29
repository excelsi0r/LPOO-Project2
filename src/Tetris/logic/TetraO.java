package Tetris.logic;

import java.util.ArrayList;

public class TetraO extends Tetramino{
	
	public TetraO()
	{
		super();
		
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 0;
		
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos+1, xPos));
		cubesTetra.add(new Cube(yPos+1, xPos+1));
		
		type = Type.O;
	}	
}
