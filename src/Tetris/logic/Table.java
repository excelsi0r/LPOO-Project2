package Tetris.logic;
import java.util.ArrayList;
import java.util.Arrays;


public class Table 
{
	
	char[][] tableBoard = new char[18][10];
	
	ArrayList<Cube> cubesStored;
	
	public void buildTable(char c)
	{
		for(char[] row : tableBoard)
		{
			Arrays.fill(row, c);
		}
	}
	
	public void drawTable(Tetramino tetra)
	{
		char[][] tabletemp = tableBoard;
		drawCubesStored(tabletemp);
		drawTetramino(tabletemp, tetra);
		printTable(tabletemp);
	}
	
	


	private void drawCubesStored(char [][] tabletemp)
	{
		for(int i = 0; i < cubesStored.size(); i++)
		{
			drawCube(tabletemp, cubesStored.get(i));
		}
	}
	
	
	
	private void drawTetramino(char[][] tabletemp, Tetramino tetra) 
	{
		ArrayList<Cube> cubeTetraTemp = tetra.getCubes();
		
		for(int i = 0; i < cubeTetraTemp.size(); i++)
		{
			drawCube(tabletemp, cubeTetraTemp.get(i));
		}
		
	}
	

	private void drawCube(char[][] tabletemp, Cube c)
	{
		tabletemp[c.getPosY()][c.getPosX()] = c.getSymbol();
	}
	
	private void printTable(char[][] tabletemp) 
	{
		
	}
	
	
	

}
