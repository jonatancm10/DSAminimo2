package edu.upc.jonatan.conexionapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jonatan on 05/12/2016.
 */
public class ElmeuArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public ElmeuArrayAdapter(Context context, String[] values) {
        super(context, R.layout.listamcost, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listamcost, parent, false);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo2);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        textView.setText(values[position]);
        setTextAndLogoOfRow(values[position], textView, imageView);

        return rowView;
    }

        public void setTextAndLogoOfRow (String rowText, TextView textView, ImageView imageView1) {
            textView.setText(rowText);
            switch (rowText) {
                case "Montseny":
                    imageView1.setImageResource(R.drawable.pikachu);
                    break;
                case "Mont perdut":
                    imageView1.setImageResource(R.drawable.pikachu);
                    break;
                case "Torre de Saruman":
                    imageView1.setImageResource(R.drawable.pikachu);
                    break;
            }
        }
}
