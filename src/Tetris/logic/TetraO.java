package Tetris.logic;

public class TetraO extends Tetramino{
	
	public TetraO()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos+1, xPos));
		cubesTetra.add(new Cube(yPos+1, xPos+1));
		rotation = Rotation.ZERO;
		type = Type.O;
	}	
	
	public boolean canRotate(Table table) 
	{
		
		return false;
	}

	public void rotate() 
	{
		//Just play a sound...	
	}
}
