package Tetris.logic;

public class TetraT extends Tetramino
{
	
	public TetraT()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos, xPos-1));
		cubesTetra.add(new Cube(yPos+1, xPos));	
		
		type = Type.T;
	}
	
}
