package Tetris.logic;

import java.util.ArrayList;

public class TetraT extends Tetramino{
	
	public TetraT(){
		super();
	}
	
	public ArrayList<Cube> drawTetra(){
		
		int xPos = (Table.tableBoard[0].length/2) - 1;
		int yPos = 0;
		
		cubesTetra.add(new Cube(yPos, xPos));
		cubesTetra.add(new Cube(yPos, xPos+1));
		cubesTetra.add(new Cube(yPos, xPos-1));
		cubesTetra.add(new Cube(yPos+1, xPos));	
		
		return cubesTetra;
	}
}
