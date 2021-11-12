package com.example.ejercicio8_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Annadir extends AppCompatActivity {

    private EditText ETGroup, ETDisks;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ETDisks = findViewById(R.id.ETDiscos);
        ETGroup = findViewById(R.id.ETGroup);
        findViewById(R.id.addButton).setOnClickListener(view -> annadir());
        findViewById(R.id.exit).setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();

        db = openOrCreateDatabase("MisDiscos", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MisDiscos(Grupo VARCHAR, Disco VARCHAR);");

    }

    public void annadir() {
        String groupText = ETGroup.getText().toString().trim();
        String disksText = ETDisks.getText().toString().trim();
        if (!groupText.equals("") && !disksText.equals("")) {
            Cursor c = db.rawQuery(String.format("SELECT * FROM MisDiscos WHERE Grupo = \"%s\" AND Disco = \"%s\";", groupText, disksText), null);
            if (c.getCount() == 0) {
                String sentenciaSQL = String.format("INSERT INTO MisDiscos VALUES ('%s','%s')", ETGroup.getText(), ETDisks.getText());
                db.execSQL(sentenciaSQL);

                Toast.makeText(this, String.format("Se añadió el disco: %s del grupo: %s ", disksText, groupText), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format("El disco: %s del grupo: %s ya existe ", disksText, groupText), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No se permiten campos en blanco", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void finish() {
        super.finish();
    }
}
