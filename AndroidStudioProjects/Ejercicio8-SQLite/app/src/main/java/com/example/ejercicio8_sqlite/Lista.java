package com.example.ejercicio8_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {
    private SQLiteDatabase db;
    private List<Encapsulador> tempDatos;

    private RecyclerView myRecicler;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        tempDatos = new ArrayList<>();

        myRecicler = findViewById(R.id.recycler);

        myRecicler.setHasFixedSize(true);
        gestor = new LinearLayoutManager(this);
        myRecicler.setLayoutManager(gestor);
        adaptador = new Adaptador(tempDatos);
        myRecicler.setAdapter(adaptador);


        db = openOrCreateDatabase("MisDiscos", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MisDiscos(Grupo VARCHAR, Disco VARCHAR);");

        actualizar();
    }

    private void actualizar() {
        tempDatos = new ArrayList<Encapsulador>();
        Cursor c = db.rawQuery("SELECT * FROM MisDiscos", null);

        if (c.getCount() == 0) {
            tempDatos.add(new Encapsulador("SinRegistros", "No Hay Resgitros en la base de datos", R.drawable.ic_atom));
        } else {
            while (c.moveToNext()) {
                tempDatos.add(new Encapsulador(c.getString(0), c.getString(1), R.drawable.ic_vlc));
            }
        }

        adaptador = new Adaptador(tempDatos);
        myRecicler.setAdapter(adaptador);

        c.close();
    }


    @Override
    public void finish() {
        super.finish();
    }
}
