package Tetris.logic;

import java.util.Random;
import java.util.Scanner;

import Tetris.logic.GameState.State;

public class Tetris 
{
	private Tetramino firstTetra;
	private Tetramino secondTetra;
	private Table table;
	private GameState state;

	public Tetris()
	{
		super();
	}

	public void initialize()
	{
		this.firstTetra = new Tetramino();
		this.secondTetra = new Tetramino();
		this.table = new Table();
		this.state = new GameState();

		this.randFirstTetra();
		this.randSecondTetra();
	}

	private void randFirstTetra()
	{
		Random r = new Random();

		int n = r.nextInt(7);

		if(n == 0)
			this.firstTetra = new TetraI();
		else if(n == 1)
			this.firstTetra = new TetraJ();
		else if(n == 2)
			this.firstTetra = new TetraL();
		else if(n == 3)
			this.firstTetra = new TetraO();
		else if(n == 4)
			this.firstTetra = new TetraS();
		else if(n == 5)
			this.firstTetra = new TetraZ();
		else if(n == 6)
			this.firstTetra = new TetraT();

	}

	public void randSecondTetra()
	{
		Random r = new Random();

		int n = r.nextInt(7);

		if(n == 0)
			this.secondTetra = new TetraI();
		else if(n == 1)
			this.secondTetra = new TetraJ();
		else if(n == 2)
			this.secondTetra = new TetraL();
		else if(n == 3)
			this.secondTetra = new TetraO();
		else if(n == 4)
			this.secondTetra = new TetraS();
		else if(n == 5)
			this.secondTetra = new TetraZ();
		else if(n == 6)
			this.secondTetra = new TetraT();

	}

	public void setState(State state) 
	{
		this.state.setState(state);	
	}

	public State getState() 
	{
		return this.state.getState();
	}

	public void draw() 
	{
		this.table.drawTable(this.firstTetra);		
	}

	public void moveDown()
	{
		if(testDown(this.firstTetra, this.table) == false)
		{
			this.table.storeTetramino(this.firstTetra);
			this.firstTetra = this.secondTetra;
			this.randSecondTetra();
			this.assertLines();
			if(this.canDeploy() == false)
			{
				this.state.setState(State.LOST);				
			}
		}
		else
		{
			this.firstTetra.moveDown();
		}
	}

	public void moveLeft()
	{
		if(testLeft(this.firstTetra, this.table) == false)
			return;
		this.firstTetra.moveLeft();
	}

	public void moveRight()
	{
		if(testRight(this.firstTetra, this.table) == false)
			return;
		this.firstTetra.moveRight();
	}
	
	public void rotate() 
	{
		
	}

	private boolean testDown(Tetramino tetra, Table table)
	{
		for(int j = 0; j < tetra.getCubesTetra().size(); j++)
		{
			if(tetra.getCubesTetra().get(j).getPosY() + 1 >= Table.HEIGHT)
				return false;

			if(table.searchCubesStored(tetra.getCubesTetra().get(j).getPosX(), tetra.getCubesTetra().get(j).getPosY() + 1) == true)
				return false;
		}
		return true;
	}

	private boolean testRight(Tetramino tetra, Table table)
	{
		for(int j = 0; j < tetra.getCubesTetra().size(); j++)
		{
			if(tetra.getCubesTetra().get(j).getPosX() + 1  >=  Table.WIDTH)
				return false;
			if(table.searchCubesStored(tetra.getCubesTetra().get(j).getPosX() + 1, tetra.getCubesTetra().get(j).getPosY()) == true)
				return false;
		}
		return true;
	}

	private boolean testLeft(Tetramino tetra, Table table)
	{
		for(int j = 0; j < tetra.getCubesTetra().size(); j++)
		{
			if(tetra.getCubesTetra().get(j).getPosX() - 1 < 0)
				return false;
			if(table.searchCubesStored(tetra.getCubesTetra().get(j).getPosX() - 1, tetra.getCubesTetra().get(j).getPosY()) == true)
				return false;
		}
		return true;
	}

	
	private void assertLines()
	{
		for(int j = Table.HEIGHT - 1; j >= 0 ; j--)
		{
			for(int i = 0; i < Table.WIDTH; i++)
			{
				boolean exist;
				exist = table.searchCubesStored(i, j);
				
				if(exist == false)
					break;
				
				if(exist == true && i == Table.WIDTH-1)
				{
					this.deleteLine(j);
					j++;
				}
			}
		}
	}
	
	private void deleteLine(int y)
	{
		for(int i = 0; i < this.table.getCubesStored().size(); i++)
		{
			if(this.table.getCubesStored().get(i).getPosY() == y)
				this.table.getCubesStored().remove(i);
		}
		
		for(int i = 0; i < this.table.getCubesStored().size(); i++)
		{
			if(this.table.getCubesStored().get(i).getPosY() < y)
				this.table.getCubesStored().get(i).moveDown();
		}
	}
	
	private boolean canDeploy()
	{
		for(int i = 0; i < this.firstTetra.getCubesTetra().size(); i++)
		{
			if(this.table.searchCubesStored(this.firstTetra.getCubesTetra().get(i).getPosX(), this.firstTetra.getCubesTetra().get(i).getPosY()) == true)
				return false;
		}
		
		return true;
	}
}
