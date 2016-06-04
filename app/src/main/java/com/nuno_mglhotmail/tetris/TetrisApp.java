package com.nuno_mglhotmail.tetris;

import android.app.Activity;
import android.content.Intent;
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
    int state = 0;

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

                if(tetris.getState() == GameState.State.LOST)
                {
                    Thread.currentThread().interrupt();
                    if(state == 0)
                    {
                        state = 1;
                        finish();
                        createGameOver();
                    }
                }
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
            while (!Thread.currentThread().isInterrupted() && tetris.getState() != GameState.State.LOST)
            {
                try
                {
                    //Thread.sleep(tetris.getSpeed());
                    Thread.sleep(100);

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

                        System.out.println(Thread.activeCount());
                        if(tetris.getState() == GameState.State.LOST)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                });
            }

            if(state == 0)
            {
                finish();
                createGameOver();
            }


        }
    }

    public void createGameOver()
    {
        Intent i = new Intent(this, GameOver.class);
        startActivity(i);
    }


}
