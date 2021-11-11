package com.example.listasqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText ETGroup, ETDisks;

    private SQLiteDatabase db;
    private List<Encapsulador> tempDatos;

    private RecyclerView myRecicler;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempDatos = new ArrayList<>();

        myRecicler = findViewById(R.id.RecycleView1);

        tempDatos.add(new Encapsulador("prueGrupo", "prueDisco"));

        myRecicler.setHasFixedSize(true);
        gestor = new LinearLayoutManager(this);
        myRecicler.setLayoutManager(gestor);
        adaptador = new Adaptador(tempDatos);
        myRecicler.setAdapter(adaptador);

        ETGroup = findViewById(R.id.ETGroup);
        ETDisks = findViewById(R.id.ETDiscos);
        myRecicler = findViewById(R.id.RecycleView1);

        db = openOrCreateDatabase("MisDiscos", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MisDiscos(Grupo VARCHAR, Disco VARCHAR);");

        actualizar();
    }

    private void actualizar() {
        tempDatos = new ArrayList<Encapsulador>();
        Cursor c = db.rawQuery("SELECT * FROM MisDiscos", null);

        if (c.getCount() == 0) {
            tempDatos.add(new Encapsulador("SinRegistros", "No Hay Resgitros en la base de datos"));
        } else {
            while (c.moveToNext()) {
                tempDatos.add(new Encapsulador(c.getString(0), c.getString(1)));
            }

        }
        adaptador = new Adaptador(tempDatos);
        myRecicler.setAdapter(adaptador);

        c.close();

    }

    public void annadir(View view) {

        String groupText = ETGroup.getText().toString().trim();
        String disksText = ETDisks.getText().toString().trim();
        if (!groupText.equals("")) {

        }
        String sentenciaSQL = String.format("INSERT INTO MisDiscos VALUES ('%s','%s')", ETGroup.getText(), ETDisks.getText());
        db.execSQL(sentenciaSQL);

        Toast.makeText(this, "Se añadió el disco " + ETDisks.getText().toString(), Toast.LENGTH_LONG).show();

        actualizar();
    }

    public void eliminar(View view) {
        String sentenciaSQL = String.format("DELETE FROM MisDiscos WHERE grupo == '%s' AND disco == '%s'", ETGroup.getText(), ETDisks.getText());
        db.execSQL(sentenciaSQL);
        if (!db.inTransaction()) {
            String table = "";
            String whereClause = "";
            String whereArgs[] = {""};
            db.delete(table,whereClause,whereArgs);

        }

        Toast.makeText(this, "Se elimino el disco " + ETDisks.getText().toString(), Toast.LENGTH_LONG).show();


        actualizar();
    }


}