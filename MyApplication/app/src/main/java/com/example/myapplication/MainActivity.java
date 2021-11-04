package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsuariosSQLiteHelper usuariosBBDD = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usuariosBBDD.getWritableDatabase();

        db.execSQL(String.format("INSERT INTO Usuarios (codigo, nombre) VALUES (%d, '%s')"));

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("codigo", "valor1");
        nuevoRegistro.put("nombre", "valor2");
        db.insert("Usuarios", null, nuevoRegistro);

    }
}