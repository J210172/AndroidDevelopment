package com.example.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("milog", "asd");
        recorrer();
    }

    public void recorrer(){
        View v;
        LinearLayout l = (LinearLayout) findViewById(R.id.layout1);
        Button b;
        TextView t;
        for(int i =0; i <l.getChildCount(); i++)
        {
            v = l.getChildAt(i);
            if (v.getClass().getSimpleName().equals("MaterialButton")) {
                Log.d("milog", "objeto: "+ v.toString() + "\nEs un boton");
                b = (Button) v;
                b.setText("boton" + i);
                b.setOnClickListener(this::anadeHijos);
            } else if (v.getClass().getSimpleName().equals("MaterialTextView")){
                Log.d("milog", "objeto: "+ v.toString() + "\nEs un textview");
                t = (TextView) v;
                t.setText("boton" + i);
            }
        }
    }

    public void anadeHijos(View view)
    {
        LinearLayout l = (LinearLayout) findViewById(R.id.layout1);
        Button b;
        for (int i =0; i<2;i++)
        {
            b=new Button (this);
            b.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setText("btn" + i);
            b.setId(View.generateViewId());
            l.addView(b,i);
        }
    }

    public void esboton() {

    }

}