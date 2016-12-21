package edu.upc.jonatan.conexionapi.API;


import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import edu.upc.eetac.dsa.muntanyes.ProfemonLocationResult;

/**
 * Created by jonatan on 12/12/16.
 */

public class APIpoke {
    public final static String TAG="PokEETAC";
    static String BASE_URL = "http://10.0.0.2:9080/myapp/eetakemon";
    static String res="";


    public APIpoke() {

    }
    public static String getPokemon() {
        Log.i(TAG, "****************************** get Pokemon!!!!!!");
        AsyncHttpClient client;
        client = new AsyncHttpClient();
        client.get(BASE_URL + "myresource/listar", null, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.i(TAG, responseString);
                res = responseString;
            }
        });
        return res;
    }
}
