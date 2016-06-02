package com.nuno_mglhotmail.tetris;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import logic.*;

public class TetrisApp extends Activity
{
    TetrisView tview = null;
    Tetris tetris = null;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        tetris = new Tetris();
        this.tetris.initialize();
        tview = new TetrisView(this,tetris);
        tview.setOnTouchListener(new OnSwipeTouchListener(TetrisApp.this)
        {
            public void onSwipeRight()
            {
                tetris.moveRight();
                tview.invalidate();
            }
            public void onSwipeLeft()
            {
                tetris.moveLeft();
                tview.invalidate();
            }
            public void onSwipeTop()
            {

            }
            public void onSwipeBottom()
            {
                tetris.moveDown();
                tview.invalidate();
            }

            public void doubleTap()
            {
                tetris.rotate();
                tview.invalidate();
            }

        });
        setContentView(tview);
        new Thread(new Refresh()).start();
    }


    class Refresh implements Runnable
    {
        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
                try
                {
                    Thread.sleep(tetris.getSpeed());

                }
                catch (Exception ex)
                {
                    Thread.currentThread().interrupt();
                }
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        tetris.moveDown();
                        tview.invalidate();
                    }
                });
            }
        }
    }


}
