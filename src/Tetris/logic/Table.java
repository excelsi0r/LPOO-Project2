package Tetris.logic;
import java.util.Arrays;


public class Table {
	
	static char[][] tableBoard = new char[20][12];
	
	public static void buildTable(){
		for(char[] row : tableBoard){
			Arrays.fill(row, ' ');
		}
	}
	
	private static void tableBoarders(){
		int x = 0;
		while (x < tableBoard[0].length) {
			System.out.print('&' + " ");
			x++;
		}	
	}
	
	public static void drawTable(){
		
		tableBoarders();
		for(int y = 0; y < tableBoard.length; y++){
			for(int x = 0; x < tableBoard[0].length; x++){
				System.out.print(tableBoard[y][x] + " ");
			}
			System.out.println();
		}
		tableBoarders();
		
	}
	
	public static void drawCubes(Cube[] cube){
		
		tableBoard[cube[0].getPosY()][cube[0].getPosX()] = cube[0].getSymbol();
		tableBoard[cube[1].getPosY()][cube[1].getPosX()] = cube[1].getSymbol();
		tableBoard[cube[2].getPosY()][cube[2].getPosX()] = cube[2].getSymbol();
		tableBoard[cube[3].getPosY()][cube[3].getPosX()] = cube[3].getSymbol();
		
	}

}
