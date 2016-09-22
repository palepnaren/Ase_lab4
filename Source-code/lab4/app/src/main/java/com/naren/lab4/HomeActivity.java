package com.naren.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import  okhttp3.Request;
import okhttp3.Response;


public class HomeActivity extends AppCompatActivity {

    String Text;
   TextView tv,tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome to HomeActivity page", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
    }

    public void displayMap(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void logout(View v){
        Intent nav = new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(nav);
    }

    public void walmartApi(View v){
        EditText et = (EditText) findViewById(R.id.txt_search);
        tv = (TextView) findViewById(R.id.textView);
        tv1 = (TextView) findViewById(R.id.textView3);
        tv2 = (TextView) findViewById(R.id.textView4);
        //tv3= (TextView) findViewById(R.id.textView5);
        //tv4= (TextView) findViewById(R.id.textView6);

        Text = et.getText().toString();

        String getURL = "http://api.walmartlabs.com/v1/search?apiKey=8fvbs9ask76hag28bq94v6fh&lsPublisherId=" +
                "&query="+Text+"&sort=bestseller&responseGroup=full";

        OkHttpClient client = new OkHttpClient();
        try {
            Request req = new Request.Builder()
                    .url(getURL)
                    .build();
            client.newCall(req).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println(e.getMessage());
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final JSONObject json_res;
                    final String result = response.body().string();

                    try {
                        json_res = new JSONObject(result);
                        final JSONArray convertedTextArray = json_res.getJSONArray("items");
                        for (int i = 0; i < convertedTextArray.length() - 1; i++) {

                            //final String convertedText = jsonResult.getJSONObject("items").getString("name");
                            final String display = convertedTextArray.getJSONObject(i).getString("name");
                            final String display1 = convertedTextArray.getJSONObject(i).getString("brandName");
                            final String display2 = convertedTextArray.getJSONObject(i).getString("shortDescription");
                            //final String display4 = convertedTextArray.getJSONObject(i).getString("modelNumber");
                            //final int display3 = convertedTextArray.getJSONObject(i).getInt("salePrice");

                            Log.i("okHttp", json_res.toString());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                     tv.setText(display);
                                    tv1.setText(display1);
                                    tv2.setText(display2);
                                    //tv3.setInputType(display3);
                                    //tv4.setText(display3);


                                }

                            });
                        }

                    }catch(JSONException e){
                        e.printStackTrace();
                    }

                }
            });


        } catch (Exception e) {
            e.printStackTrace();

        }

    }
            }

