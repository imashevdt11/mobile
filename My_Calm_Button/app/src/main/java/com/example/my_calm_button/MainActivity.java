package com.example.my_calm_button;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnGenerate;
    TextView tvAnswer, tvMainAnswer;
    int answerInt, genAnswerInt;
    LottieAnimationView lottySun, lottyOne, lottyTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottySun = findViewById(R.id.lottySun);
        lottyOne = findViewById(R.id.lottyOne);
        lottyTwo = findViewById(R.id.lottyTwo);
        tvAnswer = findViewById(R.id.tvAnswer);
        tvMainAnswer = findViewById(R.id.tvMainAnswer);
        btnGenerate = findViewById(R.id.btnGenerate);

        lottySun.setAnimation(R.raw.sunshine);
        lottyOne.setAnimation(R.raw.animation_fire);
        lottyTwo.setAnimation(R.raw.fun_time);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                genAnswerInt = random.nextInt(100);
                answerInt = genAnswerInt;

                if (answerInt > 0) {
                    tvAnswer.setText(answerInt + " %");
                    printAnswer();
                } else {
                    Toast.makeText(MainActivity.this, "Нажми 'Generate' еще раз", Toast.LENGTH_LONG).show();
                    btnGenerate.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private void printAnswer() {
        if (answerInt >= 1 && answerInt <= 48) {
            tvMainAnswer.setText("Завтра может в чем-то повезти");
            lottyTwo.setVisibility(View.VISIBLE);
            lottyOne.setVisibility(View.INVISIBLE);
        } else if (answerInt > 48 && answerInt <= 65) {
            tvMainAnswer.setText("Мы рады, что ты - почти оптимист!");
            lottyTwo.setVisibility(View.VISIBLE);
            lottyOne.setVisibility(View.INVISIBLE);
        } else {
            tvMainAnswer.setText("Супер! Отлично, я рад за тебя!");
            lottyOne.setVisibility(View.VISIBLE);
            lottyTwo.setVisibility(View.INVISIBLE);
        }
    }
}