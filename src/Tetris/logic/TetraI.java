package Tetris.logic;

public class TetraI extends Tetramino{
	
	public TetraI()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(xPos-1, yPos));
		cubesTetra.add(new Cube(xPos, yPos));
		cubesTetra.add(new Cube(xPos+1, yPos));
		cubesTetra.add(new Cube(xPos+2, yPos));
		
		rotation = Rotation.ZERO;
		type = Type.I;
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
			System.out.print("rotate to one");
			//---------
		}
		else if(rotation == Rotation.ONE)
		{
			rotation = Rotation.ZERO;
			System.out.print("rotate to zero");
			//------------
		}
	}
	
}
