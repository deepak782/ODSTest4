package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText editText;
    String string_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText=findViewById(R.id.mobile_edt);
        sharedPreferences=getSharedPreferences("LOGIN",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void login(View view) {
       // String value="1234567890";
        string_mobile=editText.getText().toString();

        editor.putString("mobile",string_mobile);
        editor.putBoolean("status",true);
        editor.commit();
        startActivity(new Intent(LoginActivity.this,AutoActivity.class));
        finish();


        /*if(TextUtils.isEmpty(string_mobile))
        {
            editText.setError("Enter Mobile Number");
        }

        else if(string_mobile.trim().equals(value))
        {

        }*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(sharedPreferences.getBoolean("status",false)==true)
        {
            startActivity(new Intent(LoginActivity.this,AutoActivity.class));
            finish();

        }
        else
        {
            Toast.makeText(this, "Please Login", Toast.LENGTH_SHORT).show();
        }
    }
}