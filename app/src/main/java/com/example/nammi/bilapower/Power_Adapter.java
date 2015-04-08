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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
        List<String> bensinarray = (Arrays.asList("201.52","199.85","205.55","200.55","203.15","202.58"));;
        List<String> diselarray = (Arrays.asList("203.21","200.55","201.33","200.25","207.12","204.30"));;
        List<String> metanarray = (Arrays.asList("N/A"," N/A","189.99"," N/A"," N/A","188.85"));;
        // "Blásum upp" viewið (aukaatriði í bili)
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_power__adapter, parent, false);

        // Náum í vísanir í viewin sem item-inn okkar inniheldur
        TextView textView_bensin = (TextView) rowView.findViewById(R.id.bensin);
        TextView textView_disel = (TextView) rowView.findViewById(R.id.disel);
        TextView textView_metan = (TextView) rowView.findViewById(R.id.metan);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.fruit_picture);

        // Náum í nafnið á tilheyrandi ávexti
        String ting = values.get(position);
        String bensinfuel = bensinarray.get(position);
        String diselfuel = diselarray.get(position);
        String metanfuel = metanarray.get(position);



        // Setjum nafnið í TextView-ið okkar
        textView_bensin.setText(bensinfuel);
        textView_disel.setText(diselfuel);
        textView_metan.setText(metanfuel);

        // Skiptum um mynd ef við erum með "epli".
        if (ting.contains("Olís")) {
            imageView.setImageResource(R.drawable.olis2);
        } else if (ting.contains("N1")) {
            imageView.setImageResource(R.drawable.n1_2);
        }else if (ting.contains("Orkan")) {
            imageView.setImageResource(R.drawable.orkan2);
        }else if (ting.contains("Shell")) {
            imageView.setImageResource(R.drawable.shell2);
        }else if (ting.contains("Ódýrt Bensín")) {
            imageView.setImageResource(R.drawable.ob2);
        }

        return rowView;
    }
}
