package com.example.p1recurdar;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p1recurdar.iRecycler.Item;
import com.example.p1recurdar.rRecycler.Adapter;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ItemEditor extends AppCompatActivity {
    private File item;
    private List<File> resList;
    private RecyclerView reciclador;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;

    private EditText title, description;
    private String imgName, vidName, audioName, location;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item_activity);

        title = findViewById(R.id.item_title);
        description = findViewById(R.id.item_description);

        resList = new ArrayList<>();

        reciclador = findViewById(R.id.res_list);

        resList.add(new File("pru","pru"));

        reciclador.setHasFixedSize(true);

        gestor = new LinearLayoutManager(this);
        reciclador.setLayoutManager(gestor);
        List<File> datos;
        adaptador = new Adapter(resList);
        reciclador.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        menu.add("Guardar").setOnMenuItemClickListener(this::guardar);
        menu.add("Añadir imagen").setOnMenuItemClickListener(v -> {
            Toast.makeText(this, "op2", Toast.LENGTH_LONG).show();
            return true;
        });
        menu.add("Añadir video").setOnMenuItemClickListener(v -> {
            Toast.makeText(this, "op3", Toast.LENGTH_LONG).show();
            return true;
        });
        menu.add("Añadir audio").setOnMenuItemClickListener(v -> {

            return true;
        });
        menu.add("Añadir localizacion").setOnMenuItemClickListener(v -> {
            Toast.makeText(this, "op3", Toast.LENGTH_LONG).show();
            return true;
        });

        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private boolean guardar(MenuItem menuItem) {
        Item item = new Item(title.getText().toString(),description.getText().toString());
        item.setAudio(audioName);
        item.setImage(imgName);
        item.setVideo(vidName);
        item.setLocation(location);

        try {
            saveItemToJson(item);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private void saveItemToJson(Item item) throws IOException {
        Gson gson = new Gson();
        File file = new File(this.getApplicationInfo().dataDir, item.getTitle());
        String object = gson.toJson(item);

        Log.d("ffff", "saveItemToJson: " + file.getAbsolutePath() + file.getName());
        if (!file.exists()) {
            file.createNewFile();
        }
        Log.d("ffffs", "savedItemToJson: " + file.getAbsolutePath() + file.getName());
        PrintWriter pw = new PrintWriter(file);
        for (String s : object.split("\n")) {
            pw.write(s);
        }
    }
}
