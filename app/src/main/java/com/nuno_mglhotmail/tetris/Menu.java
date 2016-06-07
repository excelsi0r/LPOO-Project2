package com.nuno_mglhotmail.tetris;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.graphics.Typeface;

/**
 * Menu Class Ativity. With a song, Font and Flags
 */
public class Menu extends Activity implements View.OnClickListener
{
    MediaPlayer song;
    public static int resumetimesiong;

    final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    public static Typeface tetrisfont;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //FONT FOR COLORS
        tetrisfont = Typeface.createFromAsset(getAssets(), "EarlyGameBoy.ttf");

        super.onCreate(savedInstanceState);
        //MUSIc
        song = MediaPlayer.create(this, R.raw.tetris);
        song.setLooping(true);
        song.start();

        setContentView(R.layout.activity_menu);

        Button quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(this);
        quit.setTypeface(tetrisfont);

        Button single = (Button) findViewById(R.id.single);
        single.setOnClickListener(this);
        single.setTypeface(tetrisfont);


        getWindow().getDecorView().setSystemUiVisibility(flags);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        song.release();
        song = MediaPlayer.create(this, R.raw.tetris);
        song.setLooping(true);
        song.seekTo(resumetimesiong);
        song.start();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        song.stop();
        resumetimesiong = song.getCurrentPosition();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.quit:
                System.exit(0);
            case R.id.single:
            {
                createTetrisScreen(v);
            }
        }
    }

    /**
     * New Tetris Activity
     * @param v
     */
    public void createTetrisScreen(View v)
    {
        Intent i = new Intent(this, TetrisApp.class);
        startActivity(i);
    }

    /*
    public void createVersus(View v)
    {
        Intent i = new Intent(this, BluetoothTetris.class);
        startActivity(i);
    }
    */
}
