package com.example.p1recurdar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Printer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.p1recurdar.iRecycler.Item;
import com.example.p1recurdar.rRecycler.Adapter;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText ETGroup, ETDisks;

    private List<Item> itemList;

    private RecyclerView myRecicler;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        itemList = new ArrayList<>();

        myRecicler =
        adaptador = new Adapter(resList);
        myRecicler.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        menu.add("Añadir Recoradatorio").setOnMenuItemClickListener(v -> {
            Intent in = new Intent(this, ItemEditor.class);
            startActivity(in);
            Toast.makeText(this, "op1", Toast.LENGTH_LONG).show();
            return true;
        });
        menu.add("Actualizar").setOnMenuItemClickListener(v -> {
            Toast.makeText(this, "op2", Toast.LENGTH_LONG).show();
            return true;
        });

        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void update(View view) {
        try {
            updateItemList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myRecicler
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void updateItemList() throws IOException {
        // Listado y filtrado de archivos
        File listOfFiles = Environment.getStorageDirectory();
        File[] jsonFiles = listOfFiles.listFiles(file -> {
            String fn = file.getName();
            String fileExtension = fn.substring(fn.lastIndexOf(".") + 1);
            if (fileExtension.equals("json")) {
                Log.d("Update in process: ", "file name: " + fn);
                return true;
            }
            return false;
        });

        // Lectura de archivos
        FileInputStream fis;

        for (File f : jsonFiles) {
            Gson g = new Gson();
            fis = new FileInputStream(f);
            String jsonString = "";
            int temp;
            while ((temp = fis.read()) <= -1) {
                jsonString += (char) temp;
            }
            itemList.add(g.fromJson(jsonString, Item.class));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void saveItemToJson(Item item) throws IOException {
        Gson gson = new Gson();
        File file = new File(this.getApplicationInfo().dataDir, item.getTitle());
        String object = gson.toJson(item);

        if (!file.exists()) {
            file.createNewFile();
        }
        Log.d("TAG", "saveItemToJson: " + file.getAbsolutePath() + file.getName());
        PrintWriter pw = new PrintWriter(file);
    }

}