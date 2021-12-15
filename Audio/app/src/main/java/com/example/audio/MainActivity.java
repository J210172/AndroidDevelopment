package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SoundPool soundPool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(6)
                .setAudioAttributes(audioAttributes)
                .build();
        int s1 = soundPool.load(this, R.raw.sound1, 1);
        findViewById(R.id.Sonido1).setOnClickListener(v -> soundPool.play(s1 , 1, 1, 0, 0, 1));
        findViewById(R.id.Sonido2).setOnClickListener(v -> soundPool.play(soundPool.load(this, R.raw.sound1, 1), 1, 1, 0, 0, 1));
    }
}