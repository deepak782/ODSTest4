package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String value1,value2,value3;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView);

        sharedPreferences=getSharedPreferences("MAIN",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        value1=sharedPreferences.getString("value","");
        value2=sharedPreferences.getString("value1","");
        value3=sharedPreferences.getString("value2","");

        textView.setText(""+value1+"\n"+value2+"\n"+value3);
    }
}