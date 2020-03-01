package com.example.retail;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retail.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

class Mylistadapter extends ArrayAdapter<ItemModel> {
    private final Activity context;
    private final ArrayList<ItemModel> d1;

    public Mylistadapter(Activity context,ArrayList<ItemModel> d1)
    {
        super(context,R.layout.mylist,d1);
        this.context=context;
        this.d1=d1;


    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView name5 = (TextView) rowView.findViewById(R.id.name5);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView desc5 = (TextView) rowView.findViewById(R.id.desc5);
        TextView price5 = (TextView) rowView.findViewById(R.id.price5);
        TextView discount5 = (TextView) rowView.findViewById(R.id.discount5);
        ItemModel item6=d1.get(position);
        name5.setText(item6.getName());
        desc5.setText(item6.getDesc());
        price5.setText(item6.getPrice());
        discount5.setText(item6.getDiscount());


        return rowView;

    };

}
