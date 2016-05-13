package Tetris.logic;

public class TetraI extends Tetramino{
	
	public TetraI()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos, xPos+2));
		cubesTetra.add(new Cube(yPos, xPos-1));
		rotation = Rotation.ZERO;
		type = Type.I;
	}
	
	public boolean canRotate(Table table) 
	{
		
		return false;
	}

	public void rotate() 
	{
		if(rotation == Rotation.ZERO)	
		{
			rotation = Rotation.ONE;
			//---------
		}
		else if(rotation == Rotation.ONE)
		{
			rotation = Rotation.ZERO;
			//------------
		}
	}
	
}
