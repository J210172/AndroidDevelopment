package com.example.intentpru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, IntentActivity.class);

    }

    public void ToIntent(View view) {
        EditText et = (EditText) findViewById(R.id.TextInput);
        intent.putExtra("text", et.getText().toString());
        intent.putExtra("persona", new Persona("Pepe", 22));
        startActivity(intent);
    }

}