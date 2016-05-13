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
		if(rotation == Rotation.ZERO)
		{
			int x;
			int y;

			//CUBE 0
			x = this.cubesTetra.get(0).getPosX();
			y = this.cubesTetra.get(0).getPosY();
			y--;y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;

			//CUBE 1
			x = this.cubesTetra.get(1).getPosX();
			y = this.cubesTetra.get(1).getPosY();
			x--;y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;

			//CUBE 3
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			x--;y++;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
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
			y++;y++;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;

			//CUBE 1
			x = this.cubesTetra.get(1).getPosX();
			y = this.cubesTetra.get(1).getPosY();
			x++;y++;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;

			//CUBE 3
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			x++;y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
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

			this.cubesTetra.get(0).moveUp();
			this.cubesTetra.get(0).moveUp();

			this.cubesTetra.get(1).moveLeft();
			this.cubesTetra.get(1).moveUp();

			this.cubesTetra.get(3).moveLeft();
			this.cubesTetra.get(3).moveDown();

		}
		else if(rotation == Rotation.ONE)
		{
			rotation = Rotation.ZERO;

			this.cubesTetra.get(0).moveDown();
			this.cubesTetra.get(0).moveDown();

			this.cubesTetra.get(1).moveDown();
			this.cubesTetra.get(1).moveRight();

			this.cubesTetra.get(3).moveRight();
			this.cubesTetra.get(3).moveUp();
		}
	}
}
