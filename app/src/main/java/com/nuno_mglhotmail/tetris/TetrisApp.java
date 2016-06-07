package com.nuno_mglhotmail.tetris;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import logic.*;

/**
 * Tetris Activity.
 */

public class TetrisApp extends Activity
{
    TetrisView tview = null;
    Tetris tetris = null;
    int state = 0;
    Thread thread;
    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        tetris = new Tetris();
        this.tetris.initialize();
        tview = new TetrisView(this,tetris);

        song = MediaPlayer.create(this, R.raw.tetris);
        song.seekTo(Menu.resumetimesiong);
        song.setLooping(true);
        song.start();

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
        thread = new Thread(new Refresh());
        thread.start();


    }


    /**
     * Class to Refresh
     */
    class Refresh implements Runnable
    {
        public void run()
        {
            while (!Thread.currentThread().isInterrupted() && tetris.getState() != GameState.State.LOST)
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
                state = 1;
                finish();
                createGameOver();
            }
        }
    }

    /**
     * Create GameOver
     */
    public void createGameOver()
    {
        Intent i = new Intent(this, GameOver.class);
        startActivity(i);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        song.stop();
        Menu.resumetimesiong = song.getCurrentPosition();
        state = 1;
        thread.interrupt();
        finish();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        song.release();
        song = MediaPlayer.create(this, R.raw.tetris);
        song.setLooping(true);
        song.seekTo(Menu.resumetimesiong);
        song.start();
    }


}
