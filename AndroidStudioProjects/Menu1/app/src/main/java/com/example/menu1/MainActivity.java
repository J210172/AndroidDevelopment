package com.example.menu1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.logging.ConsoleHandler;

public class MainActivity extends AppCompatActivity {
    private TextView starks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starks = (TextView) findViewById(R.id.textview1);
        registerForContextMenu(starks);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.op1:
                Toast.makeText(getApplicationContext(), "Opcion 1", Toast.LENGTH_LONG).show();
                return true;
            case R.id.op2:
                Toast.makeText(getApplicationContext(), "Opcion 2", Toast.LENGTH_LONG).show();
                return true;
            case R.id.op3:
                Toast.makeText(getApplicationContext(), "Opcion 3", Toast.LENGTH_LONG).show();
                return true;
            case R.id.op4:
                Toast.makeText(getApplicationContext(), "Opcion 4", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sanar:
                Toast.makeText(getApplicationContext(), "Curado", Toast.LENGTH_LONG).show();
                return true;
            case R.id.matar:
                Toast.makeText(getApplicationContext(), "Matado", Toast.LENGTH_LONG).show();
                return true;
            case R.id.enviarmensaje:
                Toast.makeText(getApplicationContext(), "Enviado", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}