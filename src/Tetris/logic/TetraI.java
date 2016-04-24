package Tetris.logic;

public class TetraI extends Tetramino{
	
	public TetraI(){
		super();
	}
	
	private Cube[] cubesPos(){
		
		int xPos = (Table.tableBoard[0].length/2) - 1;
		int yPos = 0;
		
		cube[0] = new Cube(yPos, xPos);
		cube[1] = new Cube(yPos, xPos+1);
		cube[2] = new Cube(yPos, xPos+2);
		cube[3] = new Cube(yPos, xPos-1);
		
		return cube;
	}
	
	@Override
	public void drawTetra() {
		cube = cubesPos();
		Table.drawCubes(cube);	
	}

}
