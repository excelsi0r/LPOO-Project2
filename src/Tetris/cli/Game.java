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

public class Game {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		Tetramino tetra1 = new TetraS();
		Tetramino tetra2 = new TetraL();

		Table.buildTable('o');
		
		
		char c;
		do
		{
		
			Table.drawTable();
			System.out.println();
			
			c = s.next().charAt(0);
		}while(c != 'f');
	}
}
