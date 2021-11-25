package com.example.examen1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Annadir extends AppCompatActivity {

    private String dbname, tname;
    private EditText ETid, ETname;

    private SQLiteDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ETname = findViewById(R.id.ETid);
        ETid = findViewById(R.id.ETname);

        dbname = "CamposGolf";
        tname = "CamposGolf";

        findViewById(R.id.addButton).setOnClickListener(view -> annadir());
        findViewById(R.id.exit).setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();

        database = openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);

    }

    public void annadir() {
        int id = Integer.valueOf(ETname.getText().toString());
        String name = ETid.getText().toString().trim();
        if (!name.equals("")) {
            Cursor c = database.rawQuery(String.format("SELECT * FROM " + tname + " WHERE id = '%s' AND name = '%s';", id, name), null);
            //hacerlo con db.query
            if (c.getCount() == 0) {
                String sentenciaSQL = String.format("INSERT INTO " + tname + " VALUES (%d,'%s')", Integer.valueOf(ETid.getText().toString()), ETname.getText());
                //hacerlo con db.insert
                database.execSQL(sentenciaSQL);

                Toast.makeText(this, String.format(getString(R.string.addDone), name, id), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.addFailed), name, id), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.Err1), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        database.close();
        super.onPause();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
