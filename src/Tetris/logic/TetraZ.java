package Tetris.logic;

import Tetris.logic.Tetramino.Rotation;

public class TetraZ extends Tetramino {

	public TetraZ()
	{
		super();
		
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		this.cubesTetra.add(new Cube( xPos-1, yPos));
		this.cubesTetra.add(new Cube( xPos ,yPos));
		this.cubesTetra.add(new Cube( xPos, yPos+1));
		this.cubesTetra.add(new Cube( xPos+1, yPos+1));
		
		rotation = Rotation.ZERO;
		type = Type.Z;
	}
	
	public boolean canRotate(Table table) 
	{
		
		if(rotation == Rotation.ZERO)
		{
			int x;
			int y;
		
			//CUBE 0
			x = this.cubesTetra.get(0).getPosX();
			y = this.cubesTetra.get(0).getPosY();
			x++;y++;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == false)
				return false;
			
			//CUBE 2
			x = this.cubesTetra.get(2).getPosX();
			y = this.cubesTetra.get(2).getPosY();
			x++;y--;
			
			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == false)
				return false;
			
			//CUBE 3
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			y--;y--;
			
			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == false)
				return false;
			
			return true;
		}
		else if(rotation == Rotation.ONE)
		{
			int x;
			int y;
		
			//CUBE 0
			x = this.cubesTetra.get(0).getPosX();
			y = this.cubesTetra.get(0).getPosY();
			x--;y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == false)
				return false;
			
			//CUBE 2
			x = this.cubesTetra.get(2).getPosX();
			y = this.cubesTetra.get(2).getPosY();
			x--;y++;
			
			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == false)
				return false;
			
			//CUBE 3
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			y++;y++;
			
			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == false)
				return false;
			
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public void rotate() 
	{
		if(rotation == Rotation.ZERO)	
		{
			rotation = Rotation.ONE;
			
			this.cubesTetra.get(0).moveRight();
			this.cubesTetra.get(0).moveDown();
			
			this.cubesTetra.get(2).moveRight();
			this.cubesTetra.get(2).moveUp();
			
			this.cubesTetra.get(3).moveUp();
			this.cubesTetra.get(3).moveUp();
		}
		else if(rotation == Rotation.ONE)
		{
			rotation = Rotation.ZERO;
			
			this.cubesTetra.get(0).moveLeft();
			this.cubesTetra.get(0).moveUp();
			
			this.cubesTetra.get(2).moveDown();
			this.cubesTetra.get(2).moveLeft();
			
			this.cubesTetra.get(3).moveDown();
			this.cubesTetra.get(3).moveDown();
		}		
	}
}
