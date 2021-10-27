package com.example.intents;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> arl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arl =
                registerForActivityResult( new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if (result.getResultCode() == Activity.RESULT_OK) {

                                    Intent datos = result.getData();
                                    Bundle b = datos.getExtras();
                                    int res = 0;
                                    if (b != null) {
                                        res = (int) b.getInt("resultado");
                                    }
                                    Log.d("Resultado", String.valueOf(res));

                                }
                            }
                        }
                );
    }


    public void onClick(View view) {


        Intent cambio = new Intent(view.getContext(), Activity2.class);

        cambio.putExtra("palabra", "Loquesea");
        cambio.putExtra("numero", 85);

        Persona p = new Persona("Juan", 23, 22222);
        cambio.putExtra("persona", p);

        cambio.putExtra("Sum1", 20);
        cambio.putExtra("Sum2", 32);

        arl.launch(cambio);


    }
}

