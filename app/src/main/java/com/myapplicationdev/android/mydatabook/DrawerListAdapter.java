package com.myapplicationdev.android.mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerListAdapter<S> extends ArrayAdapter<String> {
    Context context;
    String[] titles;
    int resource;

    TextView tvTitle;
    ImageView iv;

    public DrawerListAdapter(Context context, int resource, String[] titles) {
        super(context, resource, titles);
        this.context = context;
        this.titles = titles;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        tvTitle = rowView.findViewById(R.id.tvList);
        iv = rowView.findViewById(R.id.iv);

        if (titles[position].equals("Bio")){
            iv.setImageResource(R.drawable.ic_bio);
            tvTitle.setText(titles[position]);
        }else if (titles[position].equals("Vaccination")){
            iv.setImageResource(R.drawable.ic_vaccine);
            tvTitle.setText(titles[position]);

        }else if (titles[position].equals("Anniversary")){
            iv.setImageResource(R.drawable.ic_anni);
            tvTitle.setText(titles[position]);

        }else if (titles[position].equals("About Us")){
            iv.setImageResource(R.drawable.ic_about);
            tvTitle.setText(titles[position]);

        }


        return rowView;
    }
}
