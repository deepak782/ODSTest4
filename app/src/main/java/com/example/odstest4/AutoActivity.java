package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    String[] Courses={"Android","Java","JavaScripit","Python","Ios"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        autoCompleteTextView=findViewById(R.id.auto_complete);
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.select_dialog_item,Courses);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}