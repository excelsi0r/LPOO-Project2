package Tetris.logic;

public class TetraS extends Tetramino{
	
	public TetraS()
	{

		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos+1, xPos));
		cubesTetra.add(new Cube(yPos+1, xPos-1));
		
		type = Type.S;
	}
	
	public boolean canRotate(Table table) 
	{
		
		return false;
	}

	public void rotate() 
	{
		
		
	}
}
