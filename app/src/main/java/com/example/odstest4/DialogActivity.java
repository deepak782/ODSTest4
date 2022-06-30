package com.example.odstest4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void simple(View view) {

        AlertDialog.Builder builder=new AlertDialog.Builder(DialogActivity.this);
        builder.setTitle("Hello Android");
        builder.setMessage("Welcome to Simple Alert Dialog");
        builder.setIcon(R.drawable.ic_baseline_announcement_24);
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, "No", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });


        builder.setNeutralButton("Hepl!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, "Help", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();

            }
        });

        builder.create();
        builder.show();

    }

    public void custom(View view) {

        AlertDialog.Builder builder=new AlertDialog.Builder(DialogActivity.this);
        View root=getLayoutInflater().inflate(R.layout.custom_dialog,null);
        builder.setView(root);
        builder.setCancelable(false);

        Button cancel=root.findViewById(R.id.cancel);
        Button ok=root.findViewById(R.id.ok);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(DialogActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(DialogActivity.this, "Ok", Toast.LENGTH_SHORT).show();

                alertDialog.dismiss();


            }
        });

        alertDialog=builder.create();
        alertDialog.show();
    }
}