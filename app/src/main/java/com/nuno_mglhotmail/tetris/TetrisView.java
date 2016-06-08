package com.nuno_mglhotmail.tetris;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.graphics.Bitmap;
import logic.*;

import static android.graphics.Bitmap.createScaledBitmap;

/**
 * Created by nuno_ on 20-May-16.
 */
public class TetrisView extends View
{
    private final BitmapFactory.Options options = new BitmapFactory.Options();

    private final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    private Bitmap TetraI;
    private Bitmap TetraJ;
    private Bitmap TetraO;
    private Bitmap TetraL;
    private Bitmap TetraT;
    private Bitmap TetraS;
    private Bitmap TetraZ;
    private Tetris tetris = null;

    public TetrisView(Context context, Tetris t)
    {
        super(context);
        options.inPreferredConfig=Bitmap.Config.RGB_565;
        TetraI = BitmapFactory.decodeResource(getResources(), R.drawable.tetrai, options);
        TetraJ = BitmapFactory.decodeResource(getResources(), R.drawable.tetral, options);
        TetraL = BitmapFactory.decodeResource(getResources(), R.drawable.tetral, options);
        TetraT = BitmapFactory.decodeResource(getResources(), R.drawable.tetrat, options);
        TetraS = BitmapFactory.decodeResource(getResources(), R.drawable.tetras, options);
        TetraZ = BitmapFactory.decodeResource(getResources(), R.drawable.tetras, options);
        TetraO = BitmapFactory.decodeResource(getResources(), R.drawable.tetrao, options);
        this.setBackground(getResources().getDrawable(R.drawable.tetirsbakground));
        this.tetris = t;
        this.setSystemUiVisibility(flags);
    }

