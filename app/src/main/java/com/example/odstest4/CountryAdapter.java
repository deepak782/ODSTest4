package com.example.odstest4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends BaseAdapter {
    Context context;
    List<CountryModel> countryModelList=new ArrayList<>();

    LayoutInflater layoutInflater;

    public CountryAdapter(Context context, List<CountryModel> countryModelList) {
        this.context = context;
        this.countryModelList = countryModelList;

        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return countryModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.custom_task,null);
        ImageView imageView=root.findViewById(R.id.c_image);
        TextView name=root.findViewById(R.id.c_name);

        imageView.setImageResource(countryModelList.get(i).getImage());
        name.setText(countryModelList.get(i).getName());
        return root;
    }
}
