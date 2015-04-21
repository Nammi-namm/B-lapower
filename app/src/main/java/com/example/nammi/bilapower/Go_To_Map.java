package com.example.nammi.bilapower;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Go_To_Map extends FragmentActivity {
    String stringData = null, url = null;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go__to__map);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        Intent intent = getIntent();

        if (null != intent) {
            stringData= intent.getStringExtra("key");
        }

        if (stringData.contains("Atlants Olía")){


            mMap.addMarker(new MarkerOptions().position(new LatLng(64.076044, -21.935466)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.aosmall)));
        }else if (stringData.contains("Olís")){
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1051445, -21.8677166)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.olissmall)));
        }else if (stringData.contains("N1")){
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1051445, -21.8677166)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.n1small)));
        }else if (stringData.contains("Orkan")){
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1493577, -21.8677166)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1446572, -21.9846398)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1181067, -21.8048556)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1324519, -21.7982517)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1106202, -21.8938124)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1316778, -21.8521946)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1497757, -21.9175275)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.0636645, -21.7878699)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1512836, -21.9675039)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1051445, -21.8677166)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.orkansmall)));
        }else if (stringData.contains("Shell")){
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1051445, -21.8677166)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.shellsmall)));
        }else if (stringData.contains("Ódýrt Bensín")){
            mMap.addMarker(new MarkerOptions().position(new LatLng(64.1397133, -21.9214302)).title("Marker").icon(BitmapDescriptorFactory.fromResource(R.drawable.obsmall)));
        }
    }
}
