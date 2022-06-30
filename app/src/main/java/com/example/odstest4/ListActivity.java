package com.example.odstest4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    String[] games={"Cricket","FootBall","Hockey","Ruby","VolleyBall"};
    ArrayAdapter<String> arrayAdapter;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.simpleList);
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,games);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder builder=new AlertDialog.Builder(ListActivity.this);
                View root=getLayoutInflater().inflate(R.layout.custom_dialog,null);
                builder.setView(root);
                builder.setCancelable(false);

                Button cancel=root.findViewById(R.id.cancel);
                Button ok=root.findViewById(R.id.ok);
                TextView message=root.findViewById(R.id.message_txt);
                message.setText(""+games[i]);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(ListActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(ListActivity.this, "Ok", Toast.LENGTH_SHORT).show();

                        alertDialog.dismiss();


                    }
                });

                alertDialog=builder.create();
                alertDialog.show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Games List");
                builder.setMessage("Welcome to "+games[i]+" Sporst Club");
                builder.setIcon(R.drawable.ic_baseline_announcement_24);
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ListActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ListActivity.this, "No", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });


                builder.setNeutralButton("Hepl!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ListActivity.this, "Help", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();

                    }
                });

                builder.create();
                builder.show();
            }
        });
    }
}