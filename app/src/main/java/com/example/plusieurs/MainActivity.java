package com.example.plusieurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonMusique, Chrono, Google, buttonScroll, buttonMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMusique = findViewById(R.id.button4);
        Chrono = findViewById(R.id.button);
        Google = findViewById(R.id.button3);
        buttonScroll = findViewById(R.id.button2);
        buttonMap = findViewById(R.id.button5);

        buttonMusique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivityMusique.class);
                startActivity(i);
            }
        });

        Chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityChrono.class);
                startActivity(i);
            }
        });

        Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.fr"));
                startActivity(i);
            }
        });

        buttonScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GallerieView.class);
                startActivity(i);
            }
        });

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/d/u/0/edit?mid=18eODtYmywHW_KSL2HNaBj1_M5qQZJVA&usp=sharing"));
                startActivity(i);
            }
        });

    }
}