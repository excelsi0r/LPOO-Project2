package Tetris.cli;

import java.util.TimerTask;
import Tetris.logic.Tetris;

public class TimerSchedule extends TimerTask
{

	private Tetris tetris;
	
	public TimerSchedule(){}
	
	public TimerSchedule(Tetris tetris) 
	{
		super();
		this.tetris = tetris;
	}
	
	@Override
	public void run() 
	{
		tetris.moveDown();
		tetris.draw();
	}

}
