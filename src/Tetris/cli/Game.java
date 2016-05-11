package Tetris.cli;

import Tetris.logic.TetraS;
import Tetris.logic.TetraT;
import Tetris.logic.TetraZ;
import Tetris.logic.Tetramino;
import Tetris.logic.Tetris;
import Tetris.logic.GameState;
import Tetris.logic.GameState.State;

import java.util.Random;
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

		char direction;
		Tetris tetris = new Tetris();


		tetris.initialize();
		tetris.setState(State.PLAYING);
		tetris.draw();

		do
		{
			direction = Character.toLowerCase(scan.next().charAt(0));

			if(direction == DOWN)
			{
				tetris.moveDown();
			}
			else if(direction == LEFT)
			{
				tetris.moveLeft();
			}
			else if(direction == RIGHT)
			{
				tetris.moveRight();
			}
			else if(direction == STOP) 
			{
				tetris.setState(State.LOST);
			}

			tetris.draw();

		}while(tetris.getState() == State.PLAYING);

		if(tetris.getState() == State.WIN)
		{
			System.out.println("You win!");
		}
		else
		{
			System.out.println("You lost!");
		}

		scan.close();
	}
}