package com.nuno_mglhotmail.tetris;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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
        this.setBackground(getResources().getDrawable(R.drawable.fundotetris));
        this.tetris = t;
        this.setSystemUiVisibility(flags);
    }

    protected void drawTetris(Canvas canvas)
    {

        int screenHeight = getHeight();
        int screenWidth = getWidth();

        int x0,y0,x1,y2,tetrisWidth,tetrisHeight,cubeWidth,cubeHeight;
        
        screenHeight = getHeight();
        screenWidth = getWidth();

        //CALCULATIONS FOR TABLE TETRIS
        x0 = (int) (screenWidth*0.05);
        y0 = (int) (screenHeight*0.21);
        x1 = (int) (screenWidth*0.95);
        y2 = (int) (screenHeight*0.97);

        tetrisWidth = x1 - x0;
        tetrisHeight = y2 - y0;
        cubeWidth = tetrisWidth/ Table.WIDTH;
        cubeHeight = tetrisHeight / Table.HEIGHT;
        TetraI = createScaledBitmap(TetraI,cubeWidth,cubeHeight,true);
        TetraJ = createScaledBitmap(TetraJ,cubeWidth,cubeHeight,true);
        TetraL = createScaledBitmap(TetraL,cubeWidth,cubeHeight,true);
        TetraT = createScaledBitmap(TetraT,cubeWidth,cubeHeight,true);
        TetraS = createScaledBitmap(TetraS,cubeWidth,cubeHeight,true);
        TetraZ = createScaledBitmap(TetraZ,cubeWidth,cubeHeight,true);
        TetraO = createScaledBitmap(TetraO,cubeWidth,cubeHeight,true);


        char[][] table;
        table = this.tetris.getTable();

        for(int j = 0; j < Table.HEIGHT; j++) {
            for (int i = 0; i < Table.WIDTH; i++) {
                if (table[j][i] == Cube.CHARI) {
                    canvas.drawBitmap(TetraI, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARJ) {
                    canvas.drawBitmap(TetraJ, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARL) {
                    canvas.drawBitmap(TetraL, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHART) {
                    canvas.drawBitmap(TetraT, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARO) {
                    canvas.drawBitmap(TetraO, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARS) {
                    canvas.drawBitmap(TetraS, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                } else if (table[j][i] == Cube.CHARZ) {
                    canvas.drawBitmap(TetraZ, x0 + i * cubeWidth, y0 + j * cubeHeight, null);
                }
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawTetris(canvas);
    }
}
