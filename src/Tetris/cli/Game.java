package tetris.cli;

import tetris.logic.Table;
import tetris.logic.TetraS;

public class Game {

	public static void main(String[] args) {
		TetraS tetraS = new TetraS();
		
		Table.buildTable();
		tetraS.drawTetraS();
		Table.drawTable();
	}
}
