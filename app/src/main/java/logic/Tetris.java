package logic;

import java.util.Random;
import logic.GameState.State;

public class Tetris 
{
	private final static int TETRATYPE = 7;
	private Tetramino firstTetra;
	private Tetramino secondTetra;
	private Table table;
	private GameState state;

	public Tetris()
	{
		super();
	}

	public void initialize()
	{
		this.firstTetra = new Tetramino();
		this.secondTetra = new Tetramino();
		this.table = new Table();
		this.state = new GameState();
		firstTetra = randTetra();
		secondTetra = randTetra();
	}
	
	public void testConstructor(Tetramino tetra){
		this.firstTetra = tetra;
		this.table = new Table();
		this.state = new GameState();
	}

	public Tetramino getFirstTetra() {
		return firstTetra;
	}

	public Tetramino getSecondTetra() {
		return secondTetra;
	}
	
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

	public void setState(State state) 
	{
		this.state.setState(state);	
	}

	public State getState() 
	{
		return this.state.getState();
	}

	public void draw() 
	{
		this.table.drawTable(this.firstTetra);
	}
	
	public char[][] getTable()
	{
		return this.table.getTable(this.firstTetra);
	}

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

	public void moveLeft()
	{
		if(testLeft(this.firstTetra, this.table) == false)
			return;
		this.firstTetra.moveLeft();
	}

	public void moveRight()
	{
		if(testRight(this.firstTetra, this.table) == false)
			return;
		this.firstTetra.moveRight();
	}

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

				if(exist == true && i == Table.WIDTH-1)
				{
					this.deleteLine(j);
					j++;
				}
			}
		}
	}

	/**
	 * Delete lines and push down Tetraminos above removed lines
	 * @param y Cube position to be removed
     */
	private void deleteLine(int y)
	{
		for(int i = 0; i < this.table.getCubesStored().size(); i++)
		{
			if(this.table.getCubesStored().get(i).getPosY() == y)
				this.table.getCubesStored().remove(i);
		}

		for(int i = 0; i < this.table.getCubesStored().size(); i++)
		{
			if(this.table.getCubesStored().get(i).getPosY() < y)
				this.table.getCubesStored().get(i).moveDown();
		}
	}

	private boolean canDeploy()
	{
		for(int i = 0; i < this.firstTetra.getCubesTetra().size(); i++)
		{
			if(this.table.searchCubesStored(this.firstTetra.getCubesTetra().get(i).getPosX(), this.firstTetra.getCubesTetra().get(i).getPosY()) == true)
				return false;
		}

		return true;
	}
}
