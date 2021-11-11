package com.example.ejercicio8_sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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

    }


    @Override
    public void finish() {
        super.finish();
    }
}
