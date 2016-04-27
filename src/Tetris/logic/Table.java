package Tetris.logic;
import java.util.ArrayList;
import java.util.Arrays;


public class Table 
{
	public static final char[][] tableBoard = new char[18][10];

	static ArrayList<Cube> cubesStored;

	public static void buildTable(char tableSurface)
	{
		for(char[] row : tableBoard)
		{
			Arrays.fill(row, tableSurface);
		}
	}

	public static void drawTable(Tetramino tetra)
	{
		char[][] tempTable = tableBoard;
		drawCubesStored(tempTable);
		drawTetramino(tempTable, tetra);
		printTable(tempTable);
	}
	
	private static void drawCubesStored(char [][] table)
	{
		for(int i = 0; i < cubesStored.size(); i++)
		{
			drawCube(table, cubesStored.get(i));
		}
	}
	
	private static void drawCube(char[][] table, Cube cube)
	{
		table[cube.getPosY()][cube.getPosX()] = cube.getSymbol();
	}
	
	private static void drawTetramino(char[][] table, Tetramino tetra) 
	{
		ArrayList<Cube> cubeTetraTemp = tetra.drawTetra();
		
		for(int i = 0; i < cubeTetraTemp.size(); i++)
		{
			drawCube(table, cubeTetraTemp.get(i));
		}
	}

	private static void printTable(char[][] tempTable) 
	{
		for (int y = 0; y < tableBoard.length; y++) {
			for(int x = 0; x < tableBoard[0].length; x++){
				System.out.println(tempTable[y][x] + " ");
			}
			System.out.println();
		}
	}
}
