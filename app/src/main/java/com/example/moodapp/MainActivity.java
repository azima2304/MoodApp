package com.example.moodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button generateButton;
    TextView procentText, answerText;
    int procent;
    Random random = new Random();
    LottieAnimationView lotty_sun, lotty_fun, lotty_secondfun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateButton =findViewById(R.id.btm_generate);
        procentText = findViewById(R.id.txt_procent);
        answerText = findViewById(R.id.txt_mainAnswer);
        lotty_sun = findViewById(R.id.lotty_sun);
        lotty_fun = findViewById(R.id.lotty_fun);
        lotty_secondfun = findViewById(R.id.lotty2_fun);

        lotty_sun.setAnimation(R.raw.sunshine);
        lotty_fun.setAnimation(R.raw.animation_fire);
        lotty_secondfun.setAnimation(R.raw.fun_time);


        lotty_fun.setVisibility(View.INVISIBLE);
        lotty_secondfun.setVisibility(View.INVISIBLE);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procent = random.nextInt(101);
                procentText.setText(String.valueOf(procent));
                if (procent>0){
                    printAnswer();
                    generateButton.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    void printAnswer(){
        if(procent<40){
            answerText.setText("You'll definitely get lucky tomorrow!");
            lotty_secondfun.setVisibility(View.VISIBLE);
        } else{
            answerText.setText("Cool!");
            lotty_fun.setVisibility(View.VISIBLE);
        }

    }
}