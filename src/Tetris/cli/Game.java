package Tetris.cli;

import Tetris.logic.TetraS;
import Tetris.logic.TetraT;
import Tetris.logic.TetraZ;
import Tetris.logic.Tetramino;

import java.util.Scanner;

import Tetris.logic.Table;
import Tetris.logic.TetraI;
import Tetris.logic.TetraJ;
import Tetris.logic.TetraL;
import Tetris.logic.TetraO;

public class Game 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		Tetramino tetra1 = new TetraI();
		Tetramino tetra2 = new TetraL();
		
		Table table = new Table();
		
		char c;
		do
		{
			table.drawTable(tetra1);
			System.out.println();
			
			c = s.next().charAt(0);
			
			if(c == 's' || c == 'S')
			{
				moveDown(tetra1,table);
			}
			else if(c == 'a' || c == 'A')
			{
				moveLeft(tetra1,table);
				//moveDown(tetra1,table);
			}
			else if(c == 'd' || c == 'D')
			{
				moveRight(tetra1,table);
				//moveDown(tetra1,table);
			}
			
		}while(c != 'f');
		
		s.close();
	}
	
	private static boolean moveDown(Tetramino tetra, Table table)
	{
		if(testDown(tetra,table) == false)
			return false;
		tetra.moveDown();
			return true;
	}
	
	private static void moveLeft(Tetramino tetra, Table table)
	{
		if(testLeft(tetra,table) == false)
			return;
		tetra.moveLeft();
	}
	
	private static void moveRight(Tetramino tetra, Table table)
	{
		if(testRight(tetra,table) == false)
			return;
		tetra.moveRight();
	}
	
	private static boolean testDown(Tetramino tetra, Table table)
	{
		//falta testar para cubos de baixo e criar funçao para fazer store dos cubos
		//do tetramino na tabela, mudar info do tetra 2 para o tetra 1, e criar novo tetra 2
	}
	
	private static boolean testLeft(Tetramino tetra, Table table)
	{
		for(int j = 0; j < table.getCubes().size(); j++)
		{
			if(table.getCubes().get(j).getPosX() - 1 < 0)
				return false;
		}
		
		// falta testar para cubos do lado esquerdoi
		
		return true;
	}
	
	private static boolean testRight(Tetramino tetra, Table table)
	{
		for(int j = 0; j < table.getCubes().size(); j++)
		{
			if(table.getCubes().get(j).getPosX() + 1 >= Table.WIDTH)
				return false;
		}
		//falta testar para cubos do lado direito
		return true;
	}
}
