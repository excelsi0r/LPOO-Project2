package Tetris.logic;

public class TetraI extends Tetramino{
	
	public TetraI()
	{
		super();
		
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos, xPos+2));
		cubesTetra.add(new Cube(yPos, xPos-1));
		
		type = Type.I;
	}
	
}
