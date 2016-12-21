package edu.upc.jonatan.conexionapi;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

import static edu.upc.jonatan.conexionapi.ActListCostum.arrayPoke;

public class ListaPokemon extends ListActivity {

    //Array per asociar el adaptador
    static final String[] arrayMontains = new String[]{
            "Pikachu",
            "Charmander",
            "Squirtle",
            "Bulbasaur",
            "Raichu",
            "Charizard",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Crear adaptador, an base al layout
        setListAdapter( new ArrayAdapter<String> (this, R.layout.llitam, arrayPoke ));

        //Associem Lisv.adaptador a la vista.
        ListView lisv = getListView();
        lisv.setTextFilterEnabled(true);

        lisv.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
