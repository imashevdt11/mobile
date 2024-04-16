package com.example.avatarbook;

import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    LottieAnimationView lotty_logo;

    TextView text_logo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lotty_logo = findViewById(R.id.lotty_logo);
        text_logo = findViewById(R.id.text_logo);

        lotty_logo.setAnimation(R.raw.contacts);

        lotty_logo.animate().alpha(1f).setDuration(5000).withEndAction(() -> {
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        text_logo.animate().alpha(1f).setDuration(2000).withEndAction(() -> {
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}