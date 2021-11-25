package com.example.examen1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activiti para borrar entradas de la db
 */
public class Borrar extends AppCompatActivity {

    private String dbname, tname;
    private EditText ETname, ETid;

    private SQLiteDatabase database;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        ETid = findViewById(R.id.ETid);
        ETname = findViewById(R.id.ETname);

        dbname = "CamposGolf";
        tname = "CamposGolf";

        findViewById(R.id.deleteButton).setOnClickListener(view -> delete());
        findViewById(R.id.exitButton).setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();

        database = openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);

    }

    public void delete() {
        String groupText = ETname.getText().toString().trim();
        String disksText = ETid.getText().toString().trim();
        if (!groupText.equals("") || !disksText.equals("")) {
            Cursor c = database.rawQuery(String.format("SELECT * FROM " + tname + " WHERE id = '%s' AND name = '%s';", groupText, disksText), null);
            //hacerlo con db.query
            if (c.getCount() <= 0) {
                Toast.makeText(this, String.format(getString(R.string.deleteFailed), disksText, groupText), Toast.LENGTH_LONG).show();
            } else {
                String sentenciaSQL = String.format("DELETE FROM " + tname + " WHERE id = '%s' AND name = '%s'", ETname.getText(), ETid.getText());
                //hacerlo con db.insert
                database.execSQL(sentenciaSQL);

                Toast.makeText(this, String.format(getString(R.string.deleteDone), disksText, groupText), Toast.LENGTH_LONG).show();
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
