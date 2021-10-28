package com.example.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        intent = getIntent();
    }

    public void onClick(View view) {
        Bundle b = intent.getExtras();
        if (b != null) {
            Intent intentico = new Intent();
            Bundle b2 = intentico.getExtras();
            int sum1 = (int) b.getInt("Sum1");
            int sum2 = (int) b.getInt("Sum2");
            int resultado = sum1 + sum2;
            intentico.putExtra("resultado", resultado);
            setResult(RESULT_OK, intentico);
            finish();
        }
    }
}
