package logic;

public class TetraZ extends Tetramino {

	public TetraZ()
	{
		super();
		
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		this.cubesTetra.add(new Cube(Cube.CHARZ, xPos-1, yPos));
		this.cubesTetra.add(new Cube(Cube.CHARZ, xPos ,yPos));
		this.cubesTetra.add(new Cube(Cube.CHARZ, xPos, yPos+1));
		this.cubesTetra.add(new Cube(Cube.CHARZ,  xPos+1, yPos+1));
		
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
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			//CUBE 2
			x = this.cubesTetra.get(2).getPosX();
			y = this.cubesTetra.get(2).getPosY();
			x++;y--;
			
			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			//CUBE 3
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			y--;y--;
			
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
			x--;y--;

			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			//CUBE 2
			x = this.cubesTetra.get(2).getPosX();
			y = this.cubesTetra.get(2).getPosY();
			x--;y++;
			
			if(x >= Table.WIDTH || x < 0|| y >= Table.HEIGHT || y < 0)
				return false;
			if(table.searchCubesStored(x, y) == true)
				return false;
			
			//CUBE 3
			x = this.cubesTetra.get(3).getPosX();
			y = this.cubesTetra.get(3).getPosY();
			y++;y++;
			
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
		
		temptetratable[1][1] = Cube.CHARZ;
		temptetratable[1][2] = Cube.CHARZ;
		temptetratable[2][2] = Cube.CHARZ;
		temptetratable[2][3] = Cube.CHARZ;
		
		return temptetratable;
		
	}
}
