package Tetris.cli;

import Tetris.logic.TetraS;
import Tetris.logic.Tetramino;
import Tetris.logic.Table;

public class Game {

	public static void main(String[] args) {
		Tetramino tetraS = new TetraS();
		
		Table.buildTable();
		tetraS.drawTetra();
		Table.drawTable();
	}
}
