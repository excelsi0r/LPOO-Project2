package Tetris.cli;

import Tetris.logic.TetraS;
import Tetris.logic.TetraT;
import Tetris.logic.TetraZ;
import Tetris.logic.Tetramino;
import Tetris.logic.Table;
import Tetris.logic.TetraI;
import Tetris.logic.TetraJ;
import Tetris.logic.TetraL;
import Tetris.logic.TetraO;

public class Game {

	public static void main(String[] args) {
		Tetramino tetraS = new TetraS();
		Tetramino tetraL = new TetraL();
		Tetramino tetraJ = new TetraJ();
		Tetramino tetraT = new TetraT();
		Tetramino tetraZ = new TetraZ();
		Tetramino tetraI = new TetraI();
		Tetramino tetraO = new TetraO();
		
		Table.buildTable();
		//tetraS.drawTetra();
		//tetraL.drawTetra();
		//tetraJ.drawTetra();
		//tetraT.drawTetra();
		tetraZ.drawTetra();
		//tetraI.drawTetra();
		//tetraO.drawTetra();
		Table.drawTable();
		
		System.out.println();
	}
}
