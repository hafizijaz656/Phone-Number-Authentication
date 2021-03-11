package com.hafiz.taskphonenumberauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hafiz.taskphonenumberauth.Onboarding.OnboardingActivity;

import java.util.Objects;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageView imageView = findViewById(R.id.gasDelivery);

        Animation aniFade = AnimationUtils.loadAnimation(this,R.anim.splash_screen);
        imageView.startAnimation(aniFade);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreenActivity.this, OnboardingActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}