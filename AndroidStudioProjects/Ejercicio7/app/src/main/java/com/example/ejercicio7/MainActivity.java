package com.example.ejercicio7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @see <a href="https://classroom.google.com/u/0/c/MzQ0Njg1NDg4OTUy/a/NDEzMjE2NTM1NTU0/details?hl=es">Ir a la tarea</a>
 * El ejercicio consiste en crear un menú de opciones desde el Java y que la aplicación lo muestre
 * @author jaime
 * @version 1
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Se le llama en el tiempo de carga de la aplicacion antes de la parte visual
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Creacion del menu de opciones
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        SubMenu subMenu1 = menu.addSubMenu(R.string.ajustes);
        subMenu1.add(R.string.ajuste1);
        subMenu1.add(R.string.ajuste2);
        menu.add(R.string.informacion);
        return true;
    }
}