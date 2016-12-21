package edu.upc.jonatan.conexionapi;


import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class infoPokemon extends AppCompatActivity {

    TextView textInfo;
    ImageView logo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pokemon);

        textInfo = (TextView) findViewById(R.id.textInfo);

        Bundle intentData = getIntent().getExtras();

        String info = intentData.getString("textInfo");
        textInfo.setText(info);
        setPokeImagen(info,logo2);
    }

    public void setPokeImagen(String nom, ImageView logo2) {
        switch (nom) {
            case "Pikachu":
                logo2.setImageResource(R.drawable.pikachu);
                break;
            case "Charmander":
                logo2.setImageResource(R.drawable.pikachu);
                break;
            case "Squirtle":
                logo2.setImageResource(R.drawable.pikachu);
                break;
            case "Bulbasaur":
                logo2.setImageResource(R.drawable.pikachu);
                break;
            case "Raichu":
                logo2.setImageResource(R.drawable.pikachu);
                break;
            case "Charizard":
                logo2.setImageResource(R.drawable.pikachu);
                break;
            default:
                break;
        }
    }
}

