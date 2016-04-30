package Tetris.logic;

public class Cube {
	
	private char symbol = '#';
	private int posX ;
	private int posY;
	
	public Cube() 
	{
		super();
	}
	
	public Cube(int y, int x)
	{
		posX = x;
		posY = y;
	}
	
	public Cube(char symbol, int y, int x)
	{
		this.symbol = symbol;
		posX = x;
		posY = y;
	}

	public Cube(Cube cube) {
		symbol = cube.getSymbol();
		posX = cube.getPosX();
		posY = cube.getPosY();
	}

	public void setPosXandY(int posY, int posX) 
	{
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() 
	{
		return posX;
	}
	
	public int getPosY() 
	{
		return posY;
	}

	public char getSymbol() 
	{
		return symbol;
	}
	
	public void setSymbol(char symbol) 
	{
		this.symbol = symbol;
	}
	
	public void moveDown()
	{
		this.posY += 1;
	}
	
	public void moveLeft()
	{
		this.posX += -1;
	}
	
	public void moveRight()
	{
		this.posX += 1;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(symbol);
		return sb.toString();
	}
	
	public Cube clone(){
		return new Cube(this);
	}
	
}