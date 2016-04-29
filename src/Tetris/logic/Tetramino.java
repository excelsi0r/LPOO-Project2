package Tetris.logic;

import java.util.ArrayList;

public class Tetramino 
{
	static enum Type {J,I,T,L,O,Z,S}; 
	
	protected Type type;
	protected ArrayList<Cube> cubesTetra;
	
	public Tetramino()
	{
		cubesTetra = new ArrayList<Cube>();
	};

	public ArrayList<Cube> drawTetra()
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
}
