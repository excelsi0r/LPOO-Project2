package logic;

public class TetraO extends Tetramino{
	
	public TetraO()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(Cube.CHARO,xPos, yPos));
		cubesTetra.add(new Cube(Cube.CHARO,xPos+1, yPos));
		cubesTetra.add(new Cube(Cube.CHARO,xPos, yPos+1));
		cubesTetra.add(new Cube(Cube.CHARO,xPos+1, yPos+1));
		rotation = Rotation.ZERO;
		type = Type.O;
	}	
	
	public boolean canRotate(Table table) 
	{
		return true;
	}

	public void rotate() {/*Just play a sound...*/}
	
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
		
		temptetratable[1][1] = Cube.CHARO;
		temptetratable[1][2] = Cube.CHARO;
		temptetratable[2][1] = Cube.CHARO;
		temptetratable[2][2] = Cube.CHARO;
		
		return temptetratable;
		
	}
}
