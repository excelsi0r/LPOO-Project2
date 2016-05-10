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
		//Tetramino secondTetra = new TetraL();
		
		Table table = new Table();
		
		State state = State.PLAYING;
		GameState.setState(state);
		
		char direction;
		
		table.drawTable(firstTetra);
		
		do
		{
			System.out.println();
			
			direction = Character.toLowerCase(scan.next().charAt(0));
			
			if(direction == DOWN)
			{
				moveDown(firstTetra, table);
				System.out.println("down");
			}
		
			else if(direction == LEFT)
			{
				moveLeft(firstTetra, table);
				//moveDown(firstTetra, table);
				System.out.println("left");
			}
			
			else if(direction == RIGHT)
			{
				moveRight(firstTetra, table);
				//moveDown(firstTetra, table);
				System.out.println("right");
			}
			
			else if(direction == STOP) //for now lose when give up
				state = State.LOST;
			
			table.drawTable(firstTetra);
			System.out.println("table");
			
		}while(GameState.getState() == State.PLAYING);
		
		/*if(GameState.getState() == State.WIN)
			System.out.println("You win!");
		else
			System.out.println("You lost!");*/
		
		scan.close();
	}
	
	private static void moveDown(Tetramino tetra, Table table)
	{
		System.out.println("moveDown");

		if(testDown(tetra, table) == false)
			return;
		System.out.println("tetraMovedDown");

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
		int tetraSize = tetra.getCubesTetra().size();
		System.out.println("testdown");
		for(int j = 0; j < tetraSize; j++)
		{
			System.out.println("testdown");
			if(tetra.getCubesTetra().get(j).getPosY() + 1 >= Table.HEIGHT /*|| 
					existTetraBlocking(table, tetra, Move.DOWN)*/)
				return false;
		}
		return true;
		//falta testar para cubos de baixo e criar fun�ao para fazer store dos cubos
		//do tetramino na tabela, mudar info do tetra 2 para o tetra 1, e criar novo tetra 2
	}
	
	private static boolean testRight(Tetramino tetra, Table table)
	{
		for(int j = 0; j < table.getCubesStored().size(); j++)
		{
			if(table.getCubesStored().get(j).getPosX() + 1 >= Table.WIDTH || 
					existTetraBlocking(table, tetra, RIGHT))
				return false;
		}
		
		return true;
	}
	
	private static boolean testLeft(Tetramino tetra, Table table)
	{
		for(int j = 0; j < table.getCubesStored().size(); j++)
		{
			if(table.getCubesStored().get(j).getPosX() - 1 < 0 || 
					existTetraBlocking(table, tetra, LEFT))
				return false;
		}
		return true;
	}
	
	/**
	 * Return true if exist a tetra blocking the way, false otherwise
	 * @param table Table with tetras to be tested
	 * @param tetra Tetra moving in game to test against tetras
	 * @param move Direction left, right or down
	 * @return true or false
	 */
	private static boolean existTetraBlocking(Table table, Tetramino tetra, char move) {
		
		switch (move) {
		case LEFT:
			int XvalueLeft = -1;
			int YvalueLeft = 0;
			if(existsBlock(table, tetra, XvalueLeft, YvalueLeft))
				return true;
			break;
		case RIGHT:
			int XvalueRight = 1;
			int YvalueRight = 0;
			if(existsBlock(table, tetra, XvalueRight, YvalueRight))
				return true;
			break;
		case DOWN:
			int XvalueDown = 0;
			int YvalueDown = 1;
			if(existsBlock(table, tetra, XvalueDown, YvalueDown))
				return true;
			break;

		default:
			break;
		}
		
		return false;
	}

	private static boolean existsBlock(Table table, Tetramino tetra, int Xvalue, int Yvalue) {
		int totalTetraCubes = tetra.getCubesTetra().size();
		
		for(int i = 0; i < totalTetraCubes; i++)
		{
			int posX = tetra.getCubesTetra().get(i).getPosX() + Xvalue;
			int posY = tetra.getCubesTetra().get(i).getPosY() + Yvalue;
			if(table.searchCubesStored(posX, posY))
				return true;
		}
		return false;
	}

	
}