    private void drawNext(Canvas canvas)
    {
        Tetramino.Type t = this.tetris.getSecondTetra().getType();

        double FACTORX0;
        double FACTORX1;
        double FACTORY0;
        double FACTORY1;

        if(t == Tetramino.Type.T)
        {
            FACTORX0 = 0.66;
            FACTORX1 = 0.92;
            FACTORY0 = 0.03;
            FACTORY1 = 0.16;
        }
        else if(t == Tetramino.Type.O)
        {
            FACTORX0 = 0.69;
            FACTORX1 = 0.95;
            FACTORY0 = 0.03;
            FACTORY1 = 0.16;
        }
        else if(t == Tetramino.Type.Z)
        {
            FACTORX0 = 0.66;
            FACTORX1 = 0.92;
            FACTORY0 = 0.03;
            FACTORY1 = 0.16;
        }
        else if(t == Tetramino.Type.S)
        {
            FACTORX0 = 0.66;
            FACTORX1 = 0.92;
            FACTORY0 = 0.03;
            FACTORY1 = 0.16;
        }
        else if(t == Tetramino.Type.J)
        {
            FACTORX0 = 0.69;
            FACTORX1 = 0.95;
            FACTORY0 = 0.05;
            FACTORY1 = 0.18;
        }
        else if(t == Tetramino.Type.L)
        {
            FACTORX0 = 0.69;
            FACTORX1 = 0.95;
            FACTORY0 = 0.05;
            FACTORY1 = 0.18;
        }
        else if(t == Tetramino.Type.I)
        {
            FACTORX0 = 0.72;
            FACTORX1 = 0.93;
            FACTORY0 = 0.02;
            FACTORY1 = 0.15;
        }
        else
        {
            FACTORX0 = 0.69;
            FACTORX1 = 0.95;
            FACTORY0 = 0.03;
            FACTORY1 = 0.16;
        }


        int screenHeight = getHeight();
        int screenWidth = getWidth();

        int x0,y0,x1,y1,tetrisWidth,tetrisHeight,cubeWidth,cubeHeight;

        screenHeight = getHeight();
        screenWidth = getWidth();

        //CALCULATIONS FOR TABLE TETRIS
        x0 = (int) (screenWidth* FACTORX0);
        y0 = (int) (screenHeight*FACTORY0);
        x1 = (int) (screenWidth* FACTORX1);
        y1 = (int) (screenHeight*FACTORY1);

        tetrisWidth = x1 - x0;
        tetrisHeight = y1 - y0;
        cubeWidth = tetrisWidth/ Tetramino.TETRATABLEWIDTH;
        cubeHeight = tetrisHeight / Tetramino.TETRATABLEHEIGTH;

        Bitmap TetraItemp = createScaledBitmap(TetraI,cubeWidth,cubeHeight,true);
        Bitmap TetraJtemp = createScaledBitmap(TetraJ,cubeWidth,cubeHeight,true);
        Bitmap TetraLtemp = createScaledBitmap(TetraL,cubeWidth,cubeHeight,true);
        Bitmap TetraTtemp = createScaledBitmap(TetraT,cubeWidth,cubeHeight,true);
        Bitmap TetraStemp = createScaledBitmap(TetraS,cubeWidth,cubeHeight,true);
        Bitmap TetraZtemp = createScaledBitmap(TetraZ,cubeWidth,cubeHeight,true);
        Bitmap TetraOtemp = createScaledBitmap(TetraO,cubeWidth,cubeHeight,true);


        char [][] table;
        table = this.tetris.getNextTetra();

        for(int j = 0; j < Tetramino.TETRATABLEHEIGTH; j++) {
            for (int i = 0; i < Tetramino.TETRATABLEWIDTH; i++) {
                if (table[j][i] == Cube.CHARI) {
                    canvas.drawBitmap(TetraItemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARJ) {
                    canvas.drawBitmap(TetraJtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARL) {
                    canvas.drawBitmap(TetraLtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARZ ) {
                    canvas.drawBitmap(TetraZtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                }   else if (table[j][i] == Cube.CHART) {
                    canvas.drawBitmap(TetraTtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARO) {
                    canvas.drawBitmap(TetraOtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARS) {
                    canvas.drawBitmap(TetraStemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);

                }
            }
        }
    }

    protected void drawTetris(Canvas canvas)
    {

        final double FACTORX0 = 0.105;
        final double FACTORX1 = 1 - FACTORX0;
        final double FACTORY0 = 0.236;
        final double FACTORY1 = 0.9484;

        int screenHeight = getHeight();
        int screenWidth = getWidth();

        int x0,y0,x1,y1,tetrisWidth,tetrisHeight,cubeWidth,cubeHeight;

        screenHeight = getHeight();
        screenWidth = getWidth();

        //CALCULATIONS FOR TABLE TETRIS
        x0 = (int) (screenWidth* FACTORX0);
        y0 = (int) (screenHeight*FACTORY0);
        x1 = (int) (screenWidth* FACTORX1);
        y1 = (int) (screenHeight*FACTORY1);

        tetrisWidth = x1 - x0;
        tetrisHeight = y1 - y0;
        cubeWidth = tetrisWidth/ Table.WIDTH;
        cubeHeight = tetrisHeight / Table.HEIGHT;

        Bitmap TetraItemp = createScaledBitmap(TetraI,cubeWidth,cubeHeight,true);
        Bitmap TetraJtemp = createScaledBitmap(TetraJ,cubeWidth,cubeHeight,true);
        Bitmap TetraLtemp = createScaledBitmap(TetraL,cubeWidth,cubeHeight,true);
        Bitmap TetraTtemp = createScaledBitmap(TetraT,cubeWidth,cubeHeight,true);
        Bitmap TetraStemp = createScaledBitmap(TetraS,cubeWidth,cubeHeight,true);
        Bitmap TetraZtemp = createScaledBitmap(TetraZ,cubeWidth,cubeHeight,true);
        Bitmap TetraOtemp = createScaledBitmap(TetraO,cubeWidth,cubeHeight,true);


        char[][] table;
        table = this.tetris.getTable();

        for(int j = 0; j < Table.HEIGHT; j++) {
            for (int i = 0; i < Table.WIDTH; i++) {
                if (table[j][i] == Cube.CHARI) {
                    canvas.drawBitmap(TetraItemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARJ) {
                    canvas.drawBitmap(TetraJtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARL) {
                    canvas.drawBitmap(TetraLtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARZ ) {
                    canvas.drawBitmap(TetraZtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                }   else if (table[j][i] == Cube.CHART) {
                    canvas.drawBitmap(TetraTtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARO) {
                    canvas.drawBitmap(TetraOtemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARS) {
                    canvas.drawBitmap(TetraStemp, x0 + i * cubeWidth, y0 + j * cubeHeight, null);

                }
            }
        }
    }


    private void draw(int numOfDigits){

    }

    private void drawLevel(Canvas canvas)
    {

        int level = this.tetris.getLevel();

        int nDigits = 1;

        if(level > 9)
            nDigits = 2;

        int screenHeight = getHeight();
        int screenWidth = getWidth();

        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTypeface(Menu.tetrisfont);
        p.setStyle(Paint.Style.FILL);
        p.setTextSize((int)(screenHeight * 0.03));

        final double FACTORX0 = 0.160;
        final double FACTORY0 = 0.115;

        double WIDTH = (FACTORX0 - 0.03);

        int x0 = (int) (screenWidth * FACTORX0);
        int y0 = (int) (screenHeight * FACTORY0);


        if(nDigits == 1) {
            //x0 = (int) (screenWidth * WIDTH);
            canvas.drawText(this.tetris.getLevelString(), x0, y0, p);
        }
        else if(nDigits == 2){
            x0 = (int) (screenWidth * WIDTH);
            canvas.drawText(this.tetris.getLevelString(), x0, y0, p);
        }
    }

    @TargetApi(19)
    private void drawScore(Canvas canvas)
    {

        int score = this.tetris.getScore();

        int nDigits = 1;

        if(score > 9 && score < 100)
            nDigits = 2;
        else if(score > 99)
            nDigits = 3;

        int screenHeight = getHeight();
        int screenWidth = getWidth();

        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTypeface(Menu.tetrisfont);
        p.setStyle(Paint.Style.FILL);
        p.setTextSize((int)(screenHeight * 0.03));
        //p.setLetterSpacing((float) -0.2);

        double FACTORX0 = 0.475;
        double FACTORY0 = 0.115;
        double WIDTH = (FACTORX0 - 0.02);

        int x0 = (int) (screenWidth * FACTORX0);
        int y0 = (int) (screenHeight * FACTORY0);

        if(nDigits == 1) {
            canvas.drawText(this.tetris.getScoreString(), x0, y0, p);
        }
        else if(nDigits == 2){
            x0 = (int) (screenWidth * WIDTH);
            canvas.drawText(this.tetris.getScoreString(), x0, y0, p);
        }
        else if(nDigits == 3){
            x0 = (int) (screenWidth * (WIDTH - 0.03));
            canvas.drawText(this.tetris.getScoreString(), x0, y0, p);
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawTetris(canvas);
        drawNext(canvas);
        drawLevel(canvas);
        drawScore(canvas);
    }

}
