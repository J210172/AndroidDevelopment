package com.example.json_ej;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    HttpURLConnection hURLc;
    String sResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BufferedReader reader;
        String line;
        StringBuilder result;
        try {
            hURLc = setUpURLConnection("http://servidor.es/persistencia");
            if (hURLc != null) {
                hURLc.setRequestMethod("GET");
                Log.d("lecato", " " + sResult);
                reader = new BufferedReader(new InputStreamReader(hURLc.getInputStream()));
                result = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                sResult = result.toString();
            } else {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("lecato", " " + sResult);

    }

    private HttpURLConnection setUpURLConnection(String sURL) throws IOException {
        URL url = new URL(sURL);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        if (urlConnection.getResponseCode() == 200)
            return urlConnection;
        else {
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(5000);
            return null;
        }
    }
}