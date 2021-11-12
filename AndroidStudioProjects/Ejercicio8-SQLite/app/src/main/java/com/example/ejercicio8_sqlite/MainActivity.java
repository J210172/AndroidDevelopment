package com.example.ejercicio8_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;

/**
 * clase pirncipal
 */
public class MainActivity extends AppCompatActivity {

    private Intent iLista, iAnnadir, iBorrar;
    private String dbname, tname;

    /**
     * on create de la Clase principal
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbname = "MisDiscos";
        tname = "Discos";
        iLista = new Intent(this, Lista.class);
        iLista.putExtra("dbname", dbname);
        iLista.putExtra("tname", tname);
        iAnnadir = new Intent(this, Annadir.class);
        iAnnadir.putExtra("dbname", dbname);
        iAnnadir.putExtra("tname", tname);
        iBorrar = new Intent(this, Borrar.class);
        iBorrar.putExtra("dbname", dbname);
        iBorrar.putExtra("tname", tname);
        findViewById(R.id.lista).setOnClickListener(v -> startActivity(iLista));
        findViewById(R.id.annadir).setOnClickListener(v -> startActivity(iAnnadir));
        findViewById(R.id.borrar).setOnClickListener(v -> startActivity(iBorrar));
    }
}