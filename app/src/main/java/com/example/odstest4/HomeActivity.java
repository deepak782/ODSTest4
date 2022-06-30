package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView  displayMobile;

    String getNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        displayMobile=findViewById(R.id.display_txt1);

        sharedPreferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        getNumber=sharedPreferences.getString("mobile","");
        displayMobile.setText(""+getNumber);

    }

    public void logout(View view) {

        editor.clear();
        editor.commit();
        finish();

        startActivity(new Intent(HomeActivity.this,LoginActivity.class));
    }
}