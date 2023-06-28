package com.example.plusieurs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.os.Bundle;
import java.util.Locale;

import android.widget.Button;
import android.widget.TextView;

public class ActivityChrono extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    Button Start, Pause, Reset;
    TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);

        Start = findViewById(R.id.start_button);
        Pause = findViewById(R.id.stop_button);
        Reset = findViewById(R.id.reset_button);
        timeView = findViewById(R.id.time_view);

        runTimer();

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (running = false){

                    onResume();
                }
                else {
                    running = true;
                }
            }
        });

        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStop();
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickReset();
            }
        });


    }

    @Override
    public void onSaveInstanceState(
            Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    public void onClickStop()
    {
        running = false;
    }

    public void onClickReset(){
        running = false;
        seconds = 0;
    }

    private void runTimer()
    {


        final TextView timeView
                = (TextView)findViewById(
                R.id.time_view);


        final Handler handler
                = new Handler();


        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                timeView.setText(time);


                if (running) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);

            }
        });
    }
}