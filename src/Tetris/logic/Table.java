package Tetris.logic;
import java.util.ArrayList;
import java.util.Arrays;

public class Table 
{
	
	public final static int HEIGHT = 18;
	public final static int WIDTH = 10;
	public static char TABLESURFACE =  '*';
	public static char TABLEBOARDERS =  '®';
	
	private ArrayList<Cube> cubesStored; //Cubes in the table
	
	public Table()
	{
		cubesStored = new ArrayList<Cube>();
	}
	
	public void drawTable(Tetramino tetra)
	{
		char[][] tempTable = new char[HEIGHT][WIDTH];
		
		buildTable(tempTable);
		/**
		 * Draw Cubes already in the table before draw new Tetramino
		 */
		//drawCubesStored(tempTable); 
		drawTetramino(tempTable, tetra);
		printTable(tempTable);
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
		for (int i = 0; i < WIDTH; i++ ) 
		{
			System.out.print(TABLEBOARDERS + " ");
		}
	}
	/**
	 * Draw all Cubes already in the Table
	 * @param table Table array where Cubes will be deployed
	 */
	/*private void drawCubesStored(char [][] table)
	{
		System.out.println(cubesStored.size());
		for(int i = 0; i < cubesStored.size(); i++)
		{
			drawCube(table, cubesStored.get(i));
		}
	}*/
	/**
	 * Draw each Cube in a specific position in the Table
	 * @param table Table where is Draw
	 * @param cube Cube each Cube to be draw in the table with respective position
	 */
	private void drawCube(char[][] table, Cube cube)
	{
		table[cube.getPosY()][cube.getPosX()] = cube.getSymbol();
	}
	/**
	 * Draws the new Tetramino in the Table start position 
	 * @param table Table where is draw
	 * @param tetra Tetra to draw
	 */
	private void drawTetramino(char[][] table, Tetramino tetra) 
	{
		/**
		 * Gets the ArrayList with the Tetra Cubes generated 
		 */
		ArrayList<Cube> cubeTetraTemp = tetra.getCubesTetra();
		
		System.out.println(cubeTetraTemp.size()); //for debug
		for(int i = 0; i < cubeTetraTemp.size(); i++)
		{
			drawCube(table, cubeTetraTemp.get(i));
		}
	}

	/**
	 * Prints tableBoard
	 * @param tableBoard Tableboard to be printed
	 */
	private void printTable(char[][] tableBoard) 
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
	/**
	 * Search Cubes already in the table
	 * @param x X position of dynamic Tetra moving in the table
	 * @param y Y position of dynamic Tetra moving in the table
	 * @return true or false, if has similar position as the blocks in the table
	 */
	public boolean searchCubesStored(int x, int y)
	{
		for(int i = 0; i < cubesStored.size(); i++)
		{
			if(cubesStored.get(i).getPosX() == x && cubesStored.get(i).getPosY() == y)
				return true;
		}
		
		return false;
	}
	/**
	 * Gets all Cubes stored in the Table
	 * @return ArrayList of Cubes stored in the Table
	 */
	public ArrayList<Cube> getCubesStored()
	{
		return cubesStored;
	}
}
