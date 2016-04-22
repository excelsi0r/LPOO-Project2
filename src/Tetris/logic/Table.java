package Tetris.logic;

public class Table {
	
	
	Cube table[][];

	Table(){};

	Table(int width, int heigth) 
	{
		super();
		this.table = new Cube[heigth][width];
	}

}
