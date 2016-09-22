package com.naren.lab4;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap Map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Map = googleMap;
            // Add a marker in Sydney and move the camera
            LatLng walmart = new LatLng(29.7728201,-95.401322);
            Map.addMarker(new MarkerOptions().position(walmart).title("This is a walmart in Houston"));
            Map.moveCamera(CameraUpdateFactory.newLatLng(walmart));

        LatLng walmart1 = new LatLng(30.2322111,-97.8232981);
        Map.addMarker(new MarkerOptions().position(walmart1).title("This is a walmart in Austin"));
        Map.moveCamera(CameraUpdateFactory.newLatLng(walmart1));


        LatLng walmart2 = new LatLng(39.0747105,-94.6559528);
        Map.addMarker(new MarkerOptions().position(walmart2).title("This is a walmart in Kansas city"));
        Map.moveCamera(CameraUpdateFactory.newLatLng(walmart2));


        LatLng walmart3 = new LatLng(39.189851,-94.546622);
        Map.addMarker(new MarkerOptions().position(walmart3).title("This is a walmart in kansas city"));
        Map.moveCamera(CameraUpdateFactory.newLatLng(walmart3));

        LatLng walmart4 = new LatLng(39.225427,-94.545685);
        Map.addMarker(new MarkerOptions().position(walmart4).title("This is a walmart kansas city"));
        Map.moveCamera(CameraUpdateFactory.newLatLng(walmart4));

    }

}
