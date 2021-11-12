package com.example.ejercicio8_sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {
    private String dbname, tname;;

    private Intent iActualizar;

    private SQLiteDatabase db;
    private List<Encapsulador> tempDatos;

    private RecyclerView myRecicler;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle b = getIntent().getExtras();
        if (!b.isEmpty()) {
            dbname = b.getString("dbname");
            tname = b.getString("tname");
        }

        iActualizar = new Intent(this, Actualizar.class);
        iActualizar.putExtra("dbname", dbname);
        iActualizar.putExtra("tname", tname);

        tempDatos = new ArrayList<>();

        myRecicler = findViewById(R.id.recycler);

        myRecicler.setHasFixedSize(true);
        gestor = new LinearLayoutManager(this);
        myRecicler.setLayoutManager(gestor);
        adaptador = new Adaptador(tempDatos);
        myRecicler.setAdapter(adaptador);

        myRecicler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector  = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent event){
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View hijo = rv.findChildViewUnder(e.getX(), e.getY());

                if (hijo != null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(hijo);
                    iActualizar.putExtra("grupo", tempDatos.get(position).getGroup());
                    iActualizar.putExtra("disco", tempDatos.get(position).getDisk());
                    startActivity(iActualizar);
                    Toast.makeText(getApplicationContext(), tempDatos.get(position).getGroup(), Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            }
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });

    }
    @Override
    protected void onResume() {
        db = openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tname + "(Grupo VARCHAR, Disco VARCHAR);");
        actualizar();
        super.onResume();
    }

    private void actualizar() {
        tempDatos = new ArrayList<Encapsulador>();
        Cursor c = db.rawQuery("SELECT * FROM " + tname, null);

        //if (c.getCount() == 0) {
        //    tempDatos.add(new Encapsulador("SinRegistros", "No Hay Resgitros en la base de datos", R.drawable.ic_atom));
        // } else {
            while (c.moveToNext()) {
                tempDatos.add(new Encapsulador(c.getString(0), c.getString(1), R.drawable.ic_vlc));
            }
        //}

        adaptador = new Adaptador(tempDatos);
        myRecicler.setAdapter(adaptador);
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
