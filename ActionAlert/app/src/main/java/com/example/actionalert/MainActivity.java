package com.example.actionalert;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Button1).setOnClickListener(this::showHowToPlay);
        findViewById(R.id.Button2).setOnClickListener(this::showMenu);
        findViewById(R.id.Button3).setOnClickListener(this::showMultiChoice);
        findViewById(R.id.Button4).setOnClickListener(v -> new DatePickerDialog(this).show());
    }

    public void showMenu(View view) {
        String[] options = new String[]{"Easy", "Normal", "Hard"};
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setNegativeButton("Cancelar", (DialogInterface dialogInterface, int i) -> {
        });
        alert.setPositiveButton("Acepta", (DialogInterface dialogInterface, int i) -> {
        });

        alert.setTitle("Select Dificulty");
        alert.setSingleChoiceItems(options, 0, (DialogInterface dialogInterface, int i) -> {
            switch (i) {
                case 0:
                    Toast.makeText(getApplicationContext(), "Easy selected", Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "Normal selected", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(), "Hard selected", Toast.LENGTH_LONG).show();
                    break;
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }


    public void showHowToPlay(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setNeutralButton("Ok", (DialogInterface dialogInterface, int i) -> {
        });
        alert.setTitle("How to play");
        alert.setMessage("CONDICIÓN DE VICTORIA: El usuario gana cuando ha ocurrido la situación 2 y ha marcado correctamente todas las hipotenochas.\n" +
                "CONDICIÓN DE DERROTA: El usuario pierde cuando ha ocurrido la situación 1 o la situación 3.\n");
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void showMultiChoice(View view) {

        String options[] = new String[]{"Easy", "Normal", "Hard"};
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setNeutralButton("Ok", (DialogInterface dialogInterface, int i) -> {
        });
        alert.setTitle("How to play");
        alert.setMultiChoiceItems(options, null , (dialog, which, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, options[which], Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, options[which], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void showDatePicker(View view) {
        String options[] = new String[]{"Easy", "Normal", "Hard"};
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setNeutralButton("Ok", (DialogInterface dialogInterface, int i) -> {
        });
        alert.setTitle("How to play");
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}