package com.nuno_mglhotmail.tetris;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.graphics.Bitmap;
import logic.*;
import android.os.Handler;

/**
 * Created by nuno_ on 20-May-16.
 */
public class TetrisView extends View
{
    private final BitmapFactory.Options options = new BitmapFactory.Options();

    private static Bitmap TetraI;
    private static Bitmap TetraJ;
    private static Bitmap TetraO;
    private static Bitmap TetraL;
    private static Bitmap TetraT;
    private static Bitmap TetraS;
    private static Bitmap TetraZ;
    private static Tetris tetris = null;

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
        this.tetris = t;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x = 10;
        int y = 10;

        char[][] table;
        table = this.tetris.getTable();

        for(int j = 0; j < Table.HEIGHT; j++)
        {
            for (int i = 0; i < Table.WIDTH; i++)
            {
                if (table[j][i] == '#')
                {
                    canvas.drawBitmap(TetraI, x + i*115,y+j*115,null);
                }
            }
        }



    }
}
