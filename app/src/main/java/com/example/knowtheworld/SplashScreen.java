package com.example.knowtheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar pb;
    private int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        pb = findViewById(R.id.pbar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                startapp();
            }
        });
        thread.start();
    }
    public void dowork(){
        for (progress = 20; progress <= 100; progress = progress+20){
            try {
                Thread.sleep(1000);
                pb.setProgress(progress);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void startapp(){

        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();


    }
}