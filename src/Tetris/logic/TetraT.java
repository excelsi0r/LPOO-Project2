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
		
		return true;
	}

	public void rotate() 
	{
		if(rotation == Rotation.ZERO)	
		{
			rotation = Rotation.ONE;
			
			this.cubesTetra.get(0).moveRight();
			this.cubesTetra.get(0).moveUp();
			
			this.cubesTetra.get(2).moveDown();
			this.cubesTetra.get(2).moveLeft();
			
			this.cubesTetra.get(3).moveLeft();
			this.cubesTetra.get(3).moveUp();
			
		}
		else if(rotation == Rotation.ONE)
		{
			rotation = Rotation.TWO;
			
			this.cubesTetra.get(0).moveRight();
			this.cubesTetra.get(0).moveDown();
			
			this.cubesTetra.get(2).moveLeft();
			this.cubesTetra.get(2).moveUp();
			
			this.cubesTetra.get(3).moveUp();
			this.cubesTetra.get(3).moveRight();
		}
		else if(rotation == Rotation.TWO)
		{
			rotation = Rotation.THREE;
			
			this.cubesTetra.get(0).moveDown();
			this.cubesTetra.get(0).moveLeft();
			
			this.cubesTetra.get(2).moveRight();
			this.cubesTetra.get(2).moveUp();
			
			this.cubesTetra.get(3).moveRight();
			this.cubesTetra.get(3).moveDown();
		}
		else if(rotation == Rotation.THREE)
		{
			rotation = Rotation.ZERO;
			
			this.cubesTetra.get(0).moveLeft();
			this.cubesTetra.get(0).moveUp();
			
			this.cubesTetra.get(2).moveRight();
			this.cubesTetra.get(2).moveDown();
			
			this.cubesTetra.get(3).moveDown();
			this.cubesTetra.get(3).moveLeft();
		}
		
	}
	
}
