package logic;

public class TetraO extends Tetramino{
	
	public TetraO()
	{
		int xPos = (Table.WIDTH/2) - 1;
		int yPos = 1;
		
		cubesTetra.add(new Cube(xPos, yPos));
		cubesTetra.add(new Cube(xPos+1, yPos));
		cubesTetra.add(new Cube(xPos, yPos+1));
		cubesTetra.add(new Cube(xPos+1, yPos+1));
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
}
