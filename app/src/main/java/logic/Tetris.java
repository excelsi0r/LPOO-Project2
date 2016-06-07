package logic;
import java.util.Random;
import logic.GameState.State;

/**
 * 
 * Tetris class controls every aspect of the Game itself. Such as the Table, the first and second 
 * tetramino, state and level.
 *
 */

public class Tetris 
{
	private final static int TETRATYPE = 7;
	private Tetramino firstTetra;
	private Tetramino secondTetra;
	private Table table;
	private GameState state;
	private Level level;

	/**
	 * Tetris default constructor
	 */
	public Tetris()
	{
		super();
	}
	/**
	 * Initialize function of tetris
	 */
	public void initialize()
	{
		this.firstTetra = new Tetramino();
		this.secondTetra = new Tetramino();
		this.table = new Table();
		this.state = new GameState();
		this.level = new Level();
		firstTetra = randTetra();
		secondTetra = randTetra();
	}
	
	/**
	 * test constructor function
	 * @param tetra
	 * @param table
	 */
	public void testConstructor(Tetramino tetra, Table table){
		this.firstTetra = tetra;
		this.table = table;
		this.state = new GameState();
	}

	/**
	 * get the First Tetramino Function
	 * @return
	 */
	public Tetramino getFirstTetra() {
		return firstTetra;
	}

	/**
	 * get the Second Tetramino Function
	 * @return
	 */
	public Tetramino getSecondTetra() {
		return secondTetra;
	}
	
	/**
	 * Random tetramino create
	 * @return Tetramino
	 */
	private Tetramino randTetra()
	{
		Random r = new Random();

		int n = r.nextInt(TETRATYPE);

		if(n == 0)
			return new TetraI();
		else if(n == 1)
			return new TetraJ();
		else if(n == 2)
			return new TetraL();
		else if(n == 3)
			return new TetraO();
		else if(n == 4)
			return new TetraS();
		else if(n == 5)
			return new TetraZ();
		else if(n == 6)
			return new TetraT();
		else return null;

	}

	/**
	 * Set the State of Tetris
	 * @param state
	 */
	public void setState(State state) 
	{
		this.state.setState(state);	
	}

	/** 
	 * Get state of Tetris
	 * @return state
	 */
	public State getState() 
	{
		return this.state.getState();
	}
	/**
	 * draw Tetris in console
	 */
	public void draw() 
	{
		this.table.drawTable(this.firstTetra);
	}
	/**
	 * Return the complete table as Matrix
	 * @return table
	 */
	public char[][] getTable()
	{
		return this.table.getTable(this.firstTetra);
	}
	/**
	 * Move the tetris Down. Only the First Tetra moves
	 */
	public void moveDown()
	{
		if(testDown(this.firstTetra, this.table) == false)
		{
			this.table.storeTetramino(this.firstTetra);
			this.firstTetra = this.secondTetra;
			secondTetra = this.randTetra();
			this.assertLines();
			if(this.canDeploy() == false)
			{
				this.state.setState(State.LOST);				
			}
		}
		else
		{
			this.firstTetra.moveDown();
		}
	}
	/**
	 * Move the tetris Left. Only the First Tetra moves.
	 */
	public void moveLeft()
	{
		if(testLeft(this.firstTetra, this.table) == false)
			return;
		this.firstTetra.moveLeft();
	}

	/**
	 * Move the tetris Rigth. Only the First Tetra moves
	 */
	public void moveRight()
	{
		if(testRight(this.firstTetra, this.table) == false)
			return;
		this.firstTetra.moveRight();
	}
	/**
	 * Rotate the tetris. Only rotates the first tetramino.
	 */
	public void rotate() 
	{
		if(testRotate(this.firstTetra, this.table) == false)
			return;
		this.firstTetra.rotate();
	}
	/**
	 * Test Tetramino position against other tetras in the table and table bottom
	 * @param tetra Tetramino tested
	 * @param table Table game
	 * @return true or false
	 */
	public boolean testDown(Tetramino tetra, Table table)
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
	/**
	 * Test Tetramino position agaist the Right 
	 * @param tetra
	 * @param table
	 * @return true or falkse
	 */
	private boolean testRight(Tetramino tetra, Table table)
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
	/**
	 * Test Tetramino position agaist the Left
	 * @param tetra
	 * @param table
	 * @return true or false
	 */
	private boolean testLeft(Tetramino tetra, Table table)
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

	/**
	 * Test if Tetramino can rotate in the Table
	 * @param tetra Tetramino being tested
	 * @param table Table game
	 * @return true or false
	 */
	private boolean testRotate(Tetramino tetra, Table table) 
	{
		return (tetra.canRotate(table));
	}
	/**
	 * Assert Lines checks if a line is completed from down to up.
	 */
	private void assertLines()
	{
		for(int j = Table.HEIGHT - 1; j >= 0 ; j--)
		{
			for(int i = 0; i < Table.WIDTH; i++)
			{
				boolean exist;
				exist = table.searchCubesStored(i, j);

				if(exist == false)
					break;

				if(exist == true && i == Table.WIDTH - 1)
				{
					this.deleteLine(j);
					this.update();
					j++;
				}
			}
		}
	}

	/**
	 * Delete lines and push down Tetraminos above removed lines
	 * @param y Cube position to be removed
     */
	public void deleteLine(int y)
	{
		for(int i = 0; i < this.table.getCubesStored().size(); i++)
		{
			if(this.table.getCubesStored().get(i).getPosY() == y)
			{
				this.table.getCubesStored().remove(i);
				i--;
			}
		}

		for(int i = 0; i < this.table.getCubesStored().size(); i++)
		{
			if(this.table.getCubesStored().get(i).getPosY() < y)
				this.table.getCubesStored().get(i).moveDown();
		}
	}
	/**
	 * Checks if the first Tetramino can deploy on table. If not. the game ends.
	 * @return true or false
	 */
	private boolean canDeploy()
	{
		for(int i = 0; i < this.firstTetra.getCubesTetra().size(); i++)
		{
			if(this.table.searchCubesStored(this.firstTetra.getCubesTetra().get(i).getPosX(), this.firstTetra.getCubesTetra().get(i).getPosY()) == true)
				return false;
		}

		return true;
	}
	/**
	 * Update Tetris. Level.
	 */
	private void update()
	{
		this.level.update();
	}
	/**
	 * Return the Speed of Tetris.
	 * @return
	 */
	public int getSpeed()
	{
		return this.level.getSpeed();
	}
	/**
	 * Return the Score of the Tetris.
	 * @return score
	 */
	public int getScore()
	{
		return this.level.getScore();
	}
	/**
	 * Retrun the Level of the Tetris.
	 * @return level
	 */
	public int getLevel()
	{
		return this.level.getLevel();
	}
	/**
	 * return Score as String
	 * @return score
	 */
	public String getScoreString()
	{
		return this.level.getScoreString();
	}
	/**
	 * return level as String
	 * @return level
	 */
	public String getLevelString()
	{
		return this.level.getLevelString();
	}
	/**
	 * Return the Next Tetramino to be deployed in a Matrix
	 * @return secondTetra
	 */
	public char[][] getNextTetra()
	{
		return this.secondTetra.getTableTetra();
	}
}
