package Tetris.logic;

public class TetraS extends Tetramino{

	public TetraS(Cube cube1, Cube cube2, Cube cube3, Cube cube4) {
		super(cube1, cube2, cube3, cube4);
	}

	@Override
	public void rotate() {
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		return sb.toString();
	}

}
