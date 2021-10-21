package com.example.intentpru;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IntentActivity extends Activity{
    private TextView tv1, tv2, tv3;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);
        tv1 = (TextView) findViewById(R.id.textField);
        tv2 = (TextView) findViewById(R.id.personaNameField);
        tv3 = (TextView) findViewById(R.id.personaAgeField);
        intent = getIntent();
        Bundle b = intent.getExtras();
        String s = null;
        Persona p = null;
        if (b!=null) {
            s = (String) b.getString("text");
            p = (Persona) b.getSerializable("persona");
        }
        tv1.setText(s);
        tv2.setText(p.getName());
        tv3.setText(String.valueOf(p.getAge()));
    }

    public void ToMain(View view) {
        this.finish();
    }

}
