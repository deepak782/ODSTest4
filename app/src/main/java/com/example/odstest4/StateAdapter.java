package com.example.odstest4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StateAdapter extends BaseAdapter implements Filterable {
    Context context;
    List<StateModel> stateModelList=new ArrayList<>();
    LayoutInflater inflater;

    public StateAdapter(Context context, List<StateModel> stateModelList) {
        this.context = context;
        this.stateModelList = stateModelList;

        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return stateModelList.size();
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
        View root=inflater.inflate(R.layout.custom_state,null);
        TextView statename=root.findViewById(R.id.sname1);
        statename.setText(""+stateModelList.get(i).getStatename());
        return root;
    }

    @Override
    public Filter getFilter() {
        Filter filter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            }
        };
        return filter;
    }
}
