package com.example.plusieurs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.media.MediaPlayer;

public class JouerMusique extends Service {

private MediaPlayer mediaPlayer;

    public JouerMusique() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ziakmp);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        mediaPlayer.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        mediaPlayer.release();
        super.onDestroy();
    }

}