package com.example.odstest4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {


    Spinner countrySpinner;
    GridView gridView;

    CountryModel countryModel;
    CountryAdapter countryAdapter;
    List<CountryModel> countryModelList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    String[] indiaarray={"Ap","Ts","Mp","Tn"};
    String[] pakistanarray={"tt1","tt2","tt3","tt4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        countrySpinner=findViewById(R.id.CountrySpinner);
        gridView=findViewById(R.id.gridView);


        countryAdapter=new CountryAdapter(this,countryModelList);
        countrySpinner.setAdapter(countryAdapter);

        loadCountries();


        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                /*if(countryModelList.get(i).getName().equals("India"));
                {
                    arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,indiaarray);
                    gridView.setAdapter(arrayAdapter);
                }
                if(countryModelList.get(i).getName().equals("Pakistan"));
                {
                    arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,pakistanarray);
                    gridView.setAdapter(arrayAdapter);
                }*/

                Toast.makeText(TaskActivity.this, ""+countryModelList.get(i).getName(), Toast.LENGTH_SHORT).show();


                if(countryModelList.get(i).getName()=="India")
                {
                    arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,indiaarray);
                    gridView.setAdapter(arrayAdapter);
                }
                else if(countryModelList.get(i).getName()=="Pakistan")
                {
                    arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,pakistanarray);
                    gridView.setAdapter(arrayAdapter);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadCountries() {

        countryModel=new CountryModel(R.drawable.ic_baseline_announcement_24,"India");
        countryModelList.add(countryModel);
        countryModel=new CountryModel(R.drawable.ic_launcher_background,"Pakistan");
        countryModelList.add(countryModel);

        countryAdapter.notifyDataSetChanged();
    }
}