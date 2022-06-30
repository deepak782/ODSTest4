package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText value,value1,value2;
    TextView display;
    String valueStr,valueStr1,valueStr2,getValue,getValue1,getValue2;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value=findViewById(R.id.edt_value);
        value1=findViewById(R.id.edt_value1);
        value2=findViewById(R.id.edt_value2);
        display=findViewById(R.id.display_txt);

        sharedPreferences=getSharedPreferences("MAIN",MODE_PRIVATE);
        editor=sharedPreferences.edit();


        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valueStr=value.getText().toString();
                valueStr1=value1.getText().toString();
                valueStr2=value2.getText().toString();

                editor.putString("value",valueStr);
                editor.putString("value1",valueStr1);
                editor.putString("value2",valueStr2);
                editor.commit();

                /*if(TextUtils.isEmpty(valueStr))
                {
                    Toast.makeText(MainActivity.this, "Add Value", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(valueStr1))
                {
                    Toast.makeText(MainActivity.this, "Add Value", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(valueStr2))
                {
                    Toast.makeText(MainActivity.this, "Add Value", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    editor.putString("value",valueStr);
                    editor.commit();

                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }*/

            }
        });
        findViewById(R.id.read_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences=getSharedPreferences("MAIN",MODE_PRIVATE);
                editor=sharedPreferences.edit();

                getValue=sharedPreferences.getString("value","");
                getValue1=sharedPreferences.getString("value1","");
                getValue2=sharedPreferences.getString("value2","");
                display.setText(""+getValue+"\n"+getValue1+"\n"+getValue2);

            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });
    }
}