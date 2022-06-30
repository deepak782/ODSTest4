package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;

public class SpalshActivity extends AppCompatActivity {

    ProgressBar progressBar;

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        progressBar=findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);

        countDownTimer=new CountDownTimer(3000,500) {
            @Override
            public void onTick(long l) {


            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SpalshActivity.this,LoginActivity.class));
                finish();
            }
        }.start();
    }
}