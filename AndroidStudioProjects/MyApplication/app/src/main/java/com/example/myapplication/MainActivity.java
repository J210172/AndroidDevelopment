package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean button1;
    private TextView tv;
    private int index;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView) findViewById(R.id.text1);
        button1 = false;
        index = 0;
        num = 1;
    }

    public void fun1(View view) {
        String text = tv.getText().toString();
        if (button1) {
            tv.setText(num > 1 ? "Hello World! x" + num : "Hello World!");
            button1 = false;
        } else {
            tv.setText(num > 1 ? "Goodbye World! x" + num : "Goodbye World!");
            button1 = true;
        }
    }

    public void fun2(View view) {
        int[] colores = {
                Color.parseColor("#000000"), Color.parseColor("#FF0000"),
                Color.parseColor("#00FF00"), Color.parseColor("#0000FF"),
                Color.parseColor("#FFFF00"), Color.parseColor("#FF00FF"),
                Color.parseColor("#00FFFF")
        };
        if (index < colores.length-1) {
            index++;
        } else {
            index = 0;
        }
        tv.setTextColor(colores[index]);
    }

    public void fun3(View view) {
        num++;
        if (!button1) {
            tv.setText(num > 1 ? "Hello World! x" + num : "Hello World!");
            button1 = false;
        } else {
            tv.setText(num > 1 ? "Goodbye World! x" + num : "Goodbye World!");
            button1 = true;
        }
    }

    public void fun4(View view) {
        num = 1;
        if (!button1) {
            tv.setText("Hello World!");
            button1 = false;
        } else {
            tv.setText("Goodbye World!");
            button1 = true;
        }
    }
}