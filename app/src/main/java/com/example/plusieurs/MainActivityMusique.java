package com.example.plusieurs;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivityMusique extends AppCompatActivity {

    private Button buttonPlay;
    private Button buttonStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_musique);

        this.buttonPlay = (Button) this.findViewById(R.id.button_play);
        this.buttonStop = (Button) this.findViewById(R.id.button_stop);

        this.buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
            }
        });

        this.buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSong();
            }
        });
    }

    public void playSong(){
        Intent myIntent = new Intent(MainActivityMusique.this, JouerMusique.class);
        this.startService(myIntent);
    }

    public void stopSong(){
        Intent myIntent = new Intent(MainActivityMusique.this, JouerMusique.class);
        this.stopService(myIntent);
    }

}