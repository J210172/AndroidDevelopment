package com.example.datepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    DatePickerDialog d;
    TimePickerDialog t;
    Calendar date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d = new DatePickerDialog(this);
        date = Calendar.getInstance();
        t = new TimePickerDialog(this, this::selectTime, date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE),  true);
        findViewById(R.id.Fecha).setOnClickListener(this::selectDate);
        findViewById(R.id.Tiempo).setOnClickListener(this::selectTime);
        d.setOnDateSetListener(this::dateSet);
    }

    private void selectTime(TimePicker timePicker, int min, int hour) {
        EditText e = findViewById(R.id.Tiempo);
        date.set(Calendar.MINUTE, min);
        date.set(Calendar.HOUR, hour);
        e.setText(hour+":"+min);
    }


    private void selectTime(View view) {
        t.show();
    }

    private void dateSet(DatePicker datePicker, int i, int i1, int i2) {
        EditText e = findViewById(R.id.Fecha);
        date.set(i, i1, i2);
        e.setText(String.format("%tF", date.getTime()));
    }

    private void selectDate(View view) {
        d.show();
    }

}