package com.nuno_mglhotmail.tetris;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.graphics.Typeface;
import android.view.Window;
import android.view.WindowManager;


public class Menu extends Activity implements View.OnClickListener
{
    MediaPlayer song;
    int resumetimesiong;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //FONT FOR COLORS
        final Typeface tetrisfont = Typeface.createFromAsset(getAssets(), "EarlyGameBoy.ttf");

        super.onCreate(savedInstanceState);

        //FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);


        Button quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(this);
        quit.setTypeface(tetrisfont);

        Button single = (Button) findViewById(R.id.single);
        single.setOnClickListener(this);
        single.setTypeface(tetrisfont);


        Button versus = (Button) findViewById(R.id.versus);
        versus.setOnClickListener(this);
        versus.setTypeface(tetrisfont);

        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(this);
        settings.setTypeface(tetrisfont);

        //MUSIc
        song = MediaPlayer.create(this, R.raw.tetris);
        song.setLooping(true);
        song.start();

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        song.seekTo(resumetimesiong);
        song.start();

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        song.pause();
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
                createTetrisScreen(v);

        }
    }

    public void createTetrisScreen(View v)
    {
        Intent i = new Intent(this, TetrisScreen.class);
        startActivity(i);
    }
}
