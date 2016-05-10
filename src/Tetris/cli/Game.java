package Tetris.cli;

import Tetris.logic.TetraS;
import Tetris.logic.TetraT;
import Tetris.logic.TetraZ;
import Tetris.logic.Tetramino;
import Tetris.logic.GameState;
import Tetris.logic.GameState.State;
import java.util.Scanner;
import Tetris.logic.Cube;
import Tetris.logic.Table;
import Tetris.logic.TetraI;
import Tetris.logic.TetraJ;
import Tetris.logic.TetraL;
import Tetris.logic.TetraO;

public class Game
{
	private static final char DOWN = 's';
	private static final char RIGHT = 'd';
	private static final char LEFT = 'a';
	private static final char STOP = 'f';
			

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Tetramino firstTetra = new TetraI();
		Tetramino secondTetra = new TetraL();	
		Table table = new Table();
		GameState state = new GameState();
		char direction;
		
		state.setState(State.PLAYING);
		table.drawTable(firstTetra);
		
		do
		{
			System.out.println();
			
			direction = Character.toLowerCase(scan.next().charAt(0));
			
			if(direction == DOWN)
			{
				moveDown(firstTetra, table);
			}
		
			else if(direction == LEFT)
			{
				moveLeft(firstTetra, table);
				moveDown(firstTetra, table);
			}
			
			else if(direction == RIGHT)
			{
				moveRight(firstTetra, table);
				moveDown(firstTetra, table);
			}
			
			else if(direction == STOP) 
				state.setState(State.LOST);
			
			table.drawTable(firstTetra);
			
		}while(state.getState() == State.PLAYING);
		
		if(state.getState() == State.WIN)
			System.out.println("You win!");
		else
			System.out.println("You lost!");
		
		scan.close();
	}
	
	private static void moveDown(Tetramino tetra, Table table)
	{
		if(testDown(tetra, table) == false)
			return;
		tetra.moveDown();
	}
	
	private static void moveLeft(Tetramino tetra, Table table)
	{
		if(testLeft(tetra, table) == false)
			return;
		tetra.moveLeft();
	}
	
	private static void moveRight(Tetramino tetra, Table table)
	{
		if(testRight(tetra, table) == false)
			return;
		tetra.moveRight();
	}
	
	private static boolean testDown(Tetramino tetra, Table table)
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
	
	private static boolean testRight(Tetramino tetra, Table table)
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
	
	private static boolean testLeft(Tetramino tetra, Table table)
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

	
}