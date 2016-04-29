package Tetris.logic;
import java.util.ArrayList;
import java.util.Arrays;

import org.omg.CORBA.FREE_MEM;



public class Table 
{
	
	public final static int HEIGHT = 18;
	public final static int WIDTH = 10;
	
	
	public static char TABLESURFACE =  '*';
	public static char TABLEBOARDERS =  '$';
	private ArrayList<Cube> cubesStored;
	
	public Table()
	{
		cubesStored = new ArrayList<Cube>();
	};
	
	public void drawTable(Tetramino tetra)
	{
		char[][] tempTable = new char[HEIGHT][WIDTH];
		buildTable(tempTable);
		drawCubesStored(tempTable);
		drawTetramino(tempTable, tetra);
		printTable(tempTable, tempTable);
	}

	private void buildTable(char[][] tableBoard)
	{
		for(char[] row : tableBoard)
		{
			Arrays.fill(row, TABLESURFACE);
		}
	}
	
	private void buildBorders()
	{
		for (int i = 0; i < WIDTH; i++ ) {
			System.out.print(TABLEBOARDERS + " ");
		}
	}
	
	private void drawCubesStored(char [][] table)
	{
		for(int i = 0; i < cubesStored.size(); i++)
		{
			drawCube(table, cubesStored.get(i));
		}
	}
	
	private void drawCube(char[][] table, Cube cube)
	{
		table[cube.getPosY()][cube.getPosX()] = cube.getSymbol();
	}
	
	private void drawTetramino(char[][] table, Tetramino tetra) 
	{
		ArrayList<Cube> cubeTetraTemp = tetra.drawTetra();
		
		for(int i = 0; i < cubeTetraTemp.size(); i++)
		{
			drawCube(table, cubeTetraTemp.get(i));
		}
	}

	private void printTable(char[][] tempTable, char[][] tableBoard) 
	{
		buildBorders();
		System.out.println();
		for (int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++){
				System.out.print(tableBoard[y][x] + " ");
			}
			System.out.println();
		}
		buildBorders();
	}
}
