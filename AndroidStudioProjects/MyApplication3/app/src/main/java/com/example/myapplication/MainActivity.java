package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> numeros;
    private boolean[] b;
    private TextView salida;
    private EditText entrada;

    protected void onCreate(Bundle savedInstanceState) {
        numeros = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida = (TextView) findViewById(R.id.textView);
        entrada = (EditText) findViewById(R.id.editTextNumber);

        b = new boolean[100000000];
        for (int i = 0; i < b.length; i++) {
            b[i] = true;
        }

        b[0] = false;
        b[1] = false;

        for (int i = 2; i < (int) Math.sqrt(b.length); i++) {
            if (b[i]) {
                for (int j = i * i; j < b.length; j = j + i) {
                    b[j] = false;
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                numeros.add(i);
            }
        }
    }

    public void getPrimeOnPos(View view) {
        String num = entrada.getText().toString();
        int x;
        if (!num.equals("")) {
            x = Integer.parseInt(num)-1;
            x = numeros.get(x);
            System.out.println(String.valueOf(x));
            salida.setText(String.valueOf(x));
        }
    }
}