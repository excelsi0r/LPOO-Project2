package logic;

/**
 * Level Class controls the Speed of the tetris, level and scores. Also have max lines and max level.
 * Also controles the calculation for the score.
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
	
	
	/**
	 * Default constructor for level. Initializes variables with corresponding values.
	 */
	public Level()
	{
		this.speed = SPEED1;
		this.level = 1;
		this.numLines = 0;
		this.score = 0;
	}
	/**
	 * Returns the speed
	 * @return speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	/**
	 * Returns the level
	 * @return level
	 */
	public int getLevel()
	{
		return level;
	}
	/**
	 * Returns the Score
	 * @return score
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * Return level as string
	 * @return level
	 */
	public String getLevelString()
	{
		return Integer.toString(this.level);
	}
	/**
	 * Returns the Score as String
	 * @return score
	 */
	public String getScoreString()
	{
		return Integer.toString(score);
	}
	/**
	 * Function to update the Level acording to the lines done.
	 */
	public void update()
	{
		if(score > 999) {
			score = 0;
		}

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
	/**
	 * Function to actualize the score acording to the level. Also asserts the speed acordingly
	 */
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
