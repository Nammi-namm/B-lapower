package com.example.nammi.bilapower;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class Power_Adapter extends ArrayAdapter {

    private Context context;
    private ArrayList<String> values;

    public Power_Adapter(Context context, ArrayList<String> values) {
        super(context, R.layout.activity_power__adapter, values); // Köllum á smiðinn í ArrayAdapter klasanum
        this.context = context; // Vistum það sem við tökum inn sem tilviksbreytur
        this.values = values;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // "Blásum upp" viewið (aukaatriði í bili)
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_power__adapter, parent, false);

        // Náum í vísanir í viewin sem item-inn okkar inniheldur
        TextView textView = (TextView) rowView.findViewById(R.id.fruit_text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.fruit_picture);

        // Náum í nafnið á tilheyrandi ávexti
        String fruitName = values.get(position);



        // Setjum nafnið í TextView-ið okkar
        textView.setText(fruitName);

        // Skiptum um mynd ef við erum með "epli".
        if (fruitName.contains("Olís")) {
            imageView.setImageResource(R.drawable.olis2);
        } else if (fruitName.contains("N1")) {
            imageView.setImageResource(R.drawable.n1_2);
        }else if (fruitName.contains("Orkan")) {
            imageView.setImageResource(R.drawable.orkan2);
        }else if (fruitName.contains("Shell")) {
            imageView.setImageResource(R.drawable.shell2);
        }else if (fruitName.contains("Ódýrt Bensín")) {
            imageView.setImageResource(R.drawable.ob2);
        }

        return rowView;
    }
}
