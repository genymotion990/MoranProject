package com.example.hp1.cit2radio;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Hp1 on 02/10/2017.
 */

public class StreamService extends Service{
    private static final String TAG = "Buffering";
    String url;
    MediaPlayer mp;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Buffering....", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");

        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Stream stopped.", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");

        mp.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {

        Log.d(TAG, "onStart");

        url = intent.getExtras().getString("url");
        try {
            if(!mp.isPlaying()) {
                Toast.makeText(this, "Buffering...", Toast.LENGTH_LONG).show();
                mp.setVolume(1.0f,1.0f);
                mp.setDataSource(url);
                mp.prepare();
                Toast.makeText(this, "Stream started", Toast.LENGTH_LONG).show();
                mp.start();
            }else{
               mp.stop();
                Toast.makeText(this, "Stream stopped", Toast.LENGTH_LONG).show();
            }
        } catch(Exception e){

        }
        return START_STICKY;
    }
}
