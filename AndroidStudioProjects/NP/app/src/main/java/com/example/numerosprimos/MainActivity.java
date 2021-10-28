package com.example.numerosprimos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> primesList;
    private Button calcularB;
    private EditText entrada;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        calcularB = (Button) findViewById(R.id.calcularButton);
        entrada = (EditText) findViewById(R.id.inputPositionN);
        salida = (TextView) findViewById(R.id.outputTV);
        primesList = new ArrayList<>();
    }

    private static boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        int step = 4, m = (int)Math.sqrt(n) + 1;
        for(int i = 5; i < m; step = 6-step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void calcular(View view) {
        int posicion, i = 1, nPrimo;
        if (!entrada.getText().toString().equals("")) {
            posicion = Integer.parseInt(entrada.getText().toString());

            if (posicion > 0) {
                i = (primesList.size() == 0)?1:primesList.get(primesList.size() - 1);
                while (posicion > primesList.size()) {
                    if(isPrime(++i)){
                        primesList.add(i);
                    }
                }
                nPrimo = primesList.get(posicion-1);
                Log.d("PrimeNumber", String.valueOf(nPrimo));
                salida.setText(String.format(getString(R.string.resultado), posicion, nPrimo));
            } else {
                salida.setText("La posicion tiene que empezar en 0");
            }
        }
    }
}