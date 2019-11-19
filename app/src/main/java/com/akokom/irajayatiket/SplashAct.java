package com.akokom.irajayatiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashAct extends AppCompatActivity {

    Animation app_splash, bottomtotopalpha;
    ImageView app_logo;
    TextView app_subtittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        bottomtotopalpha = AnimationUtils.loadAnimation(this, R.anim.bottomtotopalpha);

        //load element
        app_logo = findViewById(R.id.app_logo);
        app_subtittle = findViewById(R.id.app_subtittle);

        //run animation
        app_logo.startAnimation(app_splash);
        app_subtittle.startAnimation(bottomtotopalpha);

        //setting timer untuk 1 detik
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //merubah activity ke activity lain
                Intent gogetstarted = new Intent(SplashAct.this, GetStartedAct.class);
                startActivity(gogetstarted);
                finish();
            }
        }, 2000); /*1000 ms = 1 s*/
    }
}
