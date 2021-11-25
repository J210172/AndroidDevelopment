package com.example.examen1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemInteracion extends AppCompatActivity {

    private String dbname, tname, name;
    private int id;
    private TextView ETname;
    private EditText ETid;

    private SQLiteDatabase database;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_interaction);
        ETid = findViewById(R.id.ETid);
        ETname = findViewById(R.id.ETname);

        dbname = "CamposGolf";
        tname = "CamposGolf";

        Bundle b = getIntent().getExtras();
        if (!b.isEmpty()) {
            id = b.getInt("id");
            name = b.getString("name");
        }
        ETid.setText(String.valueOf(id));
        ETid.setInputType(0);
        ETid.setEnabled(false);
        ETid.setFocusable(false);
        ETname.setText(name);
        findViewById(R.id.updateButton).setOnClickListener(view -> update());
        findViewById(R.id.deleteButton).setOnClickListener(view -> delete());
        findViewById(R.id.exit).setOnClickListener(view -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();

        database = openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);

    }

    public void update() {
        int id = Integer.parseInt(ETname.getText().toString());
        String name = ETid.getText().toString().trim();
        if (!name.equals("")) {
            SQLiteStatement s =  database.compileStatement(String.format("UPDATE " + tname + " SET id = '%s' WHERE name = '%s';", name, id));
            int lineas = s.executeUpdateDelete();
            if (lineas <= 0) {
                Toast.makeText(this, String.format(getString(R.string.updateFailed), name, id), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, String.format(getString(R.string.updateDone), name, id), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.Err1), Toast.LENGTH_LONG).show();
        }
    }

    public void delete() {
        int id = Integer.parseInt(ETname.getText().toString());
        String name = ETid.getText().toString().trim();
        if (!name.equals("")) {
            Cursor c = database.rawQuery(String.format("SELECT * FROM " + tname + " WHERE id = '%s' AND name = '%s';", id, name), null);
            //hacerlo con db.query
            if (c.getCount() <= 0) {
                Toast.makeText(this, String.format(getString(R.string.deleteFailed), name, id), Toast.LENGTH_LONG).show();
            } else {
                String sentenciaSQL = String.format("DELETE FROM " + tname + " WHERE id = '%s' AND name = '%s'", ETname.getText(), ETid.getText());
                //hacerlo con db.insert
                database.execSQL(sentenciaSQL);

                Toast.makeText(this, String.format(getString(R.string.deleteDone), name, id), Toast.LENGTH_LONG).show();
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
