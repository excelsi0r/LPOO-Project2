package Tetris.logic;

import Tetris.logic.Tetramino.Rotation;

public class TetraT extends Tetramino
{
	
	public TetraT()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(xPos-1, yPos ));
		cubesTetra.add(new Cube(xPos ,yPos));
		cubesTetra.add(new Cube(xPos+1 ,yPos));
		cubesTetra.add(new Cube(xPos ,yPos+1));	
		
		rotation = Rotation.ZERO;
		type = Type.T;
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
			rotation = Rotation.TWO;
			//------------
		}
		else if(rotation == Rotation.TWO)
		{
			rotation = Rotation.THREE;
			//
		}
		else if(rotation == Rotation.THREE)
		{
			rotation = Rotation.ZERO;
			//
		}
		
	}
	
}
