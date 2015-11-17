package br.com.simplelife.testgooglemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void toMapTypeMap(View v){
        changeMapTypeTo(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void toMapTypeSatalite(View v){
        changeMapTypeTo(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void toMapTypeHybrid(View v){
        changeMapTypeTo(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void changeMapTypeTo(int mapType){
        if(mMap != null)
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
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
        mMap = googleMap;
        // (-7.996928, -34.860721) Home
        // Add a marker in Sydney and move the camera
        LatLng newYork = new LatLng(-7.996928, -34.860721);
        CameraPosition target = CameraPosition.builder().target(newYork).zoom(14).build();
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
