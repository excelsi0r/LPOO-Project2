package Tetris.logic;

public abstract class Tetramino {
	private int rotate;
	private Cube cube1, cube2, cube3, cube4;
	
	/**
	 * Four Cubes to create a Tetramino piece
	 * @param rotate rotates Tetramino
	 * @param cube1 1st Cube
	 * @param cube2 2nd Cube
	 * @param cube3 3rd Cube
	 * @param cube4 4th Cube
	 */
	public Tetramino(int rotate, Cube cube1, Cube cube2, Cube cube3, Cube cube4) {
		super();
		this.cube1 = cube1;
		this.cube2 = cube2;
		this.cube3 = cube3;
		this.cube4 = cube4;
	}
	/**
	 * @return the rotate
	 */
	public int getRotate() {
		return rotate;
	}
	/**
	 * @param rotate the rotate to set
	 */
	public void setRotate(int rotate) {
		this.rotate = rotate;
	}
	/**
	 * @return the cube1
	 */
	public Cube getCube1() {
		return cube1;
	}
	/**
	 * @param cube1 the cube1 to set
	 */
	public void setCube1(Cube cube1) {
		this.cube1 = cube1;
	}
	/**
	 * @return the cube2
	 */
	public Cube getCube2() {
		return cube2;
	}
	/**
	 * @param cube2 the cube2 to set
	 */
	public void setCube2(Cube cube2) {
		this.cube2 = cube2;
	}
	/**
	 * @return the cube3
	 */
	public Cube getCube3() {
		return cube3;
	}
	/**
	 * @param cube3 the cube3 to set
	 */
	public void setCube3(Cube cube3) {
		this.cube3 = cube3;
	}
	/**
	 * @return the cube4
	 */
	public Cube getCube4() {
		return cube4;
	}
	/**
	 * @param cube4 the cube4 to set
	 */
	public void setCube4(Cube cube4) {
		this.cube4 = cube4;
	}
	
	public abstract void rotate();
}
