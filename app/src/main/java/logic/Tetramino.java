package logic;

import java.util.ArrayList;
/**
 * 
 * Tetramino Class. As a type a rotation State and an ArrayList of Cubes
 *
 */
public class Tetramino 
{
	public enum Type {J, I, T, L, O, Z, S};
	protected enum Rotation {ZERO,ONE,TWO,THREE};
	
	public final static int TETRATABLEWIDTH = 4;
	public final static int TETRATABLEHEIGTH = 4;
	
	protected Type type;
	protected Rotation rotation;
	protected ArrayList<Cube> cubesTetra;

	/**
	 * Tetramino Default Constructor.
	 */
	public Tetramino()
	{
		cubesTetra = new ArrayList<Cube>();
	}	
	/**
	 * Tetramino Copy constructor
	 * @param tetra
	 */
	public Tetramino(Tetramino tetra) 
	{
		cubesTetra = new ArrayList<Cube>();
		cubesTetra = tetra.getCubesTetra();
	}
	/**
	 * Return the ArrayList of Cubes defining the tetramino
	 * @return
	 */
	public ArrayList<Cube> getCubesTetra()
	{
		return cubesTetra;
	}
	/**
	 * Move the Tetramino down
	 */
	public void moveDown()
	{
		for(int i = 0; i < cubesTetra.size(); i++)
		{
			cubesTetra.get(i).moveDown();
		}
	}
	/**
	 * Move the Tetramino Left
	 */
	public void moveLeft()
	{		
		for(int i = 0; i < cubesTetra.size(); i++)
		{
			cubesTetra.get(i).moveLeft();
		}
	}
	/**
	 * Move the Tetramino Rigth
	 */
	public void moveRight()
	{
		for(int i = 0; i < cubesTetra.size(); i++)
		{
			cubesTetra.get(i).moveRight();
		}
	}
	/**
	 * Return the Type of Tetramino
	 * @return type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Tetramino toString
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		return sb.toString();
	}
	/**
	 * Rotate Function for tetramino
	 */
	public void rotate(){}
	
	/**
	 * Check if Tetramino can rotate in a table
	 * @param table
	 * @return boolean
	 */
	public boolean canRotate(Table table) {return false;}
	
	/**
	 * Return Tetramino as Tetramino
	 * @return 
	 */
	public char[][] getTableTetra()
	{
		return null;
	}
	
}
