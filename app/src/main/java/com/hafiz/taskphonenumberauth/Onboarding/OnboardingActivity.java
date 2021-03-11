package com.hafiz.taskphonenumberauth.Onboarding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.hafiz.taskphonenumberauth.MainActivity;
import com.hafiz.taskphonenumberauth.PhoneAuthActivity;
import com.hafiz.taskphonenumberauth.R;


public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        makeStatusbarTransparent();

        viewPager = findViewById(R.id.onboarding_view_pager);
        button4=findViewById(R.id.button4);

        OnboardingAdapter onboardingAdapter = new OnboardingAdapter(this);
        viewPager.setAdapter(onboardingAdapter);
        viewPager.setPageTransformer(false, new OnboardingPageTransformer());

        if (!isFirstTimeStartApp()) {

            startMainActivity();
            finish();
        }



    }

    private void startMainActivity() {
        setFirstTimeStartStatus(false);
        startActivity(new Intent(OnboardingActivity.this, PhoneAuthActivity.class));
        finish();
    }

    private boolean isFirstTimeStartApp() {
        SharedPreferences ref = getApplicationContext().getSharedPreferences("Intro Screen", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag", true);
    }

    private void setFirstTimeStartStatus(boolean b) {
        SharedPreferences ref = getApplicationContext().getSharedPreferences("Intro Screen", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag", false);
        editor.apply();
    }


    // Listener for next button press
    public void nextPage(View view) {
        if (view.getId() == R.id.button1) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        }
        else if (view.getId() == R.id.button2){
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);

        }
        else if (view.getId() == R.id.button3){
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);

        }
        else if (view.getId() == R.id.button4){
           startMainActivity();
        }
    }

    private void makeStatusbarTransparent() {

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
