package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SqlLiteActivity extends AppCompatActivity {

    EditText name,mail,id;
    TextView setmail;
    StudentHelper studentHelper;
    SQLiteDatabase db;

    String nameStr,mailStr;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);
        name=findViewById(R.id.name);
        mail=findViewById(R.id.mail);
        id=findViewById(R.id.sid);
        setmail=findViewById(R.id.setmail);

        studentHelper=new StudentHelper(this);
        db=studentHelper.getReadableDatabase();

    }

    public void delete(View view) {

        value=Integer.parseInt(id.getText().toString());

        long set=studentHelper.delete(db,value);

        if(set==0)
        {
            Toast.makeText(this, "No Record is Exist", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, " Record Delete Successfully", Toast.LENGTH_SHORT).show();

        }
    }

    public void update(View view) {

        nameStr=name.getText().toString();
        mailStr=mail.getText().toString();
        value=Integer.parseInt(id.getText().toString());

        long set=studentHelper.updateMethod(db,value,nameStr,mailStr);

        if(set==0)
        {
            Toast.makeText(this, "No Record is Exist", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, " Record Updated Successfully", Toast.LENGTH_SHORT).show();

        }
    }

    public void read(View view) {
    }

    public void insert(View view) {

       // setmail.setText(""+name.getText().toString());

        nameStr=name.getText().toString();
        mailStr=mail.getText().toString();
        value=Integer.parseInt(id.getText().toString());

        long set=studentHelper.createMethod(db,value,nameStr,mailStr);

        if(set==-1)
        {
            Toast.makeText(this, "Record Already Exist", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "New Record Created Successfully", Toast.LENGTH_SHORT).show();

        }




    }
}