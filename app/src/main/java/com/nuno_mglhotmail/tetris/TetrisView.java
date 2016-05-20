package com.nuno_mglhotmail.tetris;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.graphics.Bitmap;
import logic.*;

/**
 * Created by nuno_ on 20-May-16.
 */
public class TetrisView extends View
{
    private final BitmapFactory.Options options = new BitmapFactory.Options();
    private Bitmap TetraI;
    private Bitmap TetraJ;
    private Bitmap TetraO;
    private Bitmap TetraL;
    private Bitmap TetraT;
    private Bitmap TetraS;
    private Bitmap TetraZ;
    private Tetris tetris;

    public TetrisView(Context context)
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
        tetris = new Tetris();
        tetris.initialize();

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
                    canvas.drawBitmap(TetraI, x + i*75,y+j*75,null);
                }
            }
        }



    }
}
