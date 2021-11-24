package com.example.hipotenochas;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {
    private TableLayout tl;
    private ImageButton prueba;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        tl = findViewById(R.id.gameTable);
        tl.setGravity(Gravity.CENTER);
        int y = 14, x = 9;
        for (int i = 0; i < y; i++) {
            TableRow tr = new TableRow(tl.getContext());
            tr.setGravity(Gravity.CENTER);
            tl.addView(tr);
            for (int j = 0; j < x; j++) {
                ImageButton ib = new ImageButton(tl.getContext());
                ib.setAdjustViewBounds(true);
                ib.setMaxWidth(1050 / x);
                ib.setId(j+x*i);
                ib.setPadding(3,3,3,3);
                ib.setImageResource(R.drawable.facing_down);
                ib.setOnClickListener(v -> ib.setImageResource(R.drawable.num0));
                tr.addView(ib);
            }
        }

    }


}
