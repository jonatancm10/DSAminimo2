package edu.upc.jonatan.conexionapi;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class ActListCostum extends ListActivity {

    //Array per assosiar el adaptador
    static final String[] arrayPoke = new String[]{
            "Pikachu",
            "Charmander",
            "Squirtle",
            "Bulbasaur",
            "Raichu",
            "Charizard",

    };
    static final String[] arrayPuntos = new String[]{
            "1705", "3355", "3546", "1234","2345", "1435","3658"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ElmeuArrayAdapter(this, arrayPoke));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){

        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
        Intent showinfo = new Intent(ActListCostum.this, infoPokemon.class);
        showinfo.putExtra("textInfo", arrayPuntos[position]);
        startActivity(showinfo);

        //setListAdapter(new ImageInfo(this, arrayAltitude));

    }


}
