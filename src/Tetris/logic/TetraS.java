package Tetris.logic;

public class TetraS extends Tetramino{
	
	public TetraS(){
		super();
	}
	
	public Cube[] cubesPos(){
		
		int xPos = (Table.tableBoard[0].length/2) - 1;
		int yPos = 1;
		
		cube[0] = new Cube(yPos, xPos);
		cube[1] = new Cube(yPos+1, xPos);
		cube[2] = new Cube(yPos+1, xPos+1);
		cube[3] = new Cube(yPos+2, xPos+1);
		
		return cube;
	}
	
	public void drawTetraS(){	
		cube = cubesPos();
		Table.drawCubes(cube);
	}

}
