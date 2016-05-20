package cli;


import logic.Tetris;
import logic.GameState.State;
import java.util.Scanner;
import java.util.Timer;

public class Game
{
	private static final char DOWN = 's';
	private static final char RIGHT = 'd';
	private static final char LEFT = 'a';
	private static final char ROTATE = 'p';
	private static final char STOP = 'f';
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		char direction;
		Tetris tetris = new Tetris();

		tetris.initialize();
		tetris.setState(State.PLAYING);
		tetris.draw();
		
		Timer timer = new Timer(true);
		timer.schedule(new TimerSchedule(tetris), 1000, 1000);

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
			else if(direction == ROTATE)
			{
				tetris.rotate();
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