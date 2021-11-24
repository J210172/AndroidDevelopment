package com.example.hipotenochas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Intent difficultySelectIntent = new Intent(this, DifficultySelection.class);
        Intent howToPlayIntent = new Intent(this, HowToPlay.class);
        Intent scoreboardIntent = new Intent(this, Scoreboard.class);

        findViewById(R.id.PlayButton).setOnClickListener(v -> startActivity(difficultySelectIntent));
        findViewById(R.id.ScoreboardButton).setOnClickListener(v -> startActivity(scoreboardIntent));
        findViewById(R.id.HowToPlayButton).setOnClickListener(v -> startActivity(howToPlayIntent));
    }


}