package Tetris.logic;

import Tetris.logic.Tetramino.Rotation;

public class TetraJ extends Tetramino{

	public TetraJ()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos-1));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos+1, xPos+1));	
		rotation = Rotation.ZERO;
		type = Type.J;
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
