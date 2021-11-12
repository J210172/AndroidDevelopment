package com.example.ejercicio8_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Borrar extends AppCompatActivity {

    private String dbname, tname;
    private EditText ETGroup, ETDisks;

    private SQLiteDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        ETDisks = findViewById(R.id.ETDiscos);
        ETGroup = findViewById(R.id.ETGroup);

        Bundle b = getIntent().getExtras();
        if (!b.isEmpty()) {
            dbname = b.getString("dbname");
            tname = b.getString("tname");
        }

        findViewById(R.id.deleteButton).setOnClickListener(view -> delete());
        findViewById(R.id.exitButton).setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();

        db = openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tname + "(Grupo VARCHAR, Disco VARCHAR);");

    }

    public void delete() {
        String groupText = ETGroup.getText().toString().trim();
        String disksText = ETDisks.getText().toString().trim();
        if (!groupText.equals("") || !disksText.equals("")) {
            Cursor c = db.rawQuery(String.format("SELECT * FROM " + tname + " WHERE Grupo = '%s' AND Disco = '%s';", groupText, disksText), null);
            //hacerlo con db.query
            if (c.getCount() <= 0) {
                Toast.makeText(this, String.format(getString(R.string.deleteFailed), disksText, groupText), Toast.LENGTH_LONG).show();
            } else {
                String sentenciaSQL = String.format("DELETE FROM " + tname + " WHERE Grupo = '%s' AND Disco = '%s'", ETGroup.getText(), ETDisks.getText());
                //hacerlo con db.insert
                db.execSQL(sentenciaSQL);

                Toast.makeText(this, String.format(getString(R.string.deleteDone), disksText, groupText), Toast.LENGTH_LONG).show();
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
