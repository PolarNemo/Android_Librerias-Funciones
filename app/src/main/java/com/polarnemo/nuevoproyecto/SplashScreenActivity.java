package com.polarnemo.nuevoproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH_TIMEDISPLAY_LENGTH = 3500;

    private static final String TAG = "SplashScreenActivity|NP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: Starting the splash");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Log.i(TAG, "onCreate: Starting the Handler");
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Log.i(TAG, "run: Handler started");
                Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
                SplashScreenActivity.this.startActivity(intent);
                SplashScreenActivity.this.finish();
                Log.i(TAG, "run: End of the Handler");
            }
        }, SPLASH_TIMEDISPLAY_LENGTH);

        Log.i(TAG, "onCreate: Ending The Splash");
    }

}
