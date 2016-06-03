package logic;

/**
 * Created by nuno_ on 02-Jun-16.
 */
public class Level 
{
	private int level;
	private int speed;
	private int numLines;
	private int score;
	
	private int SPEED1 = 1000;
	private int SPEED2 = 900;
	private int SPEED3 = 850;
	private int SPEED4 = 800;
	private int SPEED5 = 700;
	private int MAXLINES = 10;
	private int MAXLEVEL = 10;
	
	
	
	public Level()
	{
		this.speed = SPEED1;
		this.level = 1;
		this.numLines = 0;
		this.score = 0;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public int getScore()
	{
		return score;
	}

	public String getLevelString()
	{
		return Integer.toString(this.level);
	}

	public String getScoreString()
	{
		return Integer.toString(score);
	}
	
	public void update()
	{
		if(level == MAXLEVEL)
		{
			numLines++;
			atualizeScore();
		}
		else
		{
			numLines++;
			if(numLines > MAXLINES)
			{
				numLines = 0;
				level++;
			}
			atualizeScore();	
		}
	}	
	public void atualizeScore()
	{
		if(level == 1)
		{
			score += 10;
			speed = SPEED1;
		}
		else if(level == 2)
		{
			score += 12;
			speed = SPEED1;
		}
		else if(level == 3)
		{
			score += 14;
			speed = SPEED2;
		}
		else if(level == 4)
		{
			score += 16;
			speed = SPEED2;
		}
		else if(level == 5)
		{
			score += 20;
			speed = SPEED3;
		}
		else if(level == 6)
		{
			score += 14;
			speed = SPEED3;
		}
		else if(level == 7)
		{
			score += 16;
			speed = SPEED4;
		}
		else if(level == 8)
		{
			score += 18;
			speed = SPEED4;
		}
		else if(level == 9)
		{
			score += 20;
			speed = SPEED5;
		}
		else if(level == 10)
		{
			score += 20;
			speed = SPEED5;
		}
	}
}
