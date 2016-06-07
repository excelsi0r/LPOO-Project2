package com.nuno_mglhotmail.tetris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import logic.Tetris;

public class GameOver extends Activity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(this);
        restart.setTypeface(Menu.tetrisfont);

        Button menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(this);
        menu.setTypeface(Menu.tetrisfont);

        TextView game = (TextView) findViewById(R.id.game);
        game.setKeyListener(null);
        game.setTypeface(Menu.tetrisfont);

        TextView over = (TextView) findViewById(R.id.over);
        over.setKeyListener(null);
        over.setTypeface(Menu.tetrisfont);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.restart:
            {
                finish();
                createTetrisScreen(v);
            }
            case R.id.menu:
            {
                returnMenu();
            }

        }
    }

    public void createTetrisScreen(View v)
    {
        Intent i = new Intent(this, TetrisApp.class);
        startActivity(i);
    }

    public void returnMenu()
    {
        finish();
    }

    @Override
    public void onBackPressed()
    {
        returnMenu();
    }
}
