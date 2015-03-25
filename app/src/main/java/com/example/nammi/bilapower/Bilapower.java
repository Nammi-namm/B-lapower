package com.example.nammi.bilapower;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;


public class Bilapower extends ActionBarActivity {

    ListView listView; // Skilgreinum ListView
    Power_Adapter adapter; // Skilgreinum tilvik af adapternum *okkar*

    String[] fruitBasket; // Skilgreinum fylki sem inniheldur alla ávexti
    ArrayList<String> fruits; // Skilgreinum fylki sem inniheldur ávexti sem eru í ListView-inu núna

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilapower);

        // Náum í ávextina úr strings.xml (sem er resource skrá)
        fruitBasket = getResources().getStringArray(R.array.fruit_basket);
        fruits = new ArrayList<String>();

        // Upphafsstillum ListView og Adapter
        listView = (ListView) findViewById(R.id.listView);
        adapter = new Power_Adapter(this, fruits); // FruitAdapterinn gerir sjálfkrafa ráð fyrir ArrayList<String> og fruit_layout, svo ekki þarf að skilgreina það

        // Tengjum ListView og Adapter saman
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                // Náum í nafnið á ávextinum sem smellt var á
                String theFruit = fruits.get(position);
                Intent myIntent = new Intent(view.getContext(), Go_To_Map.class);
                /*if (theFruit.contains("Starwars 1")){
                    //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imdb.com/title/tt0120915/?ref_=tt_rec_tti"));
                    //startActivity(intent);
                }else if (theFruit.contains("Starwars 2")){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imdb.com/title/tt0121765/?ref_=tt_rec_tti"));
                    startActivity(intent);
                }
                else if (theFruit.contains("Starwars 3")){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imdb.com/title/tt0121766/?ref_=tt_rec_tti"));
                    startActivity(intent);
                }
                else if (theFruit.contains("Starwars 4")){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imdb.com/title/tt0076759/?ref_=nv_sr_2"));
                    startActivity(intent);
                }
                else if (theFruit.contains("Starwars 5")){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imdb.com/title/tt0080684/?ref_=tt_rec_tti"));
                    startActivity(intent);
                }
                else if (theFruit.contains("Starwars 6")){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imdb.com/title/tt0086190/?ref_=tt_rec_tti"));
                    startActivity(intent);
                }
*/
                myIntent.putExtra("key",theFruit);
                startActivityForResult(myIntent, 0);
                // Sýnum nafnið
                //Toast.makeText(getApplicationContext(), "Þetta er " + theFruit + "!", Toast.LENGTH_SHORT).show();
            }
        };
        listView.setOnItemClickListener(listener); // Tengjum saman ListView og listener

        int i = 0;
        int n = fruitBasket.length;
        do {
            Random random = new Random(); // Búum til random generator
            String fruit = fruitBasket[i]; // Náum í nafnið á slembnum ávexti
            fruits.add(fruit); // Bætum ávextinum í ArrayListann sem liggur að baki ListView-inu
            i++;
        }while (i < n);


        adapter.notifyDataSetChanged(); // Látum adapterinn vita að gögnin hafi breyst

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bilapower, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
