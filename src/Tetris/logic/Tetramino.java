package Tetris.logic;

import java.util.ArrayList;

public class Tetramino 
{
	public enum Type {J, I, T, L, O, Z, S};
	protected enum Rotation {ZERO,ONE,TWO,THREE};
	
	protected Type type;
	protected Rotation rotation;
	protected ArrayList<Cube> cubesTetra;


	public Tetramino()
	{
		cubesTetra = new ArrayList<Cube>();
	}

	public Tetramino(Tetramino tetra) 
	{
		cubesTetra = new ArrayList<Cube>();
		cubesTetra = tetra.getCubesTetra();
	}

	public ArrayList<Cube> getCubesTetra()
	{
		return cubesTetra;
	}

	public void moveDown()
	{
		for(int i = 0; i < cubesTetra.size(); i++)
		{
			cubesTetra.get(i).moveDown();
		}
	}

	public void moveLeft()
	{		
		for(int i = 0; i < cubesTetra.size(); i++)
		{
			cubesTetra.get(i).moveLeft();
		}
	}

	public void moveRight()
	{
		for(int i = 0; i < cubesTetra.size(); i++)
		{
			cubesTetra.get(i).moveRight();
		}
	}

	public Type getType() {
		return type;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();

		for (Cube cube : cubesTetra) 
		{
			sb.append(cube.getSymbol());
			sb.append(cube.getPosX());
			sb.append(cube.getPosY());
		}
		return sb.toString();
	}

	public void rotate(){}

	public boolean canRotate(Table table) {return false;}
	
}
