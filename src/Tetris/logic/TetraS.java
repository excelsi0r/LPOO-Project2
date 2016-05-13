package Tetris.logic;

import Tetris.logic.Tetramino.Rotation;

public class TetraS extends Tetramino{
	
	public TetraS()
	{

		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		cubesTetra.add(new Cube( xPos-1, yPos+1));
		cubesTetra.add(new Cube(xPos, yPos+1));
		cubesTetra.add(new Cube(xPos, yPos));
		cubesTetra.add(new Cube(xPos+1,yPos));
		
		rotation = Rotation.ZERO;
		type = Type.S;
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
