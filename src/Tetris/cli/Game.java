package Tetris.cli;

import Tetris.logic.TetraS;
import Tetris.logic.Table;

public class Game {

	public static void main(String[] args) {
		TetraS tetraS = new TetraS();
		
		Table.buildTable();
		tetraS.drawTetraS();
		Table.drawTable();
	}
}
