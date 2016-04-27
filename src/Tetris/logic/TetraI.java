package Tetris.logic;

import java.util.ArrayList;

public class TetraI extends Tetramino{
	
	public TetraI()
	{
		super();
	}
	
	public ArrayList<Cube> drawTetra(){
		int xPos = (Table.tableBoard[0].length/2) - 1;
		int yPos = 0;
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos, xPos+2));
		cubesTetra.add(new Cube(yPos, xPos-1));
		
		return cubesTetra;
	}

}
