package Tetris.logic;

import Tetris.logic.Tetramino.Rotation;

public class TetraZ extends Tetramino {

	public TetraZ()
	{
		super();
		
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		this.cubesTetra.add(new Cube(yPos, xPos-1));
		this.cubesTetra.add(new Cube(yPos, xPos));
		this.cubesTetra.add(new Cube(yPos+1, xPos));
		this.cubesTetra.add(new Cube(yPos+1, xPos+1));
		rotation = Rotation.ZERO;
		type = Type.Z;
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
