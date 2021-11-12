package com.example.ejercicio8_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Actualizar extends AppCompatActivity {

    private String dbname, tname, grupo, disco;
    private TextView ETGroup;
    private EditText ETDisks;

    private SQLiteDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ETDisks = findViewById(R.id.ETDiscos);
        ETGroup = findViewById(R.id.ETGroup);

        Bundle b = getIntent().getExtras();
        if (!b.isEmpty()) {
            dbname = b.getString("dbname");
            tname = b.getString("tname");
            grupo = b.getString("grupo");
            disco = b.getString("disco");
        }
        ETGroup.setText(grupo);
        ETDisks.setText(disco);
        findViewById(R.id.updateButton).setOnClickListener(view -> update());
        findViewById(R.id.exit).setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();

        db = openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tname + "(Grupo VARCHAR, Disco VARCHAR);");

    }

    public void update() {
        String groupText = ETGroup.getText().toString().trim();
        String disksText = ETDisks.getText().toString().trim();
        if (!groupText.equals("") || !disksText.equals("")) {
            SQLiteStatement s =  db.compileStatement(String.format("UPDATE " + tname + " SET Disco = '%s' WHERE Grupo = '%s';", disksText, groupText));
            int lineas = s.executeUpdateDelete();
            if (lineas <= 0) {
                Toast.makeText(this, String.format(getString(R.string.updateFailed), disksText, groupText), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.updateDone), disksText, groupText), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.Err1), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        db.close();
        super.onPause();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
