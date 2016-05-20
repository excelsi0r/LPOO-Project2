package test;

import logic.Tetris;
import logic.Tetramino;
import logic.*;
import cli.*;

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

        int x1init, y1init;
        int x2init, y2init;
        int x3init, y3init;
        int x4init, y4init;

        int x1final, y1final;
        int x2final, y2final;
        int x3final, y3final;
        int x4final, y4final;


        firstTetra.moveDown();
        secondTetra.moveDown();

    }

}