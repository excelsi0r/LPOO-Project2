package Tetris.logic;

public class Cube {
	
	private char elem;
	private int posX;
	private int posY;
	
	public Cube(){
		elem = '#';
	}
	
	/**
	 * @param elem Elem representing Cunbe Object
	 * @param posX X Cube Position
	 * @param posY Y Cube Position
	 */
	public Cube(char elem, int posX, int posY) {
		super();
		this.elem = elem;
		this.posX = posX;
		this.posY = posY;
	}

	public Cube(Cube cube) {
		this.elem = getElem();
		this.posX = getPosX();
		this.posY = getPosY();
	}

	/**
	 * @return the elem
	 */
	public char getElem() {
		return elem;
	}

	/**
	 * @param elem the elem to set
	 */
	public void setElem(char elem) {
		this.elem = elem;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(elem);
		return sb.toString();
	}
	
	public Cube clone(){
		return new Cube(this);
	}
	
}