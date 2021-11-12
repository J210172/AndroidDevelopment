package com.example.ejercicio8_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent iLista, iAnnadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iLista = new Intent(this, Lista.class);
        iAnnadir = new Intent(this, Annadir.class);
        findViewById(R.id.lista).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iLista);
            }
        });
        findViewById(R.id.annadir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iAnnadir);
            }
        });
    }

}