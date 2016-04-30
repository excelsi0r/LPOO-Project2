package Tetris.cli;

import Tetris.logic.TetraS;
import Tetris.logic.TetraT;
import Tetris.logic.TetraZ;
import Tetris.logic.Tetramino;
import java.util.Scanner;
import Tetris.logic.Cube;
import Tetris.logic.Table;
import Tetris.logic.TetraI;
import Tetris.logic.TetraJ;
import Tetris.logic.TetraL;
import Tetris.logic.TetraO;

public class Game 
{
	private static enum Move{LEFT, RIGHT, DOWN, STOP}
	static Move move;

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		Tetramino firstTetra = new TetraI();
		//Tetramino secondTetra = new TetraL();
		
		Table table = new Table();
		
		
		char direction;
		do
		{
			table.drawTable(firstTetra);
			System.out.println();
			
			direction = scan.next().charAt(0);
			convert(direction);
			
			if(move == Move.DOWN)
				moveDown(firstTetra, table);
		
			else if(move == Move.LEFT)
			{
				moveLeft(firstTetra, table);
				moveDown(firstTetra, table);
			}
			
			else if(move == Move.RIGHT)
			{
				moveRight(firstTetra, table);
				moveDown(firstTetra, table);
			}
			
		}while(move != Move.STOP);
		
		scan.close();
	}
	
	private static void convert(char input){
		if (input == 'A' || input == 'a')
			move = Move.LEFT;
		else if (input == 'S' || input == 's')
			move = Move.DOWN;
		else if (input == 'D' || input == 'd')
			move = Move.RIGHT;
		else if(input == 'f' || input == 'F')
			move = Move.STOP;
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
		for(int j = 0; j < table.getCubesStored().size(); j++)
		{
			if(table.getCubesStored().get(j).getPosY() + 1 >= Table.HEIGHT /*|| 
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
					existTetraBlocking(table, tetra, Move.RIGHT))
				return false;
		}
		
		return true;
	}
	
	private static boolean testLeft(Tetramino tetra, Table table)
	{
		
		for(int j = 0; j < table.getCubesStored().size(); j++)
		{
			if(table.getCubesStored().get(j).getPosX() - 1 < 0 || 
					existTetraBlocking(table, tetra, Move.LEFT))
				return false;
		}
		return true;
	}
	/**
	 * Return true if exist a tetra blocking the way, false otherwise
	 * @param table Table with tetras to be tested
	 * @param tetra Tetra moving in game to test against tetras
	 * @param move 
	 * @return true or false
	 */
	private static boolean existTetraBlocking(Table table, Tetramino tetra, Move move) {
		
		switch (move) {
		case LEFT:
			int XvalueLeft = -1;
			int YvalueLeft = 0;
			if(exists(table, tetra, XvalueLeft, YvalueLeft))
				return true;
			break;
		case RIGHT:
			int XvalueRight = 1;
			int YvalueRight = 0;
			if(exists(table, tetra, XvalueRight, YvalueRight))
				return true;
			break;
		case DOWN:
			int XvalueDown = 0;
			int YvalueDown = 1;
			if(exists(table, tetra, XvalueDown, YvalueDown))
				return true;
			break;

		default:
			break;
		}
		
		return false;
	}

	private static boolean exists(Table table, Tetramino tetra, int Xvalue, int Yvalue) {
		int tetraCubes = tetra.getCubesTetra().size();
		int cubesStored = table.getCubesStored().size();
		
		for(int i = 0; i < tetraCubes; i++)
		{
			for(int j = 0; j < cubesStored; j++)
			{
				if(tetra.getCubesTetra().get(i).getPosX() + Xvalue == table.getCubesStored().get(j).getPosX() && 
						tetra.getCubesTetra().get(i).getPosY() + Yvalue == table.getCubesStored().get(j).getPosY())
				{
					return true;
				}
			}
		}
		return false;
	}

	
}
