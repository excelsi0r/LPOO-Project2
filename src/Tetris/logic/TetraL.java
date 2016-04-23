package Tetris.logic;

public class TetraL extends Tetramino{

	public TetraL(){
		super();
	}
	
	private Cube[] cubesPos(){
		
		int xPos = (Table.tableBoard[0].length/2) - 1;
		int yPos = 1;
		
		cube[0] = new Cube(yPos, xPos);
		cube[1] = new Cube(yPos+1, xPos);
		cube[2] = new Cube(yPos+2, xPos);
		cube[3] = new Cube(yPos+2, xPos+1);
		
		return cube;
	}
	
	@Override
	public void drawTetra() {
		cube = cubesPos();
		Table.drawCubes(cube);	
	}

}
