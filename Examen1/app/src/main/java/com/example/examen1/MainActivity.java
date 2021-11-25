package com.example.examen1;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Clase Principal
 * @author Jaime Izquierdo Plaza
 */
public class MainActivity extends AppCompatActivity {
    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;
    private boolean isConnected;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();

        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

        findViewById(R.id.use_database).setOnClickListener(this::useDatabase);
        findViewById(R.id.use_web).setOnClickListener(this::useWeb);

    }

    /**
     * Accion onclick del boton use_web
     * @param view
     */
    private void useWeb(View view) {
        if (isConnected) {

        } else {
            Toast.makeText(this, R.string.NoInternetErr1, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Accion onclick del boton use_database
     * @param view
     */
    private void useDatabase(View view) {
        startActivity(new Intent(this, MainDB.class));
    }
}