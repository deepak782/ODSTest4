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

    StateModel stateModelIndia,stateModelchina;
    StateAdapter stateAdapter;
    List<StateModel> stateModelList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        countrySpinner=findViewById(R.id.CountrySpinner);
        gridView=findViewById(R.id.gridView);


        countryAdapter=new CountryAdapter(this,countryModelList);
        countrySpinner.setAdapter(countryAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(TaskActivity.this, ""+stateModelList.get(i).getStatecm()+"\n"+
                        stateModelList.get(i).getStatename(), Toast.LENGTH_SHORT).show();
            }
        });

        loadCountries();
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                Toast.makeText(TaskActivity.this, ""+countryModelList.get(i).getName(), Toast.LENGTH_SHORT).show();


                if(countryModelList.get(i).getName()=="India")
                {
                    indiaStates();
                }
                else if(countryModelList.get(i).getName()=="China")
                {
                    chinaStates();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void chinaStates() {

        stateModelList.clear();

        stateModelchina=new StateModel("CHINA STATE 1","CHINA CM1",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelchina);
        stateModelchina=new StateModel("CHINA STATE 2","CHINA CM2",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelchina);
        stateModelchina=new StateModel("CHINA STATE 3","CHINA CM3",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelchina);
        stateModelchina=new StateModel("CHINA STATE 4","CHINA CM4",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelchina);
        stateModelchina=new StateModel("CHINA STATE 5","CHINA CM5",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelchina);

        stateAdapter=new StateAdapter(getApplicationContext(),stateModelList);
        gridView.setAdapter(stateAdapter);
    }

    private void indiaStates() {
        stateModelList.clear();
        stateModelIndia=new StateModel("INDIA STATE 1","CM1",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelIndia);
        stateModelIndia=new StateModel("INDIA STATE 2","CM2",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelIndia);
        stateModelIndia=new StateModel("INDIA STATE 3","CM3",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelIndia);
        stateModelIndia=new StateModel("INDIA STATE 4","CM4",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelIndia);
        stateModelIndia=new StateModel("INDIA STATE 5","CM5",R.drawable.ic_baseline_announcement_24);
        stateModelList.add(stateModelIndia);

        stateAdapter=new StateAdapter(getApplicationContext(),stateModelList);
        gridView.setAdapter(stateAdapter);
    }

    private void loadCountries() {

        countryModel=new CountryModel(R.drawable.ic_baseline_announcement_24,"India");
        countryModelList.add(countryModel);
        countryModel=new CountryModel(R.drawable.ic_launcher_background,"China");
        countryModelList.add(countryModel);

        countryAdapter.notifyDataSetChanged();
    }
}