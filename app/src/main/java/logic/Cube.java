package logic;

/**
 * 
 * Cube Class representing one of 4 cubes in a tetramino
 * Has a symbol given upon the creation of the Tetramino
 * an X and Y Coordenate
 *
 */

public class Cube 
{
	public final static char CHARS = 'S';
	public final static char CHARZ = 'Z';
	public final static char CHARL = 'L';
	public final static char CHARJ = 'J';
	public final static char CHART = 'T';
	public final static char CHARO = 'O';
	public final static char CHARI = 'I';
	
	
	private char symbol;
	private int posX ;
	private int posY;

	/**
	 * Default Constructor for Cube
	 */
	public Cube() {}
	
	/**
	 * Constructor with coordenates only
	 * @param x
	 * @param y
	 */
	public Cube(int x, int y)
	{
		super();
		posX = x;
		posY = y;
	}
	
	/**
	 * Full constructor redefining every paramether
	 * @param symbol
	 * @param x
	 * @param y
	 */
	public Cube(char symbol, int x, int y)
	{
		this.symbol = symbol;
		posX = x;
		posY = y;
	}
	/**
	 * Copy Constructor
	 * @param cube
	 */
	public Cube(Cube cube) 
	{
		symbol = cube.getSymbol();
		posX = cube.getPosX();
		posY = cube.getPosY();
	}
	/**
	 * Setting position X and Y
	 * @param posX
	 * @param posY
	 */
	public void setPosXandY(int posX, int posY) 
	{
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * Returning X
	 * @return posX
	 */
	public int getPosX() 
	{
		return posX;
	}
	/**
	 * Returning Y
	 * @return posY
	 */
	public int getPosY() 
	{
		return posY;
	}
	/**
	 * Returning Symbol
	 * @return symbol
	 */
	public char getSymbol() 
	{
		return symbol;
	}
	
	/**
	 * Setting the Symbol
	 * @param symbol
	 */
	public void setSymbol(char symbol) 
	{
		this.symbol = symbol;
	}
	/**
	 * Moving down the cube on table. General ( +1y )
	 */
	public void moveDown()
	{
		this.posY += 1;
	}
	/**
	 * Moving Left. (-1x)
	 */
	public void moveLeft()
	{
		this.posX += -1;
	}
	/**
	 * Moving Rigth(+1x)
	 */
	public void moveRight()
	{
		this.posX += 1;
	}
	/**
	 * Moving up (-1y). Only used in rotations
	 */
	public void moveUp()
	{
		this.posY += -1;
	}
	/**
	 * Convert to String
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(symbol);
		return sb.toString();
	}
	/**
	 * Clone Function
	 */
	public Cube clone()
	{
		return new Cube(this);
	}

	
}