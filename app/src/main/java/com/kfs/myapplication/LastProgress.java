package com.kfs.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LastProgress extends AppCompatActivity {

    ProgressBar progressBar ,progressBar2;
    Button button,button2;
    int counter = 0;
    int counter2 = 0;
    TextView textView,textView2;

    CountDownTimer countDownTimer ;

    int t=30000;
    int r=30;
    int seconds =0;
    long timerProgress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_progress);

        progressBar = findViewById(R.id.progress);
        button = findViewById(R.id.btnLast);
        textView = findViewById(R.id.textt);
      /*
        progressBar2 = findViewById(R.id.progress2);
        button2 = findViewById(R.id.btnLast2);
        textView2 = findViewById(R.id.textt2);*/

        seconds = 30*1000;
        progressBar.setMax(175800);
        countDownTimer = new CountDownTimer(30000, 10
        ) {
            //on start countDownTimer
            @Override
            public void onTick(long millisUntilFinished) {

               // timerProgress = seconds - millisUntilFinished;


                counter = counter+100;
                Log.e("hi","hhh / "+t);
                if(t%30==0)
                {
                    textView.setText("fq"+t);
                }
                t = t-10;
                progressBar.setProgress(counter);

            }

            //when finish count timer
            @Override
            public void onFinish() {

                progressBar.setVisibility(View.INVISIBLE);
            }
        };


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();

            }
        });
/*


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });*/
    }

    private void startAnimation(){

        /*
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar2, "progress", 0, 30000);

        progressAnimator.setDuration(1000);
        //progressBar2.setProgress(1000);
        progressAnimator.setInterpolator(new DecelerateInterpolator());
        progressAnimator.start();*/
        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar2, "progress", 0, 500);
        animation.setDuration(30000); // 3.5 second
        animation.setInterpolator(new LinearInterpolator());
        animation.start();
    }
}