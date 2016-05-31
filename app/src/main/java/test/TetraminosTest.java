package test;

import logic.Tetris;
import logic.TetraI;
import logic.TetraJ;
import logic.TetraL;
import logic.TetraO;
import logic.TetraS;
import logic.TetraT;
import logic.TetraZ;
import logic.Tetramino;
import static org.junit.Assert.*;

import java.util.ArrayList;

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
    
    private void moveInit(Tetramino tetramino){
    	x0init = tetramino.getCubesTetra().get(0).getPosX();
        x1init = tetramino.getCubesTetra().get(1).getPosX();
        x2init = tetramino.getCubesTetra().get(2).getPosX();
        x3init = tetramino.getCubesTetra().get(3).getPosX();
        
        y0init = tetramino.getCubesTetra().get(0).getPosY();
        y1init = tetramino.getCubesTetra().get(1).getPosY();
        y2init = tetramino.getCubesTetra().get(2).getPosY();
        y3init = tetramino.getCubesTetra().get(3).getPosY();
    }
    
    private void moveFinal(Tetramino tetramino){
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
    
    
    private void tetraTestRotation(int x0, int x1, int x2, int x3, int y0, int y1, int y2, int y3){
    	System.out.println("Xinit - Xfinal");
    	System.out.print(x0init + "       ");System.out.println(x0final);//for debug purposes
    	System.out.print(x1init + "       ");System.out.println(x1final);
    	System.out.print(x2init + "       ");System.out.println(x2final);
    	System.out.print(x3init + "       ");System.out.println(x3final);
    	assertEquals(x0init + x0, x0final);
        assertEquals(x1init + x1, x1final);
        assertEquals(x2init + x2, x2final);
        assertEquals(x3init + x3, x3final);
      	System.out.println("Yinit - Yfinal");
        System.out.print(y0init + "       ");System.out.println(y0final);
    	System.out.print(y1init + "       ");System.out.println(y1final);
    	System.out.print(y2init + "       ");System.out.println(y2final);
    	System.out.print(y3init + "       ");System.out.println(y3final);
        assertEquals(y0init + y0, y0final);
        assertEquals(y1init + y1, y1final);
        assertEquals(y2init + y2, y2final);
        assertEquals(y3init + y3, y3final);
        
    }
    
    
    @org.junit.Test (timeout = 2000)
    public void testRotaion() {
    	Tetris tetris =  new Tetris();
    	Tetramino firstTetra;
    	
    	ArrayList<Tetramino> tetras = new ArrayList<>();
    	tetras.add(new TetraI());
    	tetras.add(new TetraS());
    	tetras.add(new TetraZ());
    	tetras.add(new TetraL());
    	tetras.add(new TetraJ());
    	tetras.add(new TetraT());
    	tetras.add(new TetraO());
    	
    	for (Tetramino tetramino : tetras) {
    		
    		tetris.testConstructor(tetramino);
    		
    		firstTetra = tetris.getFirstTetra();
    		
    		if( firstTetra instanceof TetraI ){
        		System.out.println(firstTetra.getClass().getName());
        		int x0 = 2; int x1 = 1; int x2 = 0; int x3 = -1; int y0 = -2; int y1 = -1; int y2 = 0; int y3 = 1;
        		//To enable rotation
        		tetris.moveDown();
        		
        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(x0, x1, x2, x3, y0, y1, y2, y3);
        		/**
        		 * Second rotation
        		 */
        		int xx0 = -2; int xx1 = -1; int xx2 = 0; int xx3 = 1; int yy0 = 2; int yy1 = 1; int yy2 = 0; int yy3 = -1;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xx0, xx1, xx2, xx3, yy0, yy1, yy2, yy3);
        	}
    		
        	if( firstTetra instanceof TetraL )
        	{
        		System.out.println(firstTetra.getClass().getName());
        		int x0 = 1; int x1 = 0; int x2 = -1; int x3 = 0; int y0 = -1; int y1 = 0; int y2 = 1; int y3 = -2;
        		/*To enable rotation*/
        		tetris.moveDown();
        		
        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(x0, x1, x2, x3, y0, y1, y2, y3);
        		/**
        		 * Second rotation
        		 */
        		int xx0 = 1; int xx1 = 0; int xx2 = -1; int xx3 = 2; int yy0 = 1; int yy1 = 0; int yy2 = -1; int yy3 = 0;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xx0, xx1, xx2, xx3, yy0, yy1, yy2, yy3);
        		/**
        		 * Third rotation
        		 */
        		int xxx0 = -1; int xxx1 = 0; int xxx2 = 1; int xxx3 = 0; int yyy0 = 1; int yyy1 = 0; int yyy2 = -1; int yyy3 = 2;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xxx0, xxx1, xxx2, xxx3, yyy0, yyy1, yyy2, yyy3);
        		/**
        		 * Fourth rotation
        		 */
        		int xxxx0 = -1; int xxxx1 = 0; int xxxx2 = 1; int xxxx3 = -2; int yyyy0 = -1; int yyyy1 = 0; int yyyy2 = 1; int yyyy3 = 0;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xxxx0, xxxx1, xxxx2, xxxx3, yyyy0, yyyy1, yyyy2, yyyy3);
        	}
        		

        	else if( firstTetra instanceof TetraJ ){
        		System.out.println(firstTetra.getClass().getName());
        		int x0 = 1; int x1 = 0; int x2 = -1; int x3 = -2; int y0 = -1; int y1 = 0; int y2 = 1; int y3 = 0;
        		/*To enable rotation*/
        		tetris.moveDown();
        		
        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(x0, x1, x2, x3, y0, y1, y2, y3);
        		/**
        		 * Second rotation
        		 */
        		int xx0 = 1; int xx1 = 0; int xx2 = -1; int xx3 = 0; int yy0 = 1; int yy1 = 0; int yy2 = -1; int yy3 = -2;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xx0, xx1, xx2, xx3, yy0, yy1, yy2, yy3);
        		/**
        		 * Third rotation
        		 */
        		int xxx0 = -1; int xxx1 = 0; int xxx2 = 1; int xxx3 = 2; int yyy0 = 1; int yyy1 = 0; int yyy2 = -1; int yyy3 = 0;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xxx0, xxx1, xxx2, xxx3, yyy0, yyy1, yyy2, yyy3);
        		/**
        		 * Fourth rotation
        		 */
        		int xxxx0 = -1; int xxxx1 = 0; int xxxx2 = 1; int xxxx3 = 0; int yyyy0 = -1; int yyyy1 = 0; int yyyy2 = 1; int yyyy3 = 2;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xxxx0, xxxx1, xxxx2, xxxx3, yyyy0, yyyy1, yyyy2, yyyy3);
        	}
        		
        	else if( firstTetra instanceof TetraZ ){
        		System.out.println(firstTetra.getClass().getName());
        		int x0 = 1; int x1 = 0; int x2 = 1; int x3 = 0; int y0 = 1; int y1 = 0; int y2 = -1; int y3 = -2;
        		/*To enable rotation*/
        		tetris.moveDown();
        		
        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(x0, x1, x2, x3, y0, y1, y2, y3);
        		/**
        		 * Second rotation
        		 */
        		int xx0 = -1; int xx1 = 0; int xx2 = -1; int xx3 = 0; int yy0 = -1; int yy1 = 0; int yy2 = 1; int yy3 = 2;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xx0, xx1, xx2, xx3, yy0, yy1, yy2, yy3);
        	}

        	else if( firstTetra instanceof TetraO ){
        		System.out.println(firstTetra.getClass().getName());
        		int x0 = 0; int x1 = 0; int x2 = 0; int x3 = 0; int y0 = 0; int y1 = 0; int y2 = 0; int y3 = 0;
        		/*To enable rotation*/
        		tetris.moveDown();
        		
        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(x0, x1, x2, x3, y0, y1, y2, y3);
        	
        	}

        	else if( firstTetra instanceof TetraS ){
        		System.out.println(firstTetra.getClass().getName());
        		int x0 = 0; int x1 = -1; int x2 = 0; int x3 = -1; int y0 = -2; int y1 = -1; int y2 = 0; int y3 = 1;
        		/*To enable rotation*/
        		tetris.moveDown();
        		
        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(x0, x1, x2, x3, y0, y1, y2, y3);
        		/**
        		 * Second rotation
        		 */
        		int xx0 = 0; int xx1 = 1; int xx2 = 0; int xx3 = 1; int yy0 = 2; int yy1 = 1; int yy2 = 0; int yy3 = -1;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xx0, xx1, xx2, xx3, yy0, yy1, yy2, yy3);
        	}

        	else if( firstTetra instanceof TetraT ){
        		System.out.println(firstTetra.getClass().getName());
        		int x0 = 1; int x1 = 0; int x2 = -1; int x3 = -1; int y0 = -1; int y1 = 0; int y2 = 1; int y3 = -1;
        		/*To enable rotation*/
        		tetris.moveDown();
        		
        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(x0, x1, x2, x3, y0, y1, y2, y3);
        		/**
        		 * Second rotation
        		 */
        		int xx0 = 1; int xx1 = 0; int xx2 = -1; int xx3 = 1; int yy0 = 1; int yy1 = 0; int yy2 = -1; int yy3 = -1;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xx0, xx1, xx2, xx3, yy0, yy1, yy2, yy3);
        		/**
        		 * Third rotation
        		 */
        		int xxx0 = -1; int xxx1 = 0; int xxx2 = 1; int xxx3 = 1; int yyy0 = 1; int yyy1 = 0; int yyy2 = -1; int yyy3 = 1;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xxx0, xxx1, xxx2, xxx3, yyy0, yyy1, yyy2, yyy3);
        		/**
        		 * Fourth rotation
        		 */
        		int xxxx0 = -1; int xxxx1 = 0; int xxxx2 = 1; int xxxx3 = -1; int yyyy0 = -1; int yyyy1 = 0; int yyyy2 = 1; int yyyy3 = 1;

        		moveInit(firstTetra);
        		
        		tetris.rotate();
        		
        		moveFinal(firstTetra);
        		
        		tetraTestRotation(xxxx0, xxxx1, xxxx2, xxxx3, yyyy0, yyyy1, yyyy2, yyyy3);
        	}
        		
		}

    }
}