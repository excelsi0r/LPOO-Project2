package logic;

public class TetraL extends Tetramino{

	public TetraL()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(Cube.CHARL,xPos-1, yPos));
		cubesTetra.add(new Cube(Cube.CHARL,xPos, yPos));
		cubesTetra.add(new Cube(Cube.CHARL,xPos+1, yPos));
		cubesTetra.add(new Cube(Cube.CHARL,xPos-1, yPos+1));
		rotation = Rotation.ZERO;
		type = Type.L;
	}
	
	public boolean canRotate(Table table) 
	{
		if(rotation == Rotation.ZERO)
		{
			int x;
			int y;

			/**
			 * Cube 0
			 */
			x = this.cubesTetra.get(0).getPosX();
			y = this.cubesTetra.get(0).getPosY();
			x++; y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			/**
			 * Cube 2
			 */
			x = this.cubesTetra.get(2).getPosX();
			y = this.cubesTetra.get(2).getPosY();
			x--; y++;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			/**
			 * Cube 3
			 */
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			y -= 2;

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

			/**
			 * Cube 0
			 */
			x = this.cubesTetra.get(0).getPosX();
			y = this.cubesTetra.get(0).getPosY();
			x++; y++;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			/**
			 * Cube 2
			 */
			x = this.cubesTetra.get(2).getPosX();
			y = this.cubesTetra.get(2).getPosY();
			x--; y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			/**
			 * Cube 3
			 */
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			x += 2;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;

			return true;
		}
		else if(rotation == Rotation.TWO)
		{
			int x;
			int y;

			/**
			 * Cube 0
			 */
			x = this.cubesTetra.get(0).getPosX();
			y = this.cubesTetra.get(0).getPosY();
			x--;y++;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			/**
			 * Cube 2
			 */
			x = this.cubesTetra.get(2).getPosX();
			y = this.cubesTetra.get(2).getPosY();
			x++; y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			/**
			 * Cube 3
			 */
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			y += 2;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;

			return true;
		}
		else if(rotation == Rotation.THREE)
		{
			int x;
			int y;

			/**
			 * Cube 0
			 */
			x = this.cubesTetra.get(0).getPosX();
			y = this.cubesTetra.get(0).getPosY();
			x--; y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			/**
			 * Cube 2
			 */
			x = this.cubesTetra.get(2).getPosX();
			y = this.cubesTetra.get(2).getPosY();
			x++; y++;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			/**
			 * Cube 3
			 */
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			x -= 2;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;

			return true;
		}
		else
		{
			return true;
		}
		
	}

	public void rotate() 
	{
		if(rotation == Rotation.ZERO)	
		{
			rotation = Rotation.ONE;
			this.cubesTetra.get(0).moveUp();
			this.cubesTetra.get(0).moveRight();
			
			this.cubesTetra.get(2).moveDown();
			this.cubesTetra.get(2).moveLeft();
			
			this.cubesTetra.get(3).moveUp();
			this.cubesTetra.get(3).moveUp();
		}
		else if(rotation == Rotation.ONE)
		{
			rotation = Rotation.TWO;
			
			this.cubesTetra.get(0).moveRight();
			this.cubesTetra.get(0).moveDown();
			
			this.cubesTetra.get(2).moveLeft();
			this.cubesTetra.get(2).moveUp();
			
			this.cubesTetra.get(3).moveRight();
			this.cubesTetra.get(3).moveRight();
		}
		else if(rotation == Rotation.TWO)
		{
			rotation = Rotation.THREE;
			
			this.cubesTetra.get(0).moveDown();
			this.cubesTetra.get(0).moveLeft();
			
			this.cubesTetra.get(2).moveUp();
			this.cubesTetra.get(2).moveRight();
			
			this.cubesTetra.get(3).moveDown();
			this.cubesTetra.get(3).moveDown();
		}
		else if(rotation == Rotation.THREE)
		{
			rotation = Rotation.ZERO;
			
			this.cubesTetra.get(0).moveUp();
			this.cubesTetra.get(0).moveLeft();
			
			this.cubesTetra.get(2).moveRight();
			this.cubesTetra.get(2).moveDown();
			
			this.cubesTetra.get(3).moveLeft();
			this.cubesTetra.get(3).moveLeft();
		}
		
	}
	
	public String toString(){
		return super.toString();
	}
	
	public char[][] getTableTetra()
	{
		char[][] temptetratable = new char[TETRATABLEHEIGTH][TETRATABLEWIDTH];
		
		for(int j = 0; j < TETRATABLEHEIGTH; j++)
		{
			for(int i = 0; i < TETRATABLEWIDTH; i++)
			{
				temptetratable[j][i] = Table.TABLESURFACE;
			}
		}
		
		temptetratable[0][1] = Cube.CHARL;
		temptetratable[1][1] = Cube.CHARL;
		temptetratable[2][1] = Cube.CHARL;
		temptetratable[2][2] = Cube.CHARL;
		
		return temptetratable;
		
	}
}
