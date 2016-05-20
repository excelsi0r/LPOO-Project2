package Tetris.test;

import Tetris.logic.Tetris;
import Tetris.logic.Tetramino;

import static org.junit.Assert.*;

/**
 * Tests
 */
public class TetraminosTest {

    @org.junit.Test (timeout = 1000)
    public void TetraMoveDown(){
        Tetris tetris =  new Tetris();
        tetris.initialize();
        Tetramino firstTetra, secondTetra;
        firstTetra = tetris.getFirstTetra();
        secondTetra = tetris.getSecondTetra();

        int posX, posY;

        firstTetra.getType();



        firstTetra.moveDown();
        secondTetra.moveDown();

    }

}