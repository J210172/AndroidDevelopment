package com.example.listasqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText ETGroup, ETDiscos;

    private SQLiteDatabase db;
    private List<Encapsulador> tempDatos;

    private RecyclerView reciclador;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempDatos = new ArrayList<>();

        reciclador = (RecyclerView) findViewById(R.id.RecycleView1);

        tempDatos.add(new Encapsulador("prueGrupo", "prueDisco"));

        reciclador.setHasFixedSize(true);
        gestor = new LinearLayoutManager(this);
        reciclador.setLayoutManager(gestor);
        adaptador = new Adaptador(tempDatos);
        reciclador.setAdapter(adaptador);

        ETGroup = (EditText) findViewById(R.id.ETGroup);
        ETDiscos = (EditText) findViewById(R.id.ETDiscos);
        reciclador = (RecyclerView) findViewById(R.id.RecycleView1);

        db = openOrCreateDatabase("MisDiscos", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MisDiscos(Grupo VARCHAR, Disco VARCHAR);");

        actualizar();
    }

    private void actualizar() {
        tempDatos = new ArrayList<Encapsulador>();
        Cursor c = db.rawQuery("SELECT * FROM MisDiscos", null);

        if (c.getCount() == 0 )
        {
            tempDatos.add(new Encapsulador("SinRegistros", "No Hay Resgitros en la base de datos"));
        }
        else
        {
            while(c.moveToNext())
            {
                tempDatos.add(new Encapsulador(c.getString(0), c.getString(1)));
            }

        }
        adaptador = new Adaptador(tempDatos);
        reciclador.setAdapter(adaptador);

        c.close();

    }

    public void annadir(View view) {
        String sentenciaSQL = String.format("INSERT INTO MisDiscos VALUES ('%s','%s')", ETGroup.getText(), ETDiscos.getText());
        db.execSQL(sentenciaSQL);

        Toast.makeText(this, "Se añadió el disco " + ETDiscos.getText().toString(), Toast.LENGTH_LONG).show();

        actualizar();
    }


}