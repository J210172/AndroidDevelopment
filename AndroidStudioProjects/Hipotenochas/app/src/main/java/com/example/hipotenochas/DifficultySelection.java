package com.example.hipotenochas;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DifficultySelection extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_selection_layout);

        Intent easyGameIntent = new Intent(this, Game.class);
        findViewById(R.id.EasyButton).setOnClickListener(v -> startActivity(easyGameIntent));
    }
}
