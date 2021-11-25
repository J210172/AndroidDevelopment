package com.example.examen1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Database main activity
 */
public class MainDB extends AppCompatActivity {
    private SQLiteDatabase database;
    private String dbname, tname;
    private Intent intUpdate;
    private Menu menu;
    private List<Encapsulador> tempDatos;
    private RecyclerView myRecicler;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        intUpdate = new Intent(this, ItemInteracion.class);
        intUpdate.putExtra("dbname", dbname);
        intUpdate.putExtra("tname", tname);

        dbname = "CamposGolf";
        tname = "CamposGolf";

        tempDatos = new ArrayList<>();

        myRecicler = findViewById(R.id.recycler_view);

        myRecicler.setHasFixedSize(true);
        gestor = new LinearLayoutManager(this);
        myRecicler.setLayoutManager(gestor);
        adaptador = new Adaptador(tempDatos);
        myRecicler.setAdapter(adaptador);

        myRecicler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            final GestureDetector gestureDetector =
                    new GestureDetector(getApplicationContext(),
                            new GestureDetector.SimpleOnGestureListener() {
                                @Override
                                public boolean onSingleTapUp(MotionEvent event) {
                                    return true;
                                }
                            });
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View hijo = rv.findChildViewUnder(e.getX(), e.getY());
                if (hijo != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(hijo);
                    intUpdate.putExtra("id", tempDatos.get(position).getId());
                    intUpdate.putExtra("name", tempDatos.get(position).getName());
                    startActivity(intUpdate);
                    Toast.makeText(getApplicationContext(), String.valueOf(tempDatos.get(position).getId()), Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {}
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.add("Insertar Campo de Golf").setOnMenuItemClickListener(v -> {
            Intent intAdd = new Intent(this, Annadir.class);
            startActivity(intAdd);
            return true;
        });
        menu.add("verificar Identidad").setOnMenuItemClickListener(v -> {
            Intent intAdd = new Intent(this, Annadir.class);
            startActivity(intAdd);
            return true;
        });
        return true;
    }

    @Override
    protected void onResume() {
        database = openOrCreateDatabase(dbname, Context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS " + tname + "(id NUMBER, name VARCHAR);");
        actualizar();
        super.onResume();
    }

    private void actualizar() {
        tempDatos = new ArrayList<Encapsulador>();
        Cursor c = database.rawQuery("SELECT * FROM " + tname, null);

        //if (c.getCount() == 0) {
        //    tempDatos.add(new Encapsulador("SinRegistros", "No Hay Resgitros en la base de datos", R.drawable.ic_atom));
        // } else {
        while (c.moveToNext()) {
            tempDatos.add(new Encapsulador(c.getInt(0), c.getString(1)));
        }
        //}

        adaptador = new Adaptador(tempDatos);
        myRecicler.setAdapter(adaptador);
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
