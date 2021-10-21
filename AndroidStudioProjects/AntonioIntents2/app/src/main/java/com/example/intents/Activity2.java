package com.example.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class Activity2 extends AppCompatActivity{

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity2);

            listener2();

            Intent intent = getIntent();
            Bundle b = intent.getExtras();
            if (b!=null) {

                String str = (String) b.getString("palabra");
                int num = (int) b.getInt("numero");
                Persona per = (Persona) getIntent().getSerializableExtra("persona");

                Log.d("Datos",str);
                Log.d("Datos", String.valueOf(num));
                Log.d("Datos", per.toString());

            }

        }

        public void listener2(){

            Button b = findViewById(R.id.BotonCambio);
            b.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {

                    if (b!=null) {

                        Intent intentico = new Intent(view.getContext(), MainActivity.class);
                        Bundle b = intentico.getExtras();
                        int sum1 = (int) b.getInt("Sum1");
                        int sum2 = (int) b.getInt("Sum2");
                        int resultado = sum1 + sum2;
                        intentico.putExtra("resultado",resultado);
                        setResult(RESULT_OK, intentico);
                        finish();

                    }

                }

            });

        }

    }
