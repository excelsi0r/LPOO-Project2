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
	
	int x0init, y0init;
    int x1init, y1init;
    int x2init, y2init;
    int x3init, y3init;
    
    int x0final, y0final;
    int x1final, y1final;
    int x2final, y2final;
    int x3final, y3final;
    
    void moveInit(Tetramino tetramino){
    	x0init = tetramino.getCubesTetra().get(0).getPosX();
        x1init = tetramino.getCubesTetra().get(1).getPosX();
        x2init = tetramino.getCubesTetra().get(2).getPosX();
        x3init = tetramino.getCubesTetra().get(3).getPosX();
        
        y0init = tetramino.getCubesTetra().get(0).getPosY();
        y1init = tetramino.getCubesTetra().get(1).getPosY();
        y2init = tetramino.getCubesTetra().get(2).getPosY();
        y3init = tetramino.getCubesTetra().get(3).getPosY();
    }
    
    void moveFinal(Tetramino tetramino){
    	x0final = tetramino.getCubesTetra().get(0).getPosX();
        x1final = tetramino.getCubesTetra().get(1).getPosX();
        x2final = tetramino.getCubesTetra().get(2).getPosX();
        x3final = tetramino.getCubesTetra().get(3).getPosX();
        
        y0final = tetramino.getCubesTetra().get(0).getPosY();
        y1final = tetramino.getCubesTetra().get(1).getPosY();
        y2final = tetramino.getCubesTetra().get(2).getPosY();
        y3final = tetramino.getCubesTetra().get(3).getPosY();
    }
	

    @org.junit.Test (timeout = 1000)
    public void TetraMoveDown(){
        Tetris tetris =  new Tetris();
        tetris.initialize();
        Tetramino firstTetra;
        firstTetra = tetris.getFirstTetra();

        moveInit(firstTetra);
        
        tetris.moveDown();
        
        moveFinal(firstTetra);

        assertEquals(x0init, x0final);
        assertEquals(x1init, x1final);
        assertEquals(x2init, x2final);
        assertEquals(x3init, x3final);
        
        assertEquals(y0init + 1, y0final);
        assertEquals(y1init + 1, y1final);
        assertEquals(y2init + 1, y2final);
        assertEquals(y3init + 1, y3final);
    }
    
    @org.junit.Test (timeout = 1000)
    public void TetraMoveLeft(){
        Tetris tetris =  new Tetris();
        tetris.initialize();
        Tetramino firstTetra;
        firstTetra = tetris.getFirstTetra();

        moveInit(firstTetra);
        
        tetris.moveLeft();
        
        moveFinal(firstTetra);

        assertEquals(x0init - 1, x0final);
        assertEquals(x1init - 1, x1final);
        assertEquals(x2init - 1, x2final);
        assertEquals(x3init - 1, x3final);
        
        assertEquals(y0init, y0final);
        assertEquals(y1init, y1final);
        assertEquals(y2init, y2final);
        assertEquals(y3init, y3final);
    }
    
    @org.junit.Test (timeout = 1000)
    public void TetraMoveRight(){
        Tetris tetris =  new Tetris();
        tetris.initialize();
        Tetramino firstTetra;
        firstTetra = tetris.getFirstTetra();

        moveInit(firstTetra);
        
        tetris.moveRight();
        
        moveFinal(firstTetra);

        assertEquals(x0init + 1, x0final);
        assertEquals(x1init + 1, x1final);
        assertEquals(x2init + 1, x2final);
        assertEquals(x3init + 1, x3final);
        
        assertEquals(y0init, y0final);
        assertEquals(y1init, y1final);
        assertEquals(y2init, y2final);
        assertEquals(y3init, y3final);
    }
}